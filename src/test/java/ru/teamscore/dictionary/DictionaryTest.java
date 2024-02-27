package ru.teamscore.dictionary;

import org.junit.jupiter.api.Test;
import ru.teamscore.dictionary.enums.SpeechPart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DictionaryTest {
    List<Word> testWords = new ArrayList<>();

    //добавление 5 слов
    {
        testWords.add(new Word(
                    1,
                    "слово 1",
                    new Definition(1, "Текст определения 1", SpeechPart.ADVERB)
        ));
        testWords.add(new Word(
                    2,
                    "Слово 2",
                    new Definition(1, "Текст определения 1", SpeechPart.ADJECTIVE)
        ));
        testWords.add(new Word(
                    3,
                    "слово 3",
                    new Definition(1, "Текст определения 1", SpeechPart.NOUN)
        ));
        testWords.add(new Word(
                    4,
                    "слово 4",
                    new Definition(1, "Текст определения 1", SpeechPart.ADVERB)
        ));
        testWords.add(new Word(
                    5,
                    "слово 5",
                    new Definition(1, "Текст определения 1", SpeechPart.VERB)
        ));
    }

    Dictionary testDictionary = new Dictionary(testWords);

    //добавление к каждому из 5 слов по 3 словоформы
    {
        Iterator<Word> iterator = testWords.iterator();
        int k = 0;
        while (iterator.hasNext()) {
            Word word = iterator.next();
            k++;
            for (int i = 0; i < 3; i++){
                word.getOtherForms().addForm("форма " + k + "_" + i);
            }
        }
    }

    //добавление к каждому из 5 слов по 1 синониму -> всего 10 слов в словаре
    {
        Iterator<Word> iterator = testWords.iterator();
        int k = 0;
        while (iterator.hasNext()) {
            Word word = iterator.next();
            k++;
            word.getDefinition(1).addSynonym(new Word(
                    5 + k,
                    "слово " + (5 + k),
                    new Definition(1, "Текст определения 2", word.getDefinition(1).getSpeechPart()),
                    testDictionary));
        }
    }



    @Test
    void getWords() {
        assertEquals(1, testDictionary.getWordsPage(0,2).get(0).getId());
        assertEquals(3, testDictionary.getWordsPage(1,2).get(0).getId());

        assertEquals(1, testDictionary.getWordsPage(3,3).size());

        assertEquals(10, testDictionary.getWordsPage(0,15).size());
    }

    @Test
    void getRandomWord() {
        assertTrue(testWords.contains(testDictionary.getRandomWord()));
    }

    @Test
    void addWord() {
        Word newWord = new Word(5,"слово", new Definition(
                1, "Текст определения 1", SpeechPart.VERB));
        testDictionary.addWord(newWord);
        assertEquals(10, testDictionary.getWords().size());

        newWord = new Word(11,"слово", new Definition(
                1, "Текст определения 1", SpeechPart.VERB));
        testDictionary.addWord(newWord);
        assertEquals(11, testDictionary.getWords().size());
    }

    @Test
    void deleteWord() {
        testDictionary.deleteWord(20);
        assertEquals(10, testDictionary.getWords().size());

        testDictionary.deleteWord(5);
        assertEquals(9, testDictionary.getWords().size());

        testDictionary.deleteWord(1);
        assertEquals(8, testDictionary.getWords().size());
    }


    @Test
    void searchWords(){
        assertEquals(0, testDictionary.getSearch().searchWords("слово 2", true).size());
        assertEquals(1, testDictionary.getSearch().searchWords("Слово 2", false).size());
    }

    @Test
    void searchWordsIgnoreMorphology(){
        assertEquals(1, testDictionary.getSearch().searchWordsIgnoreMorphology("форма 1_1", false).size());
        assertEquals(1, testDictionary.getSearch().searchWordsIgnoreMorphology("слово 1", false).size());
        assertEquals(0, testDictionary.getSearch().searchWordsIgnoreMorphology("абвгд", false).size());
    }

    @Test
    void searchBySynonyms(){
        assertEquals(1, testDictionary.getSearch().searchBySynonyms("слово 6", false).size());
        assertEquals(1, testDictionary.getSearch().searchBySynonyms("слово 7", false).size());
        assertEquals(0, testDictionary.getSearch().searchBySynonyms("абвгд", false).size());
    }

    @Test
    void searchByDefinitionText(){
        assertEquals(5, testDictionary.getSearch().searchByDefinitionText("Текст определения 1").size());
        assertEquals(5, testDictionary.getSearch().searchByDefinitionText("Текст определения 2").size());
        assertEquals(0, testDictionary.getSearch().searchByDefinitionText("абвгд").size());
    }

    @Test
    void getQuantityDefinition(){
        assertEquals(10, testDictionary.getStatistic().getQuantityDefinition());

        testWords.get(1).addDefinition(new Definition(2, "Текст определения 2", SpeechPart.NOUN));
        assertEquals(11, testDictionary.getStatistic().getQuantityDefinition());
    }

    @Test
    void getQuantitySynonyms(){
        assertEquals(5, testDictionary.getStatistic().getQuantitySynonyms());

        testWords.get(1).getDefinition(1).addSynonym(new Word(
                11,
                "слово 11",
                new Definition(1, "Текст определения 2", testWords.get(1).getDefinition(1).getSpeechPart()),
                testDictionary));
        assertEquals(6, testDictionary.getStatistic().getQuantitySynonyms());
    }
}