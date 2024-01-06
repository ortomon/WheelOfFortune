package org.javaacadmey.wonder_field.components.player;

public class SymbolChecker {
    public static boolean symbolIsCyrillic(char letter) {
        if (!Character.UnicodeBlock.CYRILLIC.equals(Character.UnicodeBlock.of(letter))) {
            System.out.println("Ошибка! это не русская буква. Введите русскую букву");
            return false;
        }
        return true;
    }
}
