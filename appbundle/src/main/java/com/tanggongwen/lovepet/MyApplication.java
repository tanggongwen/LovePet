package com.tanggongwen.lovepet;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tanggongwen.lovepet.bundle.common.base.BaseApplication;
import com.tanggongwen.lovepet.bundle.common.utils.Utils;

public class MyApplication extends BaseApplication {



        @Override
        public void onCreate() {
            super.onCreate();
            if (Utils.isAppDebug()) {
                //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
                ARouter.openDebug();
                ARouter.openLog();
            }
            ARouter.init(this);
            //崩溃日志记录初始化
        }


        @Override
        protected void attachBaseContext(Context base) {
            super.attachBaseContext(base);
            // dex突破65535的限制
            MultiDex.install(this);
        }


}
