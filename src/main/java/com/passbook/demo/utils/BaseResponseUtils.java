package com.passbook.demo.utils;

import com.passbook.demo.response.BaseResponse;
import org.springframework.stereotype.Service;

@Service
public class BaseResponseUtils {

    public static BaseResponse createSuccessBaseResponse() {
        return BaseResponse.builder()
                .es(0)
                .message("Success")
                .status(200)
                .time(System.currentTimeMillis())
                .build();
    }

    public static BaseResponse createErrorBaseResponse() {
        return BaseResponse.builder()
                .es(1)
                .message("Failed!")
                .status(400)
                .time(System.currentTimeMillis())
                .build();
    }

    public static BaseResponse createErrorBaseResponse(String message) {
        return BaseResponse.builder()
                .es(1)
                .message(message)
                .status(400)
                .time(System.currentTimeMillis())
                .build();
    }

    public static BaseResponse createNoDataBaseResponse() {
        return BaseResponse.builder()
                .es(2)
                .message("No data found!")
                .status(300)
                .time(System.currentTimeMillis())
                .build();
    }

}
