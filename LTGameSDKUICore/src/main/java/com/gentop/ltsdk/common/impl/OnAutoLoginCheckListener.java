package com.gentop.ltsdk.common.impl;


import com.gentop.ltsdk.common.model.BaseEntry;

public interface OnAutoLoginCheckListener {

    void onCheckSuccess(BaseEntry result);

    void onCheckFailed(Throwable ex);
}
