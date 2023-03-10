package com.example.bible;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Splash Screen
        Thread background = new Thread(){
            public void run(){
                try {
                    sleep(5000);

                   Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                   startActivity(intent);

                    finish();
                }catch (Exception e){

                }
            }
        } ;
        background.start();
    }
}