package ru.teamscore.dictionary;

import org.junit.jupiter.api.Test;
import ru.teamscore.dictionary.enums.SpeechPart;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {
    @Test
    void deleteDefinition(){
        Definition definition = new Definition(1, "Текст определения", SpeechPart.ADVERB);
        Word word1 = new Word(1,"базовая форма", definition);

        assertEquals(1, word1.getDefinitions().size());

        word1.deleteDefinition(2);
        assertEquals(1, word1.getDefinitions().size());

        word1.deleteDefinition(1);
        assertEquals(0, word1.getDefinitions().size());
    }
}