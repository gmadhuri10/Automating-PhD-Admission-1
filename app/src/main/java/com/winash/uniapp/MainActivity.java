package com.winash.uniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView Register,Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Register=(TextView) findViewById(R.id.Register);
        Login=(TextView) findViewById(R.id.Login);
        Register.setOnClickListener(this);

    }
        public void onClick(View v){
            switch (v.getId()){
                case R.id.Register:
                    startActivity(new Intent(this,RegisterUser.class));
                    break;
                case R.id.Login:
                    startActivity(new Intent(this,LoginUser.class));
                    break;
            }
        }
}