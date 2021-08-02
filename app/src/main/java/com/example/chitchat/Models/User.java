package com.example.chitchat.Models;

public class User {
    private String uid, name, phoneNUmber, profileImage;

    public User() {
        
    }

    public User(String uid, String name, String phoneNUmber, String profileImage) {
        this.uid = uid;
        this.name = name;
        this.phoneNUmber = phoneNUmber;
        this.profileImage = profileImage;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNUmber() {
        return phoneNUmber;
    }

    public void setPhoneNUmber(String phoneNUmber) {
        this.phoneNUmber = phoneNUmber;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
