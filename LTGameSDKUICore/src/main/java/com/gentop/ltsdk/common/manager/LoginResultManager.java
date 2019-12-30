package com.gentop.ltsdk.common.manager;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.gentop.ltsdk.common.constant.Constants;
import com.gentop.ltsdk.common.impl.OnAutoLoginCheckListener;
import com.gentop.ltsdk.common.impl.OnLoginSuccessListener;
import com.gentop.ltsdk.common.model.BaseEntry;
import com.gentop.ltsdk.common.model.ResultData;
import com.gentop.ltsdk.common.net.Api;
import com.gentop.ltsdk.common.net.retrofit.ExceptionHelper;
import com.gentop.ltsdk.common.util.MD5Util;
import com.gentop.ltsdk.common.util.PreferencesUtils;
import com.google.gson.Gson;

import java.util.Map;
import java.util.WeakHashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * 登录管理类
 */
public class LoginResultManager {


    /**
     * Google登录
     *
     * @param LTAppID   APPID
     * @param LTAppKey  appKey
     * @param mListener 接口回调
     */
    public static void googleLogin(final Context context, boolean isTestServer, String LTAppID,
                                   String LTAppKey, Map<String, Object> map,
                                   final OnLoginSuccessListener mListener) {
        String baseUrl = "";
        if (!TextUtils.isEmpty(LTAppID) &&
                !TextUtils.isEmpty(LTAppKey) &&
                map != null) {
            long LTTime = System.currentTimeMillis() / 1000L;
            String LTToken = MD5Util.md5Decode("POST" + LTAppID + LTTime + LTAppKey);
            if (isTestServer) {
                baseUrl = Api.TEST_SERVER_URL;
            } else {
                baseUrl = Api.FORMAL_SERVER_URL;
            }
            Api.getInstance(baseUrl)
                    .googleLogin(LTAppID, LTToken, (int) LTTime, map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<BaseEntry<ResultData>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(BaseEntry<ResultData> result) {
                            if (result != null) {
                                if (result.getCode() == 200) {
                                    if (result.getData() != null) {
                                        if (mListener != null) {
                                            int code = 0;
                                            BaseEntry<ResultData> baseEntry = new BaseEntry<>();
                                            baseEntry.setResult(result.getResult());
                                            if (result.getData().getLt_type().equals("register")) {
                                                code = Constants.USER_REGISTER_GOOGLE_CODE;
                                            }
                                            baseEntry.setCode(code);
                                            baseEntry.setData(result.getData());
                                            baseEntry.setMsg(result.getMsg());
                                            mListener.onSuccess(baseEntry);
                                        }
                                        if (!TextUtils.isEmpty(result.getData().getApi_token())) {
                                            PreferencesUtils.putString(context, Constants.USER_API_TOKEN,
                                                    result.getData().getApi_token());
                                        }
                                        if (!TextUtils.isEmpty(result.getData().getLt_uid())) {
                                            PreferencesUtils.putString(context, Constants.USER_LT_UID,
                                                    result.getData().getLt_uid());
                                        }
                                        if (!TextUtils.isEmpty(result.getData().getLt_uid_token())) {
                                            PreferencesUtils.putString(context, Constants.USER_LT_UID_TOKEN,
                                                    result.getData().getLt_uid_token());
                                        }
                                    }
                                } else {
                                    if (mListener != null) {
                                        mListener.onFailed(result.getMsg());
                                    }
                                }
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (mListener != null) {
                                mListener.onFailed(ExceptionHelper.handleException(e));
                            }
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } else {
            if (mListener != null) {
                mListener.onParameterError("Wrong parameter");
            }
        }
    }

    /**
     * facebook登录
     *
     * @param LTAppID   APPID
     * @param LTAppKey  Token
     *                  //@param accessToken facebook返回的Token
     * @param mListener 接口回调
     */
    public static void facebookLogin(final Context context, boolean isTestServer, String LTAppID,
                                     String LTAppKey, Map<String, Object> map,
                                     final OnLoginSuccessListener mListener) {
        String baseUrl = "";
        if (!TextUtils.isEmpty(LTAppID) &&
                !TextUtils.isEmpty(LTAppKey) &&
                map != null) {
            long LTTime = System.currentTimeMillis() / 1000L;
            String LTToken = MD5Util.md5Decode("POST" + LTAppID + LTTime + LTAppKey);
            if (isTestServer) {
                baseUrl = Api.TEST_SERVER_URL;
            } else {
                baseUrl = Api.FORMAL_SERVER_URL;
            }
            Api.getInstance(baseUrl)
                    .faceBookLogin(LTAppID, LTToken, (int) LTTime, map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<BaseEntry<ResultData>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(BaseEntry<ResultData> result) {
                            if (result != null) {
                                if (result.getCode() == 200) {
                                    if (result.getData() != null) {
                                        if (mListener != null) {
                                            int code = 0;
                                            BaseEntry<ResultData> baseEntry = new BaseEntry<>();
                                            baseEntry.setResult(result.getResult());
                                            if (result.getData().getLt_type().equals("register")) {
                                                code = Constants.USER_REGISTER_FACEBOOK_CODE;
                                            }
                                            baseEntry.setCode(code);
                                            baseEntry.setData(result.getData());
                                            baseEntry.setMsg(result.getMsg());
                                            mListener.onSuccess(baseEntry);
                                        }
                                        if (!TextUtils.isEmpty(result.getData().getApi_token())) {
                                            PreferencesUtils.putString(context, Constants.USER_API_TOKEN,
                                                    result.getData().getApi_token());
                                        }
                                        if (!TextUtils.isEmpty(result.getData().getLt_uid())) {
                                            PreferencesUtils.putString(context, Constants.USER_LT_UID,
                                                    result.getData().getLt_uid());
                                        }
                                        if (!TextUtils.isEmpty(result.getData().getLt_uid_token())) {
                                            PreferencesUtils.putString(context, Constants.USER_LT_UID_TOKEN,
                                                    result.getData().getLt_uid_token());
                                        }
                                    }

                                } else {
                                    if (mListener != null) {
                                        mListener.onFailed(result.getMsg());
                                    }
                                }
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (mListener != null) {
                                mListener.onFailed(ExceptionHelper.handleException(e));
                            }
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } else {
            if (mListener != null) {
                mListener.onParameterError("Wrong parameter");
            }
        }
    }


    /**
     * 自动登录验证
     */
    public static void autoLoginCheck(boolean isTestServer, String LTAppID, String LTAppKey,
                                      Map<String, Object> params,
                                      final OnAutoLoginCheckListener mListener) {
        String baseUrl = "";
        if (params != null &&
                !TextUtils.isEmpty(LTAppID) &&
                !TextUtils.isEmpty(LTAppKey)) {
            long LTTime = System.currentTimeMillis() / 1000L;
            String LTToken = MD5Util.md5Decode("POST" + LTAppID + LTTime + LTAppKey);
            String json = new Gson().toJson(params);//要传递的json
            final RequestBody requestBody = RequestBody.create(okhttp3.MediaType
                    .parse("application/json; charset=utf-8"), json);
            if (isTestServer) {
                baseUrl = Api.TEST_SERVER_URL;
            } else {
                baseUrl = Api.FORMAL_SERVER_URL;
            }
            Api.getInstance(baseUrl)
                    .autoLogin(LTAppID, LTToken, (int) LTTime, requestBody)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<BaseEntry>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(BaseEntry result) {
                            if (result != null) {
                                if (mListener != null) {
                                    mListener.onCheckSuccess(result);
                                }
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (mListener != null) {
                                mListener.onCheckFailed(e);
                            }
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }

    /**
     * 游客登录验证
     */
    public static void guestLogin(final Context context, boolean isTestServer, String LTAppID, String LTAppKey,
                                  Map<String, Object> params, final OnLoginSuccessListener mListener) {
        String baseUrl = "";
        if (params != null &&
                !TextUtils.isEmpty(LTAppID) &&
                !TextUtils.isEmpty(LTAppKey)) {
            long LTTime = System.currentTimeMillis() / 1000L;
            String LTToken = MD5Util.md5Decode("POST" + LTAppID + LTTime + LTAppKey);
            if (isTestServer) {
                baseUrl = Api.TEST_SERVER_URL;
            } else {
                baseUrl = Api.FORMAL_SERVER_URL;
            }

            Api.getInstance(baseUrl)
                    .guestLogin(LTAppID, LTToken, (int) LTTime, params)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<BaseEntry<ResultData>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(BaseEntry<ResultData> result) {
                            if (result != null) {
                                if (result.getCode() == 200) {
                                    if (result.getData() != null) {
                                        if (mListener != null) {
                                            int code = 0;
                                            BaseEntry<ResultData> baseEntry = new BaseEntry<>();
                                            baseEntry.setResult(result.getResult());
                                            if (result.getData().getLt_type().equals("register")) {
                                                code = Constants.USER_REGISTER_GUEST_CODE;
                                            }
                                            baseEntry.setCode(code);
                                            baseEntry.setData(result.getData());
                                            baseEntry.setMsg(result.getMsg());
                                            mListener.onSuccess(baseEntry);
                                        }
                                        if (!TextUtils.isEmpty(result.getData().getApi_token())) {
                                            PreferencesUtils.putString(context, Constants.USER_API_TOKEN,
                                                    result.getData().getApi_token());
                                        }
                                        if (!TextUtils.isEmpty(result.getData().getLt_uid())) {
                                            PreferencesUtils.putString(context, Constants.USER_LT_UID,
                                                    result.getData().getLt_uid());
                                        }
                                        if (!TextUtils.isEmpty(result.getData().getLt_uid_token())) {
                                            PreferencesUtils.putString(context, Constants.USER_LT_UID_TOKEN,
                                                    result.getData().getLt_uid_token());
                                        }
                                    }

                                } else {
                                    if (mListener != null) {
                                        mListener.onFailed(result.getMsg());
                                    }
                                }
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (mListener != null) {
                                mListener.onFailed(ExceptionHelper.handleException(e));
                            }
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }

    /**
     * 绑定账户
     */
    public static void bingAccount(final Context context, boolean isTestServer, String LTAppID, String LTAppKey,
                                   Map<String, Object> params,
                                   final OnLoginSuccessListener mListener) {
        String baseUrl = "";
        if (params != null &&
                !TextUtils.isEmpty(LTAppID) &&
                !TextUtils.isEmpty(LTAppKey)) {
            long LTTime = System.currentTimeMillis() / 1000L;
            String LTToken = MD5Util.md5Decode("POST" + LTAppID + LTTime + LTAppKey);

            if (isTestServer) {
                baseUrl = Api.TEST_SERVER_URL;
            } else {
                baseUrl = Api.FORMAL_SERVER_URL;
            }

            Api.getInstance(baseUrl)
                    .bindAccount(LTAppID, LTToken, (int) LTTime, params)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<BaseEntry<ResultData>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(BaseEntry<ResultData> result) {
                            if (result != null) {
                                if (result.getCode() == 200) {
                                    if (result.getData() != null) {
                                        if (mListener != null) {
                                            mListener.onSuccess(result);
                                        }
                                        if (!TextUtils.isEmpty(result.getData().getApi_token())) {
                                            PreferencesUtils.putString(context, Constants.USER_API_TOKEN,
                                                    result.getData().getApi_token());
                                        }
                                        if (!TextUtils.isEmpty(result.getData().getLt_uid())) {
                                            PreferencesUtils.putString(context, Constants.USER_LT_UID,
                                                    result.getData().getLt_uid());
                                        }
                                        if (!TextUtils.isEmpty(result.getData().getLt_uid_token())) {
                                            PreferencesUtils.putString(context, Constants.USER_LT_UID_TOKEN,
                                                    result.getData().getLt_uid_token());
                                        }
                                    }

                                } else if (result.getCode() == 431) {//已经绑定
                                    if (mListener != null) {
                                        mListener.onAlreadyBind();
                                    }
                                } else {
                                    if (mListener != null) {
                                        mListener.onFailed(result.getMsg());
                                    }
                                }
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (mListener != null) {
                                mListener.onFailed(ExceptionHelper.handleException(e));
                            }
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }

    /**
     * 解绑
     */
    public static void unBingAccount(final Context context, boolean isTestServer, String LTAppID, String LTAppKey,
                                     Map<String, String> params,
                                     final OnLoginSuccessListener mListener) {
        String baseUrl = "";
        if (params != null &&
                !TextUtils.isEmpty(LTAppID) &&
                !TextUtils.isEmpty(LTAppKey)) {
            long LTTime = System.currentTimeMillis() / 1000L;
            String LTToken = MD5Util.md5Decode("POST" + LTAppID + LTTime + LTAppKey);

            if (isTestServer) {
                baseUrl = Api.TEST_SERVER_URL;
            } else {
                baseUrl = Api.FORMAL_SERVER_URL;
            }
            Api.getInstance(baseUrl)
                    .unBindAccount(LTAppID, LTToken, (int) LTTime, params)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<BaseEntry<ResultData>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(BaseEntry<ResultData> result) {
                            if (result != null) {
                                if (result.getCode() == 200) {
                                    if (result.getData() != null) {
                                        if (mListener != null) {
                                            mListener.onSuccess(result);
                                        }
                                        if (!TextUtils.isEmpty(result.getData().getApi_token())) {
                                            PreferencesUtils.putString(context, Constants.USER_API_TOKEN,
                                                    result.getData().getApi_token());
                                        }
                                        if (!TextUtils.isEmpty(result.getData().getLt_uid())) {
                                            PreferencesUtils.putString(context, Constants.USER_LT_UID,
                                                    result.getData().getLt_uid());
                                        }
                                        if (!TextUtils.isEmpty(result.getData().getLt_uid_token())) {
                                            PreferencesUtils.putString(context, Constants.USER_LT_UID_TOKEN,
                                                    result.getData().getLt_uid_token());
                                        }
                                    }

                                } else {
                                    if (mListener != null) {
                                        mListener.onFailed(result.getMsg());
                                    }
                                }
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (mListener != null) {
                                mListener.onFailed(ExceptionHelper.handleException(e));
                            }
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }


}
