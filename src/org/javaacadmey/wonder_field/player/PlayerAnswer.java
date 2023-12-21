package org.javaacadmey.wonder_field.player;

public class PlayerAnswer {
    private boolean isWord;
    private String answer;

    public PlayerAnswer(boolean isWord, String answer) {
        this.isWord = isWord;
        this.answer = answer;
    }

    public boolean getIsWord() {
        return isWord;
    }

    public void setIsWord(boolean word) {
        isWord = word;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
