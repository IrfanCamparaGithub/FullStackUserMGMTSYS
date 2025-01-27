package com.exampleusermgmt.fullstackCrud.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class appUser {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    private String name;

    private String email;

    public appUser(String userName, String name, String email) {
        this.userName = userName;
        this.name = name;
        this.email = email;
    }

    public appUser(Long id, String userName, String name, String email) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.email = email;
    }



    public appUser() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
