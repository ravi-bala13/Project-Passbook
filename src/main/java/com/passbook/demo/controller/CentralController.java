package com.passbook.demo.controller;

import com.passbook.demo.Request.CentralBaseRequest;
import com.passbook.demo.response.BaseResponse;
import com.passbook.demo.service.CentralService;
import com.passbook.demo.utils.BaseResponseUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/central")
@Log4j2
public class CentralController {

    @Autowired
    CentralService centralService;

    @ApiOperation("This api is used to add user in the db")
    @PostMapping("/add-user")
    public BaseResponse addUser(@RequestBody CentralBaseRequest centralBaseRequest){
        try {
            log.info("centralBaseRequest - {}", centralBaseRequest);
            if(StringUtils.isEmpty(centralBaseRequest.getName()) || StringUtils.isEmpty(centralBaseRequest.getMobile()))
                return BaseResponseUtils.createErrorBaseResponse("Username or Mobile must not be empty");

            centralService.saveUserDetails(centralBaseRequest);
            return BaseResponseUtils.createSuccessBaseResponse();
        }catch (Exception e){
            log.info("Error in addUser", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }

    @ApiOperation("This api is used to get user details from the db")
    @GetMapping("/get-users")
    public BaseResponse getUsers(@RequestBody(required = false) List<String> mobileNoList){
        try {
            return centralService.getUserDetails(mobileNoList);
        }catch (Exception e){
            log.info("Error in addUser", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }

    @ApiOperation("This api is used to add partner details in the db")
    @PostMapping("/add-partner")
    public BaseResponse addPartner(@RequestBody CentralBaseRequest centralBaseRequest){
        try {
            log.info("centralBaseRequest - {}", centralBaseRequest);
            if(StringUtils.isEmpty(centralBaseRequest.getName()) || StringUtils.isEmpty(centralBaseRequest.getMobile()))
                return BaseResponseUtils.createErrorBaseResponse("Username or Mobile must not be empty");

            centralService.savePartnerDetails(centralBaseRequest);
            return BaseResponseUtils.createSuccessBaseResponse();
        }catch (Exception e){
            log.info("Error in addPartner", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }

    @ApiOperation("This api is used to get partner details from the db")
    @GetMapping("/get-partners")
    public BaseResponse getPartners(@RequestBody(required = false) List<String> mobileNoList){
        try {
            return centralService.getPartnerDetails(mobileNoList);
        }catch (Exception e){
            log.info("Error in addUser", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }

}
