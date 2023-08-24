package com.example.z1mediasamplejava;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.z1mediasamplejava.application.MyApplication;
import com.example.z1mediasamplejava.databinding.ActivitySplashBinding;
import com.z1media.android.sdk.listeners.OnShowAdCompleteListener;

public class SplashActivity extends AppCompatActivity {

    String LOG_TAG = "SplashActivity";
    private long COUNTER_TIME = 5;
    private long secondsRemaining = 0;

    ActivitySplashBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createTimer(COUNTER_TIME);

    }


    private void createTimer(long seconds) {

        CountDownTimer countDownTimer = new CountDownTimer(seconds * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                secondsRemaining = millisUntilFinished / 1000 + 1;
                binding.counterTextView.setText("App is done loading in:"+secondsRemaining);
            }

            @Override
            public void onFinish() {
                binding.counterTextView.setText("Done");

                MyApplication application = (MyApplication) getApplication();


                // If the application is not an instance of MyApplication, log an error message and
                // start the MainActivity without showing the app open ad.
                if (application == null) {
                    Log.e(LOG_TAG, "Failed to cast application to MyApplication.");
                    startMainActivity();
                    return;
                }

                application.appOpenAd.showAdIfAvailable(SplashActivity.this, new OnShowAdCompleteListener() {
                    @Override
                    public void onShowAdComplete() {
                        Log.e(LOG_TAG, " onShowAdComplete");
                        startMainActivity();
                    }
                });
            }
        };
        countDownTimer.start();
    }

    void startMainActivity() {
        Intent intent = new Intent(this, com.example.z1mediasamplejava.MainActivity.class);
        startActivity(intent);
    }

}