package ru.teamscore.dictionary;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import ru.teamscore.dictionary.entities.Word;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DictionaryManagerTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    //List<Word> testWords = new ArrayList<>();

//    //добавление 5 слов
//    {
//        testWords.add(new Word(
//                    1,
//                    "слово 1",
//                    new Definition(1, "Текст определения 1", SpeechPart.ADVERB)
//        ));
//        testWords.add(new Word(
//                    2,
//                    "Слово 2",
//                    new Definition(1, "Текст определения 1", SpeechPart.ADJECTIVE)
//        ));
//        testWords.add(new Word(
//                    3,
//                    "слово 3",
//                    new Definition(1, "Текст определения 1", SpeechPart.NOUN)
//        ));
//        testWords.add(new Word(
//                    4,
//                    "слово 4",
//                    new Definition(1, "Текст определения 1", SpeechPart.ADVERB)
//        ));
//        testWords.add(new Word(
//                    5,
//                    "слово 5",
//                    new Definition(1, "Текст определения 1", SpeechPart.VERB)
//        ));
//    }
//


//
//    //добавление к каждому из 5 слов по 3 словоформы
//    {
//        Iterator<Word> iterator = testWords.iterator();
//        int k = 0;
//        while (iterator.hasNext()) {
//            Word word = iterator.next();
//            k++;
//            for (int i = 0; i < 3; i++){
//                word.getOtherForms().addForm("форма " + k + "_" + i);
//            }
//        }
//    }
//
//    //добавление к каждому из 5 слов по 1 синониму -> всего 10 слов в словаре
//    {
//        Iterator<Word> iterator = testWords.iterator();
//        int k = 0;
//        while (iterator.hasNext()) {
//            Word word = iterator.next();
//            k++;
//            word.getDefinition(1).addSynonym(new Word(
//                    5 + k,
//                    "слово " + (5 + k),
//                    new Definition(1, "Текст определения 2", word.getDefinition(1).getSpeechPart()),
//                    testDictionaryManager));
//        }
//    }

    @BeforeAll
    public static void setup() throws IOException {
        entityManagerFactory = new Configuration()
                .configure("hibernate-postgres.cfg.xml")
                .addAnnotatedClass(Word.class)
                .buildSessionFactory();

        SqlScripts.runFromFile(entityManagerFactory, "createAll.sql");
    }

    @AfterAll
    public static void tearDown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    @BeforeEach
    public void openSession() throws IOException {
        SqlScripts.runFromFile(entityManagerFactory, "insertAll.sql");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    public void closeSession() throws IOException {
        if (entityManager != null) {
            entityManager.close();
        }
        SqlScripts.runFromFile(entityManagerFactory, "clearAll.sql");
    }

    DictionaryManager testDictionaryManager = new DictionaryManager(entityManager);

    @Test
    void getWordsPage(){
        assertEquals(5, testDictionaryManager.getWordsPage(0, 5));
        assertEquals(5, testDictionaryManager.getWordsPage(3, 5));
    }

//    @Test
//    void getWords() {
//        assertEquals(1, testDictionaryManager.getWordsPage(0,2).get(0).getId());
//        assertEquals(3, testDictionaryManager.getWordsPage(1,2).get(0).getId());
//
//        assertEquals(1, testDictionaryManager.getWordsPage(3,3).size());
//
//        assertEquals(10, testDictionaryManager.getWordsPage(0,15).size());
//    }
//
//    @Test
//    void getRandomWord() {
//        assertTrue(testWords.contains(testDictionaryManager.getRandomWord()));
//    }
//
//    @Test
//    void addWord() {
//        Word newWord = new Word(5,"слово", new Definition(
//                1, "Текст определения 1", SpeechPart.VERB));
//        testDictionaryManager.addWord(newWord);
//        assertEquals(10, testDictionaryManager.getWords().size());
//
//        newWord = new Word(11,"слово", new Definition(
//                1, "Текст определения 1", SpeechPart.VERB));
//        testDictionaryManager.addWord(newWord);
//        assertEquals(11, testDictionaryManager.getWords().size());
//    }
//
//    @Test
//    void deleteWord() {
//        testDictionaryManager.deleteWord(20);
//        assertEquals(10, testDictionaryManager.getWords().size());
//
//        testDictionaryManager.deleteWord(5);
//        assertEquals(9, testDictionaryManager.getWords().size());
//
//        testDictionaryManager.deleteWord(1);
//        assertEquals(8, testDictionaryManager.getWords().size());
//    }
//
//
//    @Test
//    void searchWords(){
//        assertEquals(0, testDictionaryManager.getSearch().searchWords("слово 2", true).size());
//        assertEquals(1, testDictionaryManager.getSearch().searchWords("Слово 2", false).size());
//    }
//
//    @Test
//    void searchWordsIgnoreMorphology(){
//        assertEquals(1, testDictionaryManager.getSearch().searchWordsIgnoreMorphology("форма 1_1", false).size());
//        assertEquals(1, testDictionaryManager.getSearch().searchWordsIgnoreMorphology("слово 1", false).size());
//        assertEquals(0, testDictionaryManager.getSearch().searchWordsIgnoreMorphology("абвгд", false).size());
//    }
//
//    @Test
//    void searchBySynonyms(){
//        assertEquals(1, testDictionaryManager.getSearch().searchBySynonyms("слово 6", false).size());
//        assertEquals(1, testDictionaryManager.getSearch().searchBySynonyms("слово 7", false).size());
//        assertEquals(0, testDictionaryManager.getSearch().searchBySynonyms("абвгд", false).size());
//    }
//
//    @Test
//    void searchByDefinitionText(){
//        assertEquals(5, testDictionaryManager.getSearch().searchByDefinitionText("Текст определения 1").size());
//        assertEquals(5, testDictionaryManager.getSearch().searchByDefinitionText("Текст определения 2").size());
//        assertEquals(0, testDictionaryManager.getSearch().searchByDefinitionText("абвгд").size());
//    }
//
//    @Test
//    void getQuantityDefinition(){
//        assertEquals(10, testDictionaryManager.getStatistic().getQuantityDefinition());
//
//        testWords.get(1).addDefinition(new Definition(2, "Текст определения 2", SpeechPart.NOUN));
//        assertEquals(11, testDictionaryManager.getStatistic().getQuantityDefinition());
//    }
//
//    @Test
//    void getQuantitySynonyms(){
//        assertEquals(5, testDictionaryManager.getStatistic().getQuantitySynonyms());
//
//        testWords.get(1).getDefinition(1).addSynonym(new Word(
//                11,
//                "слово 11",
//                new Definition(1, "Текст определения 2", testWords.get(1).getDefinition(1).getSpeechPart()),
//                testDictionaryManager));
//        assertEquals(6, testDictionaryManager.getStatistic().getQuantitySynonyms());
//    }
}