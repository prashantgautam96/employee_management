package com.prash_backend.employe_system_api.entity;

import jakarta.persistence.*;
import lombok.Data;

//Work with JPA to save the data in Database
@Entity
@Data
@Table(name="employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String firstName;
    private String lastName;
    private String emailId;

    public long getId() {
        return  id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(Object emailId) {
        this.emailId = (String) emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
