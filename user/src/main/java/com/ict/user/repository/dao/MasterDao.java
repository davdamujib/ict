package com.ict.user.repository.dao;

import com.ict.user.repository.jpa.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class MasterDao {

    @Autowired
    private UserRepository repository;
}
