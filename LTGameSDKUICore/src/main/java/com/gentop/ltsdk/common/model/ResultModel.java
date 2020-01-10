package com.gentop.ltsdk.common.model;

import java.io.Serializable;

public class ResultModel implements Serializable {
    //验证码
    private String auth_code;
    //乐推UID
    private String lt_uid;
    //token
    private String api_token;
    //乐推uidToken
    private String lt_uid_token;
    //乐推订单ID
    private String lt_order_id;
    //类型
    private String lt_type;
    //单位
    private String lt_currency;
    //价格
    private double lt_price;


    public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }

    public String getLt_uid() {
        return lt_uid;
    }

    public void setLt_uid(String lt_uid) {
        this.lt_uid = lt_uid;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public String getLt_order_id() {
        return lt_order_id;
    }

    public void setLt_order_id(String lt_order_id) {
        this.lt_order_id = lt_order_id;
    }

    public String getLt_uid_token() {
        return lt_uid_token;
    }

    public void setLt_uid_token(String lt_uid_token) {
        this.lt_uid_token = lt_uid_token;
    }

    public String getLt_type() {
        return lt_type;
    }

    public void setLt_type(String lt_type) {
        this.lt_type = lt_type;
    }

    public String getLt_currency() {
        return lt_currency;
    }

    public void setLt_currency(String lt_currency) {
        this.lt_currency = lt_currency;
    }

    public double getLt_price() {
        return lt_price;
    }

    public void setLt_price(double lt_price) {
        this.lt_price = lt_price;
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "auth_code='" + auth_code + '\'' +
                ", lt_uid='" + lt_uid + '\'' +
                ", api_token='" + api_token + '\'' +
                ", lt_uid_token='" + lt_uid_token + '\'' +
                ", lt_order_id='" + lt_order_id + '\'' +
                ", lt_type='" + lt_type + '\'' +
                ", lt_currency='" + lt_currency + '\'' +
                ", lt_price='" + lt_price + '\'' +
                '}';
    }
}
