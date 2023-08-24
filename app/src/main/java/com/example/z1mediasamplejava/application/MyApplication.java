package com.example.z1mediasamplejava.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.z1mediasamplejava.BuildConfig;
import com.z1media.android.sdk.Z1AppOpenAd;
import com.z1media.android.sdk.listeners.Z1AppOpenI;
import com.z1media.android.sdk.manager.Z1MediaManager;
import com.z1media.android.sdk.models.Z1AdError;

public class MyApplication extends Application {

    public Z1AppOpenAd appOpenAd;
    public String IRON_SOURCE_APP_KEY ="85460dcd"; // sample app key

    @Override
    public void onCreate() {
        super.onCreate();


        appOpenAd = new  Z1AppOpenAd.Builder(this)
                .setTagName("in-app-sample-ap-Z1")
                .setEnvironment(BuildConfig.BUILD_TYPE)
                .setListener(new Z1AppOpenI() {

                    @Override
                    public void onAdLoaded() {

                    }

                    @Override
                    public void onAdDismissedFullScreenContent() {

                    }

                    @Override
                    public void onAdShowedFullScreenContent() {

                    }
                    @Override
                    public void onAdFailedToShowFullScreenContent(@Nullable Z1AdError z1AdError) {

                    }

                    @Override
                    public void onAdFailedToLoad(@Nullable Z1AdError z1AdError) {

                    }

                }).build();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // if using MultiDexApplication not required Z1MediaManager.initMultiDex function
        Z1MediaManager.initMultiDex(this);
    }
}
