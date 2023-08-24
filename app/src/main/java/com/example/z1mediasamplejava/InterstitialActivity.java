package com.example.z1mediasamplejava;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.z1mediasamplejava.application.MyApplication;
import com.example.z1mediasamplejava.databinding.ActivityInterstitialAdBinding;
import com.z1media.android.sdk.Z1InterstitialAd;
import com.z1media.android.sdk.listeners.Z1AdManagerInterstitialI;
import com.z1media.android.sdk.models.Z1AdError;

public class InterstitialActivity extends AppCompatActivity {

    ActivityInterstitialAdBinding binding;

    MyApplication application =new MyApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInterstitialAdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Z1InterstitialAd interstitialAd =  new Z1InterstitialAd.Builder(this)
                .setTagName("in-app-sample-in-Z1")
                .setEnvironment(BuildConfig.BUILD_TYPE)
                .setListener(new Z1AdManagerInterstitialI() {
                    @Override
                    public void onAdImpression() {

                    }

                    @Override
                    public void onAdLoaded() {

                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(@Nullable Z1AdError z1AdError) {

                    }

                    @Override
                    public void onAdFailedToLoad(@Nullable Z1AdError z1AdError) {

                    }

                    @Override
                    public void onAdShowedFullScreenContent() {

                    }


                    @Override
                    public void onAdDismissedFullScreenContent() {

                    }

                    @Override
                    public void onAdClicked() {

                    }
                }).build();
        interstitialAd.loadInterstitialAd();
    }
}