package com.passbook.demo.database.dao;

import com.passbook.demo.database.entity.Partner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerDao extends MongoRepository<Partner, String> {
    List<Partner> findAllByMobile(List<String> mobileNoList);
}
