package com.yogo.scielearningportal.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Semester {
    @Id
    private String id;
    private String title;
    private String accademiYear;
    private List<Unit> units;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAccademiYear() {
        return accademiYear;
    }

    public void setAccademiYear(String accademiYear) {
        this.accademiYear = accademiYear;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

}
