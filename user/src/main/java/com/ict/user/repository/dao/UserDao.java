package com.ict.user.repository.dao;

import com.ict.user.domain.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {

    private final MasterDao masterDao;

    public UserDao(MasterDao masterDao) {
        this.masterDao = masterDao;
    }

    public Optional<User> findById(Long id){
        return masterDao.getRepository().findById(id);
    }

    public List<User> findAll(){
        return masterDao.getRepository().findAll();
    }
}
