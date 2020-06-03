package com.bgl.zhulong_students_union.base;

import android.widget.ImageView;
import android.widget.TextView;

import com.bgl.bean.Device;
import com.bgl.data.FrameApplication;
import com.bgl.data.secret.SystemUtils;
import com.bgl.utils.NetworkUtils;
import com.bgl.zhulong_students_union.R;

import butterknife.BindView;

/**
 * Created by 包国梁 on 2020/6/2
 */
public abstract class BaseSplashActivity extends BaseMvpActivity {
    @BindView(R.id.advert_image)
    public ImageView advertImage;
    @BindView(R.id.time_view)
    public TextView timeView;

    @Override
    public int setLayoutId() {
        return R.layout.activity_splash;
    }

    public void initDevice() {
        Device device = new Device();
        device.setScreenWidth(SystemUtils.getSize(this).x);
        device.setScreenHeight(SystemUtils.getSize(this).y);
        device.setDeviceName(SystemUtils.getDeviceName());
        device.setSystem(SystemUtils.getSystem(this));
        device.setVersion(SystemUtils.getVersion(this));
        device.setDeviceId(SystemUtils.getDeviceId(this));
        device.setLocalIp(NetworkUtils.getLocalIpAddress());
        FrameApplication.getFrameApplication().setDeviceInfo(device);
    }
}
