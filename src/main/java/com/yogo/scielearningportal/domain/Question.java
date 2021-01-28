package com.yogo.scielearningportal.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Question {
    @Id
    private String id;
    private String unitCode;
    private String question;
    private QuestionType type;
    private List<Choice> choices;
    private List<String> answers;
    private Difficult difficulty;
    private String description;
    private String explanation;
    private List<String> furtherReadings;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public List<String> getFurtherReadings() {
        return furtherReadings;
    }

    public void setFurtherReadings(List<String> furtherReadings) {
        this.furtherReadings = furtherReadings;
    }

    public Difficult getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficult difficulty) {
        this.difficulty = difficulty;
    }

}
