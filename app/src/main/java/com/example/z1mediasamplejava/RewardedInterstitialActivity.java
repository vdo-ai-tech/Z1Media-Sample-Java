package com.example.z1mediasamplejava;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.z1mediasamplejava.databinding.ActivityRewardedVideoBinding;
import com.example.z1mediasamplejava.databinding.ActivityRewardediBinding;
import com.z1media.android.sdk.Z1RewardInterstitialAd;
import com.z1media.android.sdk.Z1RewardedVideoAd;
import com.z1media.android.sdk.listeners.Z1RewardInterstitialI;
import com.z1media.android.sdk.listeners.Z1RewardedVideoI;
import com.z1media.android.sdk.models.Z1AdError;

public class RewardedInterstitialActivity extends AppCompatActivity {
    ActivityRewardediBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRewardediBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Z1RewardInterstitialAd rewardedVideoAd = new Z1RewardInterstitialAd.Builder(this)
                .setTagName("in-app-sample-rw-Z1")
                .setEnvironment(BuildConfig.BUILD_TYPE)
                .setListener(new Z1RewardInterstitialI() {

                    @Override
                    public void onAdImpression() {

                    }

                    @Override
                    public void onUserEarnedReward(int i, @NonNull String s) {
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
        rewardedVideoAd.loadRewardInterstitialAd();
    }
}