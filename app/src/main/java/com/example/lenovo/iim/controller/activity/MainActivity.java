package com.example.lenovo.iim.controller.activity;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.lenovo.iim.R;
import com.example.lenovo.iim.controller.fragment.ChatFragment;
import com.example.lenovo.iim.controller.fragment.ContactListFragment;
import com.example.lenovo.iim.controller.fragment.SettingFragment;

public class MainActivity extends FragmentActivity {
    private RadioGroup rg_main;
    private ChatFragment chatFragment;
    private  ContactListFragment contactListFragment;
    private SettingFragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }

    private void initListener() {

        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                Fragment fragment = null;

                switch (checkedId){
                    case R.id.rb_main_chat:
                        fragment = chatFragment;
                        break;
                    case R.id.rb_main_contact:
                        fragment = contactListFragment;
                        break;
                    case R.id.rb_main_setting:
                        fragment = settingFragment;
                        break;

                }
//                实现fragment切换的方法
                switchFragment(fragment);

            }
        });
        //默认选择会话页面
        rg_main.check(R.id.rb_main_chat);
    }

    private void switchFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_main,fragment).commit();

//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.rl,fragment);
//        ft.show(fragment);
//        ft.commit();


    }

    private void initData() {
        chatFragment = new ChatFragment();
        contactListFragment = new ContactListFragment();
        settingFragment = new SettingFragment();


    }

    private void initView() {
        rg_main =findViewById(R.id.rg_main);
        
        
    }
}
