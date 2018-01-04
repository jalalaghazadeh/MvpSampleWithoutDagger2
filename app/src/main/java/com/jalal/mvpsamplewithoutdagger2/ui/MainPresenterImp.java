package com.jalal.mvpsamplewithoutdagger2.ui;


import com.jalal.mvpsamplewithoutdagger2.data.DataManager;
import com.jalal.mvpsamplewithoutdagger2.data.model.User;

/**
 * Created by Jalal on 1/4/2018.
 */

public class MainPresenterImp implements MainPresenter {

    DataManager dataManager;

    public MainPresenterImp(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void createUser()throws Exception{
        dataManager.createUser(new User("Ali", "1367, Gurgaon, Haryana, India"));
    }

    @Override
    public User getUser(long userId) {
        return dataManager.getUser(1L);
    }

    @Override
    public String getAccessToken() {
        return dataManager.getAccessToken();
    }
}
