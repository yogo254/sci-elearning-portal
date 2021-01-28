package com.yogo.scielearningportal.domain;

import java.util.List;

public class Unit {

    private String id;
    private String code;
    private String title;
    private int hours;
    private String courseId;
    private String department;
    private String lectureId;
    private String finalgrade;
    private List<Cat> cats;
    private double catScore;
    private double mainExamScore;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLectureId() {
        return lectureId;
    }

    public void setLectureId(String lectureId) {
        this.lectureId = lectureId;
    }

    public String getFinalgrade() {
        return finalgrade;
    }

    public void setFinalgrade(String finalgrade) {
        this.finalgrade = finalgrade;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    public double getCatScore() {
        return catScore;
    }

    public void setCatScore(double catScore) {
        this.catScore = catScore;
    }

    public double getMainExamScore() {
        return mainExamScore;
    }

    public void setMainExamScore(double mainExamScore) {
        this.mainExamScore = mainExamScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
