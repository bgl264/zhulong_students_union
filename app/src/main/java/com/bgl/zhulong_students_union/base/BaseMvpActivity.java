package com.bgl.zhulong_students_union.base;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.bgl.data.CommonPresenter;
import com.bgl.data.ICommonModel;
import com.bgl.data.ICommonView;

import butterknife.ButterKnife;

/**
 * Created by 包国梁 on 2020/6/2
 */
public abstract class BaseMvpActivity<M extends ICommonModel> extends BaseActivity implements ICommonView {
    private M mModel;
    public CommonPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        ButterKnife.bind(this);
        mModel = setModel();
        mPresenter = new CommonPresenter(this, mModel);
        setUpView();
        setUpData();
    }

    public abstract M setModel();

    public abstract int setLayoutId();

    public abstract void setUpView();

    public abstract void setUpData();

    public abstract void netSuccess(int whichApi, Object[] pD);

    public void netFailed(int whichApi, Throwable pThrowable){}

    @Override
    public void onSuccess(int whichApi,Object[] pD) {
        netSuccess(whichApi,pD);
    }

    @Override
    public void onFailed(int whichApi, Throwable pThrowable) {
        showLog("net work error: "+whichApi+"error content"+ pThrowable != null && !TextUtils.isEmpty(pThrowable.getMessage()) ? pThrowable.getMessage() : "不明错误类型");
        netFailed(whichApi,pThrowable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.clear();
    }
}
