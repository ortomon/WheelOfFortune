package org.javaacadmey.wonder_field.player;

import org.javaacadmey.wonder_field.TypePlayerAnswer;
import org.javaacadmey.wonder_field.gamequestion.components.Answer;

public class PlayerAnswer {
    private TypePlayerAnswer typePlayerAnswer;
    private Answer answer;

    public PlayerAnswer(TypePlayerAnswer typePlayerAnswer, Answer answer) {
        this.typePlayerAnswer = typePlayerAnswer;
        this.answer = answer;
    }

    public TypePlayerAnswer getTypePlayerAnswer() {
        return typePlayerAnswer;
    }

    public void setTypePlayerAnswer(TypePlayerAnswer typePlayerAnswer) {
        this.typePlayerAnswer = typePlayerAnswer;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
