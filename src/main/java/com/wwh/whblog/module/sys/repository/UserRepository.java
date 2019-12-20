package com.wwh.whblog.module.sys.repository;

import com.wwh.whblog.module.sys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    List<User> findAll();

    User getUserById(String userId);

    User getUserByUserName(String userName);
}
