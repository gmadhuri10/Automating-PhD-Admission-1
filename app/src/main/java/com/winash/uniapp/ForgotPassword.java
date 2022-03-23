package com.winash.uniapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity implements View.OnClickListener {
    private EditText email;
    private Button reset;
    private ProgressBar progress;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        progress = (ProgressBar) findViewById(R.id.progressBarReset);
        email = (EditText) findViewById(R.id.ResetEmail);
        reset = (Button) findViewById(R.id.ResetPassBtn);
        reset.setOnClickListener(this);
        fAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ResetPassBtn:
                reset();
                break;
        }
    }

    private void reset() {
        String em = email.getText().toString();
        if (!Patterns.EMAIL_ADDRESS.matcher(em).matches() || em.isEmpty()||em.contains("@uniapp.admin.com")) {
            email.setError("Valid Email Required!!!");
            email.requestFocus();
            return;
        }
        reset.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
        fAuth.sendPasswordResetEmail(em).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ForgotPassword.this, "Reset password sent to your email", Toast.LENGTH_SHORT).show();
                    progress.setVisibility(View.GONE);
                    startActivity(new Intent(ForgotPassword.this,LoginUser.class));
                } else {
                    reset.setVisibility(View.VISIBLE);
                    Toast.makeText(ForgotPassword.this, "Some Error Occured", Toast.LENGTH_SHORT).show();
                    progress.setVisibility(View.GONE);
                }
            }
        });
    }
}