package com.bincoding.nonprofit.repository;

import com.bincoding.nonprofit.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

        Optional<UserEntity> findByFname(String firstName);
        Optional<UserEntity> findByUsername(String userName);
        List<UserEntity> findAll();

}
