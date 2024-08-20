package com.ohgiraffers.pizzahouse.user.model;

import java.util.List;

public class UserDTO {

    private String userName; // 이름
    private int userAge; // 나이
    private int postCode; // 우편번호
    private String adderess; //기본주소
    private String adderessDetail; //상세주소

    public UserDTO() {
    }

    public UserDTO( String userName, int userAge, int postCode, String adderess, String adderessDetail) {
        this.userName = userName;
        this.userAge = userAge;
        this.postCode = postCode;
        this.adderess = adderess;
        this.adderessDetail = adderessDetail;
    }

    public UserDTO(List<UserEntity> allUser) {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getAdderess() {
        return adderess;
    }

    public void setAdderess(String adderess) {
        this.adderess = adderess;
    }

    public String getAdderessDetail() {
        return adderessDetail;
    }

    public void setAdderessDetail(String adderessDetail) {
        this.adderessDetail = adderessDetail;
    }
}
