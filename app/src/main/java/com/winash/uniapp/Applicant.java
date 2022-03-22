package com.winash.uniapp;

public class Applicant {
    public String fname,lname,email;
    public String phone,applicantid;
    public boolean black;
public Applicant(){
    this.fname=null;
    this.lname=null;
    this.email=null;
    this.phone=null;
    this.black=false;
    this.applicantid=null;
}
    public String getFname() {
        return fname;
    }

    public boolean isBlack() {
        return black;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    public String getApplicantid() {
        return applicantid;
    }


    public Applicant(String fname, String lname, String email, String phone,boolean black,String applicantid){
        this.fname=fname;
        this.lname=lname;
        this.email=email;
        this.phone=phone;
        this.black=black;
        this.applicantid=applicantid;
    }
}
