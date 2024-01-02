package org.javaacadmey.wonder_field.player;

public class PlayerAnswer {
    private char answerType; // 'б' - буква, 'с' - слово
    private String answer;

    public char getAnswerType() {
        return answerType;
    }

    public void setAnswerType(char answerType) {
        this.answerType = answerType;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
