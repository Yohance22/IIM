package com.example.lenovo.iim.model;

import android.content.Context;

import com.example.lenovo.iim.model.dao.UserAccountDao;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//数据模型层全局类
public class Model {
    private Context mContext;
    private UserAccountDao userAccountDao;
    private ExecutorService executors = Executors.newCachedThreadPool();
    //创建对象
    private static Model model = new Model();
//    私有化构造
    private Model(){

    }
//    获取单例对象
    public  static Model getInstance(){
        return model;
    }
//    初始化方案
    public void init(Context context){
        mContext = context;
        //创建用户账号数据库操作类对象
        userAccountDao = new UserAccountDao(mContext);

    }
    public ExecutorService getGlobalThreadPool() {
        return executors;
    }
    //用户的登录成功后的处理办法

    public void loginSuccess() {

    }
    // 获取用户账号数据库的操作类对象
    public UserAccountDao getUserAccountDao(){
        return userAccountDao;
    }
}
