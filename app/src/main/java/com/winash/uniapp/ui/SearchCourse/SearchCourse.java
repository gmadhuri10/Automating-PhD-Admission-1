package com.winash.uniapp.ui.SearchCourse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.winash.uniapp.R;

import java.util.ArrayList;

public class SearchCourse extends Fragment {
    private RecyclerView recycleview;
    private SearchView search;
    private ArrayList<String> list;
    private String[] a={"ashwin","ashwin","ashwin","ashwin","ashwin","ashwin","ashwin","ashwin","ashwin","ashwin"};
    private String[] b={"ashwin","ashwin","ashwin","ashwin","ashwin","ashwin","ashwin","ashwin","ashwin","ashwin"};
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_search_course,container, false);
        recycleview=(RecyclerView) view.findViewById(R.id.Search_Recycler_View);
        search=(SearchView) view.findViewById(R.id.Search_course_field);
        list=new ArrayList<>();
        SearchCourseAdapter adapter= new SearchCourseAdapter(a,b,view.getContext());
        recycleview.setAdapter(adapter);
        recycleview.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }
}