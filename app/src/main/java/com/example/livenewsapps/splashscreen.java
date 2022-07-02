package com.example.livenewsapps;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class splashscreen extends AppCompatActivity {
    private int  waktuloading = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(splashscreen.this, SignUp.class);
                startActivity(home);
                finish();
            }
        },waktuloading);
    }
}