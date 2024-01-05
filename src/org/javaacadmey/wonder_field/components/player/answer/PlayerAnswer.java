package org.javaacadmey.wonder_field.components.player.answer;

import org.javaacadmey.wonder_field.components.gamequestion.components.Answer;

public class PlayerAnswer extends Answer {
    private TypeAnswer typeAnswer;

    public PlayerAnswer(String text) {
        super(text);
    }

    public TypeAnswer getTypeAnswer() {
        return typeAnswer;
    }

    public void setTypeAnswer(TypeAnswer typeAnswer) {
        this.typeAnswer = typeAnswer;
    }


}
