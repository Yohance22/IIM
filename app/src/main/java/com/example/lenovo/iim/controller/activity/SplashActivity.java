package com.example.lenovo.iim.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;

import com.example.lenovo.iim.R;
import com.example.lenovo.iim.model.Model;
import com.example.lenovo.iim.model.bean.UserInfo;
import com.hyphenate.chat.EMClient;

//欢迎界面
public class SplashActivity extends Activity {
    private Handler handler = new Handler(){
      public void handleMessage(Message msg){
          if (isFinishing()){
              return;
          }
          //判断进入主页面还是登陆页面
          toMainorlogin();

      }
    };

    private void toMainorlogin() {
//        new Thread(){
//            @Override
//            public void run() {
//
//            }
//        }.start();
        Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                //panduan dangqianzhanghao

                if (EMClient.getInstance().isLoggedInBefore()){

                    //获取当前用户信息
                    UserInfo account = Model.getInstance().getUserAccountDao().getAccountByHxId(EMClient.getInstance().getCurrentUser());
                    if (account == null){
                        Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                        startActivity(intent);

                    }else {
                        Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                        startActivity(intent);
                    }


                }else {
                    Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);

                }
                finish();

            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler.sendMessageDelayed(Message.obtain(),2000);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        handler.removeCallbacksAndMessages(null);
    }
}
