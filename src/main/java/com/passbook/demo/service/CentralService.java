package com.passbook.demo.service;

import com.passbook.demo.Request.CentralBaseRequest;
import com.passbook.demo.database.dao.UserDao;
import com.passbook.demo.database.entity.User;
import com.passbook.demo.response.BaseResponse;
import com.passbook.demo.response.CentralResponse;
import com.passbook.demo.utils.BaseResponseUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;


@Service
@Log4j2
public class CentralService {

    @Autowired
    UserDao userDao;

    @Async
    public void saveUserDetails(CentralBaseRequest centralBaseRequest) {
        User user = User.builder()
                .name(centralBaseRequest.getName())
                .mobile(centralBaseRequest.getMobile())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        userDao.save(user);
    }

    public BaseResponse getUserDetails(List<String> mobileNoList) {
        try {
            List<User> users;
            if(CollectionUtils.isEmpty(mobileNoList))
                users = userDao.findAll();
            else
                users = userDao.findAllByMobile(mobileNoList);

            if(CollectionUtils.isEmpty(users))
                return BaseResponseUtils.createNoDataBaseResponse();

            return CentralResponse.builder()
                    .users(users)
                    .es(0)
                    .message("success !")
                    .status(200)
                    .time(System.currentTimeMillis())
                    .build();
        }catch (Exception e){
            log.info("Error in saveUserDetails", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }
}
