package com.ict.user.service;

import com.ict.user.common.response.ResponseModel;
import com.ict.user.domain.dto.UserRequestDto;

public interface UserService {

    ResponseModel createUser(UserRequestDto requestDto);

    ResponseModel getUser(Long id);

    ResponseModel getAllUser();

    ResponseModel updateUser(Long id, UserRequestDto requestDto);

    ResponseModel deleteUser(Long id);
}
