package com.gentop.ltsdk.common.model;

public class ResultData {
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
    //错误信息
    private String errorMsg;
    //登录类型
    private String loginType;
    //类型
    private String lt_type;


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

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getLt_type() {
        return lt_type;
    }

    public void setLt_type(String lt_type) {
        this.lt_type = lt_type;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "auth_code='" + auth_code + '\'' +
                ", lt_uid='" + lt_uid + '\'' +
                ", api_token='" + api_token + '\'' +
                ", lt_uid_token='" + lt_uid_token + '\'' +
                ", lt_order_id='" + lt_order_id + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", loginType='" + loginType + '\'' +
                ", lt_type='" + lt_type + '\'' +
                '}';
    }
}
