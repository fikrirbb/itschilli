package com.example.fikid.itschilliv3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        /*handler untuk menahan activity sementara*/
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /*mulai activity ke MainActivity setelah 5 detik*/
                startActivity(new Intent(getApplicationContext(),ActivityLogin.class));
                finish();
            }
            /*durasi 5000ms*/
        },1000);
    }

    @Override
    public void onBackPressed() {
        return;
    }
}
