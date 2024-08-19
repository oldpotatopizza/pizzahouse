package com.ohgiraffers.pizzahouse.user.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tbl_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "user_name", nullable = false)
    private String userName; // 이름

    @Column(name = "user_age", nullable = false)
    private String userAge; // 나이

    @Column(name = "user_postcode")
    private int postCode; // 우편번호

    @Column(name = "user_address", nullable = false)
    private String adderess; //기본주소

    @Column(name = "user_addressDetail")
    private String adderessDetail; //상세주소

    public UserEntity() {
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

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
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

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge='" + userAge + '\'' +
                ", postCode=" + postCode +
                ", adderess='" + adderess + '\'' +
                ", adderessDetail='" + adderessDetail + '\'' +
                '}';
    }
}
