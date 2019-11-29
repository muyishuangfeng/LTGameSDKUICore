package com.gentop.ltsdk.common.net;


import com.gentop.ltsdk.common.net.retrofit.BaseApiImpl;

public class Api extends BaseApiImpl {
    //测试服务器
    public static final String TEST_SERVER_URL="http://sdk.aktgo.com";
    //正式服务器
    public static final String FORMAL_SERVER_URL="http://login.gdpgold.com";

    private Api(String baseUrl) {
        super(baseUrl);
    }

    public static RetrofitService getInstance(String baseUrl) {
        return new Api(baseUrl).getRetrofit().create(RetrofitService.class);
    }


}
