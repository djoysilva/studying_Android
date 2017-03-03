package com.example.logonrm.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        new Thread(new Tempo()).start();
    }

    class Tempo implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();

            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
