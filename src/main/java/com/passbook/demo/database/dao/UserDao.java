package com.passbook.demo.database.dao;

import com.passbook.demo.database.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends MongoRepository<User, String> {
    List<User> findAllByMobile(List<String> mobileNoList);
}
