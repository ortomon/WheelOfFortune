package org.javaacadmey.wonder_field.gamequestion.components;

public class Question {
    private String question;

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                '}';
    }
}
