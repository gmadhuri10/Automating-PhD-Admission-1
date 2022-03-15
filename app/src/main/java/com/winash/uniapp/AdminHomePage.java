package com.winash.uniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class AdminHomePage extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);
        mAuth=FirebaseAuth.getInstance();
        name=(EditText)findViewById(R.id.editTextTextAdminName);
        name.setText(mAuth.getUid());
    }
}