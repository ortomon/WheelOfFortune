package org.javaacadmey.wonder_field.components.gamequestion;

import org.javaacadmey.wonder_field.Game;
import org.javaacadmey.wonder_field.components.gamequestion.components.Answer;

public class TestGameQuestion extends GameQuestion {
    public TestGameQuestion(String question, Answer answer) {
        super(question, answer);
    }

    public static GameQuestion[] initGameQuestion() {
        GameQuestion[] gameQuestions = new GameQuestion[Game.NUMBER_ROUNDS];
        for (int i = 0; i < gameQuestions.length; i++) {
            gameQuestions[i] =  new GameQuestion("Вопрос?", new Answer("ответ"));
        }
        return gameQuestions;
    }
}
