package com.passbook.demo.database.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Builder
@Document(collection = "partner_details")
public class Partner {

    @Id
    private String id;

    private String name;

    private String address;

    private String mobile;

    private Integer cashInHand;

    @Field("created_at")
    private Date createdAt;

    @Field("updated_at")
    private Date updatedAt;

}
