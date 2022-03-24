package com.winash.uniapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;
    List<version> versionList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerView);

        initData();
        setRecyclerView();

    }
    private void setRecyclerView() {
        VersionsAdapter versionsAdapter = new VersionsAdapter(versionList);
        recyclerView.setAdapter(versionsAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {
        versionList = new ArrayList<>();

        versionList.add(new version("This is question1 ", "Answered", "answer for the given question is this ", "user1"));
        versionList.add(new version("This is question2", "Answered", "answer for the given question is this", "user1"));
        versionList.add(new version("This is question3", "Answered", "answer for the given question is this", "user1"));
        versionList.add(new version("This is question4", "Answered", "answer for the given question is this", "user1"));
        versionList.add(new version("This is question5", "Answered", "answer for the given question is this", "user2"));
        versionList.add(new version("This is question6", "Answered", "answer for the given question is this", "user4"));

    }




}