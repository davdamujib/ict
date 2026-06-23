package com.ict.user.service.impl;

import com.ict.user.common.response.ResponseModel;
import com.ict.user.domain.dto.UserRequestDto;
import com.ict.user.domain.dto.UserResponseDto;
import com.ict.user.domain.entity.User;
import com.ict.user.repository.dao.MasterDao;
import com.ict.user.repository.dao.UserDao;
import com.ict.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final MasterDao masterDao;

    public UserServiceImpl(UserDao userDao, MasterDao masterDao) {
        this.userDao = userDao;
        this.masterDao = masterDao;
    }

    @Override
    public ResponseModel createUser(UserRequestDto requestDto) {

        User user = UserRequestDto.request(requestDto);
        User saveUser = masterDao.getRepository().save(user);
        return ResponseModel.createResponse(
                HttpStatus.CREATED,
                "User Created",
                UserResponseDto.response(saveUser),
                null
        );
    }

    @Override
    public ResponseModel getUser(Long id) {

        User user = userDao.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));

        return ResponseModel.createResponse(
                HttpStatus.OK,
                "User Fetched Success",
                UserResponseDto.response(user),
                null
        );
    }

    @Override
    public ResponseModel getAllUser() {

        List<UserResponseDto> responseDto = userDao.findAll().stream()
                .map(UserResponseDto::response)
                .toList();

        return ResponseModel.createResponse(
                HttpStatus.OK,
                "User Fetched Success",
                responseDto,
                null
        );
    }

    @Override
    public ResponseModel updateUser(Long id, UserRequestDto requestDto) {

        User finduser = userDao.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));

         UserRequestDto.updateUser(finduser,requestDto);

         User saveUser = masterDao.getRepository().save(finduser);

        return ResponseModel.createResponse(
                HttpStatus.OK,
                "User Updated Successfully",
                UserResponseDto.response(saveUser),
                null
        );
    }

    @Override
    public ResponseModel deleteUser(Long id) {

        User findUser = userDao.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));

        masterDao.getRepository().deleteById(findUser.getId());

        return ResponseModel.createResponse(
                HttpStatus.OK,
                "User Deleted Success",
                null,
                null
        );
    }
}
