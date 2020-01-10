package com.gentop.ltsdk.common.constant;

public class Constants {
    /***用户协议标志*/
    public static final String USER_AGREEMENT_FLAT = "USER_AGREEMENT_FLAT";
    /***乐推UID标志*/
    public static final String USER_LT_UID = "USER_FACEBOOK_LT_UID";
    /***乐推UIDtoken标志*/
    public static final String USER_LT_UID_TOKEN = "USER_FACEBOOK_LT_UID_TOKEN";
    /***apiToken标志*/
    public static final String USER_API_TOKEN = "USER_API_TOKEN";
    /***用户的UUID*/
    public static final String USER_UUID = "USER_UUID";
    /***游客标记*/
    public static final String USER_GUEST_FLAG = "USER_GUEST_FLAG";
    /***绑定标记*/
    public static final String USER_BIND_FLAG = "USER_BIND_FLAG";


    private static final int BASE_CODE = 0X001;
    /***Facebook注册*/
    public static final int USER_REGISTER_FACEBOOK_CODE = BASE_CODE + 20;
    /***Google注册*/
    public static final int USER_REGISTER_GOOGLE_CODE = BASE_CODE + 21;
    /***游客注册*/
    public static final int USER_REGISTER_GUEST_CODE = BASE_CODE + 22;

    //Google支付
    public static final String GOOGLE_RECHARGE_RESULT_CODE = "GOOGLE_RECHARGE_RESULT_CODE";
    //Google支付
    public static final String GOOGLE_RECHARGE_CODE = "GOOGLE_RECHARGE_CODE";
    //Google登录
    public static final String GOOGLE_LOGIN_CODE = "GOOGLE_LOGIN_CODE";
    //Facebook登录
    public static final String FB_LOGIN_CODE = "FB_LOGIN_CODE";
    //游客登录
    public static final String GUEST_LOGIN_CODE = "GUEST_LOGIN_CODE";

}
