package com.bgl.zhulong_students_union.model;

import android.content.Context;
import android.text.TextUtils;

import com.bgl.data.ApiConfig;
import com.bgl.data.ICommonModel;
import com.bgl.data.ICommonPresenter;
import com.bgl.data.NetManger;
import com.bgl.data.utils.ParamHashMap;
import com.bgl.zhulong_students_union.R;
import com.bgl.zhulong_students_union.base.Application1907;


/**
 * Created by 包国梁 on 2020/6/2
 */
public class LauchModel implements ICommonModel {
    private NetManger mManger = NetManger.getInstance();
    private Context mContext = Application1907.get07ApplicationContext();

    @Override
    public void getData(ICommonPresenter pPresenter, int whichApi, Object[] params) {
        switch (whichApi) {
            case ApiConfig.ADVERT:
                ParamHashMap map = new ParamHashMap().add("w", params[1]).add("h", params[2]).add("positions_id", "APP_QD_01").add("is_show", 0);
                if (!TextUtils.isEmpty((String) params[0])) map.add("specialty_id", params[0]);
                mManger.netWork(mManger.getService(mContext.getString(R.string.ad_openapi)).getAdvert(map), pPresenter, whichApi);
                break;
            case ApiConfig.SUBJECT:
                mManger.netWork(mManger.getService(mContext.getString(R.string.edu_openapi)).getSubjectList(), pPresenter, whichApi);
                break;
        }
    }
}
