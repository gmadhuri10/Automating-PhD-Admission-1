package com.winash.uniapp.ui.AddCourse;

public class Course {
    public String coursename;
    public String department;
    public String duration;
    public String outcome;
    public String syllabus;
    public String campus;
    public int q10;
    public int q12;
    public float ug;
    public float pg;
    Course(String coursename,
            String department,
            String duration,
            String outcome,
            String syllabus,
            String campus,
            int q10,
            int q12,
            float ug,
            float pg){
        this.coursename=coursename;
        this.department=department;
        this.duration=duration;
        this.outcome=outcome;
        this.syllabus=syllabus;
        this.campus=campus;
        this.q10=q10;
        this.q12=q12;
        this.ug=ug;
        this.pg=pg;
    }
}
