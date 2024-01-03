package org.javaacadmey.wonder_field.player;

import org.javaacadmey.wonder_field.TypeAnswer;
import org.javaacadmey.wonder_field.gamequestion.components.Answer;

public class PlayerAnswer extends Answer {
    private TypeAnswer typeAnswer;

    public PlayerAnswer(String answer, TypeAnswer typeAnswer) {
        super(answer);
        this.typeAnswer = typeAnswer;
    }

    public TypeAnswer getTypeAnswer() {
        return typeAnswer;
    }

    public void setTypeAnswer(TypeAnswer typeAnswer) {
        this.typeAnswer = typeAnswer;
    }


}
