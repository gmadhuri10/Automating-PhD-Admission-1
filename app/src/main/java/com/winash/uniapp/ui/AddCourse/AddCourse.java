package com.winash.uniapp.ui.AddCourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.winash.uniapp.AdminDashboard;
import com.winash.uniapp.LoginUser;
import com.winash.uniapp.R;
import com.winash.uniapp.RegisterUser;

public class AddCourse extends Fragment implements View.OnClickListener {
private TextView CourseName,Department,Duration,Outcome,Syllabus,Campus,q10th,q12th,qUG,qPG;
private Button addcourse;
private FirebaseAuth fAuth;
private DatabaseReference ref;
private ProgressBar progress;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_add_course,container, false);
        CourseName=(TextView) view.findViewById(R.id.InputCourseName);
        Department=(TextView) view.findViewById(R.id.InputCourseDepartment);
        Duration=(TextView) view.findViewById(R.id.InputCourseDuration);
        Outcome=(TextView) view.findViewById(R.id.InputCourseOutcome);
        Syllabus=(TextView) view.findViewById(R.id.InputCourseSyllabus);
        Campus=(TextView) view.findViewById(R.id.InputCourseCampus);
        q10th=(TextView) view.findViewById(R.id.InputCourse10th);
        q12th=(TextView) view.findViewById(R.id.InputCourse12th);
        qUG=(TextView) view.findViewById(R.id.InputCourseUG);
        qPG=(TextView) view.findViewById(R.id.InputCoursePG);
        addcourse=(Button) view.findViewById(R.id.AddCourserBtn);
        fAuth=FirebaseAuth.getInstance();
        ref=FirebaseDatabase.getInstance().getReference();
        progress=(ProgressBar) view.findViewById(R.id.progressBarAddCourse);
        addcourse.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        String coursename=CourseName.getText().toString().trim();
        String department=Department.getText().toString().trim();
        String duration=Duration.getText().toString().trim();
        String outcome=Outcome.getText().toString().trim();
        String syllabus=Syllabus.getText().toString().trim();
        String campus=Campus.getText().toString().trim();
        String tempq10=q10th.getText().toString();
        String tempq12=q10th.getText().toString();
        String tempqug=q10th.getText().toString();
        String tempqpg=q10th.getText().toString();
        int q10=Integer.parseInt(tempq10);
        int q12=Integer.parseInt(tempq12);
        float ug=Float.parseFloat(tempqug);
        float pg=Float.parseFloat(tempqpg);
        if(coursename.isEmpty())
        {
            CourseName.setError("Course Name Required!!!");
            CourseName.requestFocus();
            return;
        }
        if(department.isEmpty())
        {
            Department.setError("Department Name Required!!!");
            Department.requestFocus();
            return;
        }
        if(duration.isEmpty())
        {
            Duration.setError("Duration Name Required!!!");
            Duration.requestFocus();
            return;
        }if(outcome.isEmpty())
        {
            Outcome.setError("Outcome Name Required!!!!");
            Outcome.requestFocus();
            return;
        }if(syllabus.isEmpty())
        {
            Syllabus.setError("Syllabus Name Required!!!");
            Syllabus.requestFocus();
            return;
        }if(campus.isEmpty())
        {
            Campus.setError("Campus Name Required!!!");
            Campus.requestFocus();
            return;
        }if(tempq10.isEmpty())
        {
            q10th.setError("10th mark Required!!!");
            q10th.requestFocus();
            return;
        }if(tempq12.isEmpty())
        {
            q12th.setError("12th mark Required!!!");
            q12th.requestFocus();
            return;
        }if(tempqug.isEmpty())
        {
            qUG.setError("UG mark Required!!!");
            qUG.requestFocus();
            return;
        }if(tempqpg.isEmpty())
        {
            qPG.setError("PG mark Required!!!");
            qPG.requestFocus();
            return;
        }
        progress.setVisibility(View.VISIBLE);
        Course newcourse=new Course(coursename,department,duration,outcome,syllabus,campus,q10,q12,ug,pg);
        ref.child("Course").child(coursename).setValue(newcourse).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getActivity(), "Course has been successfully Added", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getActivity(), AdminDashboard.class));
                    progress.setProgress(View.INVISIBLE);
                }else
                {
                    Toast.makeText(getActivity(), "An error Occured while Registering", Toast.LENGTH_SHORT).show();
                    progress.setProgress(View.INVISIBLE);
                }
                progress.setProgress(View.INVISIBLE);
            }
        });
    }
}