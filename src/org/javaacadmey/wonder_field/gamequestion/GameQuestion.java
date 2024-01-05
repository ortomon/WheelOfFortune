package org.javaacadmey.wonder_field.gamequestion;

import org.javaacadmey.wonder_field.gamequestion.components.*;

public class GameQuestion extends Question{
    private Answer answer;

    public GameQuestion(String question, Answer answer) {
        super(question);
        this.answer = answer;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return super.toString() + "GameQuestion{" +
                "answer=" + answer +
                '}';
    }
}
