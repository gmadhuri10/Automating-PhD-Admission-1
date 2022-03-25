package com.winash.uniapp.ui.slideshow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.winash.uniapp.R;
import com.winash.uniapp.VersionsAdapter;
import com.winash.uniapp.version;

import java.util.ArrayList;
import java.util.List;

public class row_fragment extends AppCompatActivity {

    RecyclerView recyclerView;
    List<version> versionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_row_fragment);

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