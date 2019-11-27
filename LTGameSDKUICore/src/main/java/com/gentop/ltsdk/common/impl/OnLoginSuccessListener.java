package com.gentop.ltsdk.common.impl;


import com.gentop.ltsdk.common.model.BaseEntry;
import com.gentop.ltsdk.common.model.ResultData;

public interface OnLoginSuccessListener {

    void onSuccess(BaseEntry<ResultData> data);

    void onFailed(String code);

    void onParameterError(String result);
}
