package com.bgl.zhulong_students_union.base;

import android.content.Context;

import com.bgl.data.FrameApplication;

/**
 * Created by 包国梁 on 2020/6/2
 */
public class Application1907 extends FrameApplication {
    private static Application1907 mApplication1907;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplication1907 = this;
    }

    public Application1907 getApplication(){
        return mApplication1907;
    }

    public static Context get07ApplicationContext(){
        return mApplication1907.getApplicationContext();
    }
}
