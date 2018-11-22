package com.erp.pojo;

/**
 * Created by Administrator on 2018/11/22.
 */
public class Customer {
    private Integer cardId;
    private String cardNo;
    private String mobile;
    private String password;
    private String name;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer["+"姓名："+name+"手机："+mobile+"卡号："+cardNo+"]";
    }
}
