package ru.teamscore.dictionary;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.teamscore.dictionary.enums.SpeechPart;

import static org.junit.jupiter.api.Assertions.*;

class DefinitionTest {
    Definition definition = new Definition("Текст определения", SpeechPart.ADVERB);
    Word word1 = new Word("базовая форма", definition);

    @ParameterizedTest
    @ValueSource(strings = {"http://www.example.com", "https://example.com/path/to/page",
            "https://example.com/path/to/page.html", "https://www.example.com/page?query=1"})
    void isUrlTrue(String value) {
        assertTrue(Definition.isUrl(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"www.example.com", "https://://example.com/path/to/page",
            "http:///www.example.com?query=1#fragment", "", "abcdeabcde123"})
    void isValidFalse(String value) {
        assertFalse(Definition.isUrl(value));
    }

    @Test
    void deleteSynonym() {
        Definition definition2 = new Definition("Текст определения 2", SpeechPart.ADJECTIVE);
        Word word2 = new Word("форма", definition2);
        definition.addSynonym(word2);
        assertEquals(1, definition.getSynonyms().size());

        definition.deleteSynonym("форма1");
        assertEquals(1, definition.getSynonyms().size());

        definition.deleteSynonym("форма");
        assertEquals(0, definition.getSynonyms().size());

        definition.deleteSynonym("форма");
        assertEquals(0, definition.getSynonyms().size());
    }

    @Test
    void deleteSource() {
        definition.addSource("ресурс");
        assertEquals(0, definition.getSources().size());
        definition.deleteSource("ресурс");
        assertEquals(0, definition.getSources().size());

        definition.addSource("https://ya.ru");
        assertEquals(1, definition.getSources().size());
        definition.deleteSource("https://ya.ru");
        assertEquals(0, definition.getSources().size());
    }
}