package com.bgl.bean;

import java.io.Serializable;

/**
 * Created by 包国梁 on 2020/6/2.
 */
public class BaseInfo<D> implements Serializable {
    private static final long serialVersionUID = 7178751760258280801L;
    public int errNo;
    public int exeTime;
    public String msg;
    public D result;

    public boolean isSuccess() {
        return errNo == 0;
    }
}
