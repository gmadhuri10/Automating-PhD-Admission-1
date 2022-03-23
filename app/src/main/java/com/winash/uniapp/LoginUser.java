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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.winash.uniapp.ui.AddCourse.Course;

public class LoginUser extends AppCompatActivity implements View.OnClickListener {
    private EditText username,password;
    private Button login;
    private ProgressBar progress;
    private FirebaseAuth mAuth;
    private DatabaseReference db;
    private TextView reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        login=(Button)findViewById(R.id.LoginBtn);
        username=(EditText) findViewById(R.id.InputEmail);
        password=(EditText) findViewById(R.id.InputPassword);
        progress=(ProgressBar) findViewById(R.id.progressBarLogin);
        mAuth=FirebaseAuth.getInstance();
        login.setOnClickListener(this);
        reset=(TextView) findViewById(R.id.ResetText);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.LoginBtn:
                userlogin();
                break;
            case R.id.ResetText:
                startActivity(new Intent(LoginUser.this,ForgotPassword.class));
                break;
        }
    }

    private void userlogin() {
        String un=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(pass.isEmpty()||pass.length()<=8)
        {
            password.setError("Password Not Valid!!!");
            password.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(un).matches())
        {
            username.setError("Valid Email Required!!!");
            username.requestFocus();
            return;
        }
        login.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(un,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    if(un.contains("@uniapp.admin.com")) {
                        startActivity(new Intent(LoginUser.this, AdminDashboard.class));
                        finish();
                    }
                    else {
                        db= FirebaseDatabase.getInstance().getReference("Applicant");
                        db.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                boolean d=false;
                                for(DataSnapshot s:snapshot.getChildren()){
                                    Applicant ds=s.getValue(Applicant.class);
                                    if(ds.getApplicantid().equals(mAuth.getUid())) {
                                        d = ds.isBlack();
                                    }
                                }
                                if(!d) {
                                    startActivity(new Intent(LoginUser.this, ApplicantHomePage.class));
                                    finish();
                                }
                                else
                                    Toast.makeText(LoginUser.this, "You have been blacklisted", Toast.LENGTH_SHORT).show();
                                }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });

                    }
                    progress.setVisibility(View.INVISIBLE);
                }else{
                    login.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.INVISIBLE);
                    Toast.makeText(LoginUser.this, "Please CHeck your credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean noNumber(String s){
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            if(Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
    public boolean isInteger(String s){
        int flag=0;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            if(Character.isDigit(c)){
                flag++;
            }
        }
        if(flag==s.length())
            return true;
        else
            return false;
    }
}