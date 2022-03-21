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
import com.winash.uniapp.ui.AddCourse.Course;

import java.util.ArrayList;

public class SearchCourseAdapter extends RecyclerView.Adapter<SearchCourseAdapter.MyViewHolder> {
    public ArrayList<Course> list;
    public Context context;
    public SearchCourseAdapter(ArrayList<Course> a,Context context){
        this.list=a;
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
        Course course=list.get(position);
        holder.coursename.setText(course.getCoursename());
        holder.campus.setText(course.getCampus());
        holder.syllabus.setText(course.getSyllabus());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView coursename,campus,syllabus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            coursename=itemView.findViewById(R.id.CourseNameDisplay);
            campus=itemView.findViewById(R.id.CourseCampusDisplay);
            syllabus=itemView.findViewById(R.id.CourseSyllabusDisplay);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
