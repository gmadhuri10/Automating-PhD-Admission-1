package com.winash.uniapp.ui.SearchCourse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.winash.uniapp.R;

public class SearchCourseAdapter extends RecyclerView.Adapter<SearchCourseAdapter.MyViewHolder> {
    public String a[];
    public String b[];
    public Context context;
    public SearchCourseAdapter(String a[],String b[],Context context){
        this.a=a;
        this.b=b;
        this.context=context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.my_search_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.coursename.setText(a[position]);
        holder.description.setText(b[position]);
    }

    @Override
    public int getItemCount() {
        return a.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView coursename,description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            coursename=itemView.findViewById(R.id.CourseNameDisplay);
            description=itemView.findViewById(R.id.CourseDescriptionDisplay);
        }
    }
}
