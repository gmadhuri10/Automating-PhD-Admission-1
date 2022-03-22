package com.winash.uniapp.ui.AddCourse;

import java.io.Serializable;

public class Course implements Serializable {
    public String coursename;
    public String department;
    public String duration;
    public String outcome;
    public String syllabus;
    public String deadline;

    public Course() {
        this.coursename = null;
        this.department = null;
        this.duration = null;
        this.outcome = null;
        this.syllabus = null;
        this.campus = null;
        this.q10 = null;
        this.q12 = null;
        this.ug = null;
        this.pg = null;
        this.deadline=null;
    }

    public String campus;
    public String q10;
    public String q12;
    public String ug;
    public String pg;

    public String getDeadline() {
        return deadline;
    }

    public Course(String campus, String coursename,
                  String department,
                  String duration,
                  String outcome,
                  String pg,
                  String q10,
                  String q12,
                  String syllabus,
                  String ug,
                  String deadline
            ){
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
        this.deadline=deadline;
    }

    public String getCoursename() {
        return coursename;
    }

    public String getDepartment() {
        return department;
    }

    public String getDuration() {
        return duration;
    }

    public String getOutcome() {
        return outcome;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public String getCampus() {
        return campus;
    }

    public String getQ10() {
        return q10;
    }

    public String getQ12() {
        return q12;
    }

    public String getUg() {
        return ug;
    }

    public String getPg() {
        return pg;
    }
}
