package org.javaacadmey.wonder_field.components.yakubovich;

public enum YakubovichPhrases {
    START_SHOW("Якубович: Здравствуйте, уважаемые дамы и господа! Пятница! В эфире капитал-шоу «Поле чудес»!"),
    END_SHOW("Якубович: Мы прощаемся с вами ровно на одну неделю! Здоровья вам, до встречи!"),
    ASK_QUESTION("Якубович: Внимание вопрос! %s\n"),
    SPIN_DRUM("Якубович: %s, крутите барабан!\n"),

    INVITE_PLAYERS("Якубович: sприглашаю %d тройку игроков: %s\n"),
    INVITE_WINNERS("Якубович: приглашаю победителей групповых этапов: %s\n"),

    PLAYER_WINS_GROUP_ROUND("Якубович: Молодец! %s из %s проходит в финал!\n"),
    PLAYER_WINS_FINAL_ROUND(
            "Якубович: И перед нами победитель Капитал шоу поле чудес! " +
                    "Это %s из %s. Он набрал %d очков.\n"),

    BOX_WITH_MONEY_CHANCE("Якубович: Вы отгадали 3 буквы подряд и получили возможность открыть одну из шкатулок!"),
    HOW_MANY_MONEY_IN_BOX("Якубович: Откройте шкатулку! Вы получаете %d  фантиков.\n"),

    CORRECT_LETTER_GUESS("Якубович: Есть такая буква, откройте ее!"),
    NO_SUCH_LETTER("Якубович: Нет такой буквы!"),
    CORRECT_WORD_GUESS("Якубович: %s! Абсолютно верно!\n"),
    WRONG_WORD_GUESS("Якубович: Неверно!"),
    NEXT_PLAYER(" Следующий игрок."),

    YAKUBOVICH("Якубович: "),
    DRUM_SECTOR_WITH_POINT("Якубович: %d очков на барабане!\n"),
    DRUM_SECTOR_DOUBLING(" Заработанные игроком очки удваиваются, если он назовёт верную букву."),
    DRUM_SECTOR_SKIP_MOVE(" Игрок пропускает ход."),

    SUPER_GAME("Якубович: Добро пожаловать в супер игру! Вы можете назвать 3 буквы, а затем попробовать угадать слово."),
    GUESS_WORD_SUPER_GAME("Якубович: а теперь угадайте слово!"),
    SUPER_GIFT("Якубович: откройте супер приз: ");

    private final String text;

    YakubovichPhrases(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
