package com.bincoding.nonprofit.repository;

import com.bincoding.nonprofit.dto.UserWithoutPass;
import com.bincoding.nonprofit.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

        Optional<UserEntity> findByFname(String firstName);
        Optional<UserEntity> findByUsername(String userName);
        Optional<UserEntity> findById(int id);

//        @RestResource(path="users")
        List<UserEntity> findAll();
        List<UserWithoutPass> findAllBy();
        Optional<UserWithoutPass> findWithoutPassById(int id);

        Optional<UserWithoutPass> findWithoutPassByUsername(String username);
}

