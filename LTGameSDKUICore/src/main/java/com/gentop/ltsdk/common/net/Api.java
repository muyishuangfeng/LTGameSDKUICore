package com.gentop.ltsdk.common.net;


import com.gentop.ltsdk.common.net.retrofit.BaseApiImpl;

public class Api extends BaseApiImpl {

    private Api(String baseUrl) {
        super(baseUrl);
    }

    public static RetrofitService getInstance(String baseUrl) {
        return new Api(baseUrl).getRetrofit().create(RetrofitService.class);
    }


}
