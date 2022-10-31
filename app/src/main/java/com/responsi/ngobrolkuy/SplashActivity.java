package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class SplashActivity extends AppCompatActivity {
    private Intent pindah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pindah = new Intent(SplashActivity.this, RegisterActivity.class);
        CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS).execute(() -> {
            startActivity(pindah);
        });
    }
}