package com.yogo.scielearningportal.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Transcript {
    @Id
    private String id;
    private List<Semester> semeters;
    private String accademicYear;
    private double meanScore;
    private String studentId;
    private String meanGrade;
    private String recomendation;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Semester> getSemeters() {
        return semeters;
    }

    public void setSemeters(List<Semester> semeters) {
        this.semeters = semeters;
    }

    public String getAccademicYear() {
        return accademicYear;
    }

    public void setAccademicYear(String accademicYear) {
        this.accademicYear = accademicYear;
    }

    public double getMeanScore() {
        return meanScore;
    }

    public void setMeanScore(double meanScore) {
        this.meanScore = meanScore;
    }

    public String getMeanGrade() {
        return meanGrade;
    }

    public void setMeanGrade(String meanGrade) {
        this.meanGrade = meanGrade;
    }

    public String getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(String recomendation) {
        this.recomendation = recomendation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

}
