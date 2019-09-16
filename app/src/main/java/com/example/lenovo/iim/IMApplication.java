package com.example.lenovo.iim;

import android.app.Application;

import com.example.lenovo.iim.model.Model;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseUI;

public class IMApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        EMOptions options = new EMOptions();
        options.setAcceptInvitationAlways(false);//设置需要同意后才能接收邀请
        options.setAutoAcceptGroupInvitation(false);//设置需要统一后才能接收邀请
        EaseUI.getInstance().init(this,options);
        Model.getInstance().init(this);


    }
}
