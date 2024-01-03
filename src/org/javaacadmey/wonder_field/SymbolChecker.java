package org.javaacadmey.wonder_field;

public interface SymbolChecker {
    default boolean symbolIsCyrillic(char letter) {
        if (!Character.UnicodeBlock.CYRILLIC.equals(Character.UnicodeBlock.of(letter))) {
            System.out.println("Ошибка! это не русская буква.");
            return false;
        }
        return true;
    }
}
