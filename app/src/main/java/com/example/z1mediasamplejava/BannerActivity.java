package com.example.z1mediasamplejava;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.z1mediasamplejava.application.MyApplication;
import com.example.z1mediasamplejava.databinding.ActivityBannerBinding;
import com.z1media.android.sdk.Z1BannerAd;
import com.z1media.android.sdk.listeners.Z1BannerAdsI;
import com.z1media.android.sdk.models.Z1AdError;
import com.z1media.android.sdk.utils.Z1AdSize;

public class BannerActivity extends AppCompatActivity {
    MyApplication application =new MyApplication();
    ActivityBannerBinding binding;
    StringBuilder builder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBannerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Z1BannerAd z1BannerAd = new Z1BannerAd.Builder(this)
                .setBannerView(binding.bannerAdsContainer)
                .setTagName("in-app-sample-b-Z1")
                .setEnvironment(BuildConfig.BUILD_TYPE)
                .setAddSize(Z1AdSize.BANNER)
                .setListener(new Z1BannerAdsI() {

                    @Override
                    public void onMediationSuccess() {

                    }

                    @Override
                    public void onAdImpression() {
                        builder.append("Add impression \n");
                        binding.textView.setText( builder.toString());
                    }

                    @Override
                    public void onAdLoaded() {
                        builder.append("Add loaded \n");
                        binding.textView.setText( builder.toString());
                    }

                    @Override
                    public void onAdFailedToLoad(@Nullable Z1AdError z1AdError) {
                        builder.append("Add Fail to load \n");
                        binding.textView.setText( builder);
                    }
                    @Override
                    public void onAdClicked() {
                        builder.append("Add clicked \n");
                        binding.textView.setText( builder.toString());
                    }

                    @Override
                    public void onAdOpened() {
                        builder.append("Add opened \n");
                        binding.textView.setText( builder.toString());
                    }

                    @Override
                    public void onAdClosed() {
                        builder.append("Add closed \n");
                        binding.textView.setText( builder.toString());
                    }
                }).build();
        z1BannerAd.loadBannerAd();
    }
}