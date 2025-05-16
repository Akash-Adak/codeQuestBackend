package com.codequest.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="profile")
public class Profile {
    @Id
    private ObjectId id;
    private String name;
    private String username;
    private String email;
    private String gender;
    private  String city;
    private String dob;
    private byte[] image;

    public Profile(String username, String email) {
        this.username=username;
        this.email=email;
    }


}
