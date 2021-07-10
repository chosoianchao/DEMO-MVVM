package com.dcht69.lesson10k10fmvvm.presenter;

import android.app.Application;

public class App extends Application {
    private static App instance;
    private MainPresenter mainPresenter;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    public MainPresenter getPresenter(OnMainCallBack callBack) {
        if (mainPresenter == null) {
            mainPresenter = new MainPresenter(callBack);
        }
        return mainPresenter;
    }
}
