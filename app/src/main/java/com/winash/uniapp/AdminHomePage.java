package com.winash.uniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class AdminHomePage extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText name;
    private Button logoutbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);
        mAuth=FirebaseAuth.getInstance();
        name=(EditText)findViewById(R.id.editTextTextAdminName);
        name.setText(mAuth.getUid());
        logoutbutton=(Button) findViewById(R.id.LogoutBtn);
        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(AdminHomePage.this,LoginUser.class));
            }
        });
    }
}