package com.ohgiraffers.pizzahouse.user.model;

import java.util.List;

public class UserDTO {

    private Integer userId;
    private String userName; // 이름
    private int userAge; // 나이
    private int postCode; // 우편번호
    private String adderess; //기본주소
    private String adderessDetail; //상세주소
    private String status;


    public UserDTO() {
    }

    public UserDTO(Integer userId, String userName, int userAge, int postCode, String adderess, String adderessDetail, String status) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
        this.postCode = postCode;
        this.adderess = adderess;
        this.adderessDetail = adderessDetail;
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", postCode=" + postCode +
                ", adderess='" + adderess + '\'' +
                ", adderessDetail='" + adderessDetail + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}