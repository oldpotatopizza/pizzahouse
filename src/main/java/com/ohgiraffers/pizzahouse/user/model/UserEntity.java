package com.ohgiraffers.pizzahouse.user.model;


import com.ohgiraffers.pizzahouse.utill.Utills;
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
    private Integer userAge; // 나이

    @Column(name = "user_postcode")
    private int postCode; // 우편번호

    @Column(name = "user_address", nullable = false)
    private String adderess; //기본주소

    @Column(name = "user_addressDetail")
    private String adderessDetail; //상세주소

    public UserEntity() {
    }

    public static class Builder {
        private String userName;
        private Integer userAge;
        private int postCode;
        private String adderess;
        private String adderessDetail;

        public UserEntity builder() {
            if (userName == null || userAge == null || adderess == null || adderessDetail == null) {
                throw new IllegalArgumentException("곳간을 채워주세요");
            }
            return new UserEntity(this);
        }

        public Builder setUserName(String userName) {

            if (userName == null || userName.isEmpty()) {
                throw new IllegalArgumentException("입력해 주세요");
            } else if (!Utills.regex(userName)) {
                throw new IllegalArgumentException("한글로 입력해 주세요");
            } else if (userName.length() > 3) {
                throw new IllegalArgumentException("3글자 이하로 입력해 주세요");
            }else {
                this.userName = userName;
                return this;
            }
        }
        public Builder setUserAge(Integer userAge) {
            if (userAge == null || userAge < 0) {
                throw new IllegalArgumentException("입력해 주세요");
            }else if (userAge < 20) {
                throw new IllegalArgumentException("20세 이상만 가입이 가능합니다.");
            }else {
                this.userAge = userAge;
                return this;
            }
        }
        public Builder setPostCode(int postCode) {
            this.postCode = postCode;
            return this;
        }
        public Builder setAdderess(String adderess) {
            this.adderess = adderess;
            return this;
        }
        public Builder setAdderessDetail(String adderessDetail) {
            this.adderessDetail = adderessDetail;
            return this;
        }

    }
    public UserEntity(Builder builder) {
        this.userName = builder.userName;
        this.userAge = builder.userAge;
        this.postCode = builder.postCode;
        this.adderess = builder.adderess;
        this.adderessDetail = builder.adderessDetail;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getAdderess() {
        return adderess;
    }

    public String getAdderessDetail() {
        return adderessDetail;
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
