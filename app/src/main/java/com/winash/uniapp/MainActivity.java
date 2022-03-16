package com.winash.uniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView Register,Login;
    private VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Register=(TextView) findViewById(R.id.RegisterMain);
        Login=(TextView) findViewById(R.id.LoginMain);
        Register.setOnClickListener(this);
        Login.setOnClickListener(this);
        video=(VideoView) findViewById(R.id.videoView);
        video.setVideoURI(Uri.parse("https://www.youtube.com/watch?v=a3EiG1EZFh8&ab_channel=AmritaSchoolofBiotechnology"));
        video.setMediaController(new MediaController(this));
        video.start();
    }
        public void onClick(View v){
            switch (v.getId()){
                case R.id.RegisterMain:
                    startActivity(new Intent(this,RegisterUser.class));
                    break;
                case R.id.LoginMain:
                    startActivity(new Intent(this,LoginUser.class));
                    break;
            }
        }
}