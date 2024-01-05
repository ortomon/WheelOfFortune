package org.javaacadmey.wonder_field.gamequestion.components;

public class Answer {
    private String text;

    public Answer(String text) {
        this.text = text.toUpperCase();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text.toUpperCase().trim();
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + text + '\'' +
                '}';
    }
}
