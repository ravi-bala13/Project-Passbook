package com.passbook.demo.database.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user_details")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @Id
    private String id;

    private String name;

    private String address;

    @NotEmpty
    private String mobile;

    @Field("created_at")
    private Date createdAt;

    @Field("updated_at")
    private Date updatedAt;

}
