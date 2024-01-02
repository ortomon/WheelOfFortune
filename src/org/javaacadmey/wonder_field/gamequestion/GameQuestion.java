package org.javaacadmey.wonder_field.gamequestion;

import org.javaacadmey.wonder_field.gamequestion.components.Answer;
import org.javaacadmey.wonder_field.gamequestion.components.Question;

public class GameQuestion {
    private Question question;
    private Answer answer;

    public GameQuestion() {
    }

    public GameQuestion(Question question, Answer answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
