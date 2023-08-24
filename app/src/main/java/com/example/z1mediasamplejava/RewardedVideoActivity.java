


package com.example.z1mediasamplejava;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.z1mediasamplejava.application.MyApplication;
import com.example.z1mediasamplejava.databinding.ActivityRewardedVideoBinding;
import com.z1media.android.sdk.Z1RewardedVideoAd;
import com.z1media.android.sdk.listeners.Z1RewardedVideoI;
import com.z1media.android.sdk.models.Z1AdError;

public class RewardedVideoActivity extends AppCompatActivity {

    ActivityRewardedVideoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRewardedVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        Z1RewardedVideoAd rewardedVideoAd = new Z1RewardedVideoAd.Builder(this)
                .setTagName("in-app-sample-rw-Z1")
                .setEnvironment(BuildConfig.BUILD_TYPE)
                .setListener(new Z1RewardedVideoI() {

                    @Override
                    public void onAdImpression() {

                    }

                    @Override
                    public void onUserEarnedReward(int i, @NonNull String s) {
                        binding.title.setText("Reward Amount "+ i +", type: "+s);
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {

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
                    public void onAdDismissedFullScreenContent() {

                    }

                    @Override
                    public void onAdClicked() {

                    }
                }).build();
        rewardedVideoAd.loadRewardVideoAd();
    }
}