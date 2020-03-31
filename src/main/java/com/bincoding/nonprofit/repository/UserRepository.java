package com.bincoding.nonprofit.repository;

import com.bincoding.nonprofit.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

        List<UserEntity> findByFname(String FirstName);
        List<UserEntity> findAll();

}
