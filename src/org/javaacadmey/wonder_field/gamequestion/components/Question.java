package org.javaacadmey.wonder_field.gamequestion.components;

public class Question {
    private String text;

    public Question(String question) {
        this.text = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + text + '\'' +
                '}';
    }
}
