package com.jalal.mvpsamplewithoutdagger2.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import com.jalal.mvpsamplewithoutdagger2.R;
import com.jalal.mvpsamplewithoutdagger2.data.DataManager;
import com.jalal.mvpsamplewithoutdagger2.data.model.User;

public class MainActivity extends AppCompatActivity implements MainView {

    DataManager mDataManager;

    private MainPresenterImp mainPresenter;

    private TextView mTvUserInfo;
    private TextView mTvAccessToken;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDataManager = new DataManager(getApplicationContext());
        mainPresenter = new MainPresenterImp(mDataManager);

        mTvUserInfo = (TextView) findViewById(R.id.tv_user_info);
        mTvAccessToken = (TextView) findViewById(R.id.tv_access_token);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createUser();
        getUser();
        mDataManager.saveAccessToken("ASDR12443JFDJF43543J543H3K543");

        String token = mainPresenter.getAccessToken();
        setAccessToken(token);
    }

    private void createUser(){
        try {
            mainPresenter.createUser();
        }catch (Exception e){e.printStackTrace();}
    }

    private void getUser(){
        try {
            User user = mainPresenter.getUser(1L);
            setUserInfo(user);
        }catch (Exception e){e.printStackTrace();}
    }

    @Override
    public void setUserInfo(User userInfo) {
        mTvUserInfo.setText(userInfo.toString());
    }

    @Override
    public void setAccessToken(String accessToken) {
        if(accessToken != null){
            mTvAccessToken.setText(accessToken);
        }
    }
}
