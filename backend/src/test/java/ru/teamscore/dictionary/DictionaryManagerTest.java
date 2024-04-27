//package ru.teamscore.dictionary;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import org.hibernate.cfg.Configuration;
//import org.junit.jupiter.api.*;
//
//import ru.teamscore.dictionary.model.entities.Definition;
//import ru.teamscore.dictionary.model.entities.OtherForm;
//import ru.teamscore.dictionary.model.entities.Synonym;
//import ru.teamscore.dictionary.model.entities.Word;
//
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//class DictionaryManagerTest {
//    private static EntityManagerFactory entityManagerFactory;
//    private EntityManager entityManager;
//
//
//    @BeforeAll
//    public static void setup() throws IOException {
//        entityManagerFactory = new Configuration()
//                .configure("hibernate-postgres.cfg.xml")
//                .addAnnotatedClass(Word.class)
//                .addAnnotatedClass(Definition.class)
//                .addAnnotatedClass(OtherForm.class)
//                .addAnnotatedClass(Synonym.class)
//                .buildSessionFactory();
//
//        SqlScripts.runFromFile(entityManagerFactory, "createAll.sql");
//    }
//
//    @AfterAll
//    public static void tearDown() {
//        if (entityManagerFactory != null) {
//            entityManagerFactory.close();
//        }
//    }
//
//    @BeforeEach
//    public void openSession() throws IOException {
//        SqlScripts.runFromFile(entityManagerFactory, "insertAll.sql");
//        entityManager = entityManagerFactory.createEntityManager();
//    }
//
//    @AfterEach
//    public void closeSession() throws IOException {
//        if (entityManager != null) {
//            entityManager.close();
//        }
//        SqlScripts.runFromFile(entityManagerFactory, "clearAll.sql");
//    }
//
//    DictionaryManager testDictionaryManager;
//
//    @Test
//    void getWordsPage(){
//        testDictionaryManager = new DictionaryManager(entityManager);
//        assertEquals(5, testDictionaryManager.getWordsPage(0, 5).size());
//        assertEquals(2, testDictionaryManager.getWordsPage(3, 5).size());
//    }
//
//    @Test
//    void getRandomWord() {
//        testDictionaryManager = new DictionaryManager(entityManager);
//        var result = testDictionaryManager.getRandomWord();
//        assertTrue(result.isPresent());
//    }
//
//    @Test
//    void getWord() {
//        testDictionaryManager = new DictionaryManager(entityManager);
//        var result = testDictionaryManager.getWord(2);
//        assertEquals("Бегать", result.get().getBasicForm());
//    }
//
//    @Test
//    void addItem() {
//        testDictionaryManager = new DictionaryManager(entityManager);
//        Word[] wordsToAdd = new Word[]{
//                Word.load(
//                        0,
//                        "Карандаш"
//                ),
//                Word.load(
//                        0,
//                        "Ноутбук"
//                )
//        };
//        long startCount = testDictionaryManager.getWordsCount();
//        testDictionaryManager.addWord(wordsToAdd[0]);
//        assertEquals(startCount + 1, testDictionaryManager.getWordsCount(), "Item added");
//        testDictionaryManager.addWord(wordsToAdd[0]);
//        assertEquals(startCount + 1, testDictionaryManager.getWordsCount(), "Item not added, already exists");
//        testDictionaryManager.addWord(wordsToAdd[1]);
//        assertEquals(startCount + 2, testDictionaryManager.getWordsCount(), "Item added");
//    }
//
//    @Test
//    void deleteWord() {
//        testDictionaryManager = new DictionaryManager(entityManager);
//        testDictionaryManager.deleteWord(0);
//        assertEquals(17, testDictionaryManager.getWordsCount());
//        testDictionaryManager.deleteWord(2);
//        assertEquals(16, testDictionaryManager.getWordsCount());
//    }
//
//
//    @Test
//    void searchWords(){
//        testDictionaryManager = new DictionaryManager(entityManager);
//        assertEquals(0, testDictionaryManager.getSearch().searchWords("книга", true, true).size());
//        assertEquals(1, testDictionaryManager.getSearch().searchWords("книга", false, true).size());
//        assertEquals(0, testDictionaryManager.getSearch().searchWords("Книгу", false, true).size());
//        assertEquals(1, testDictionaryManager.getSearch().searchWords("Книгу", false, false).size());
//    }
//
//    @Test
//    void searchByDefinitionText(){
//        testDictionaryManager = new DictionaryManager(entityManager);
//        assertEquals(1, testDictionaryManager.getSearch().searchByDefinitionText("Делать резкий прыжок с ноги на ногу. Действие быстрое и энергичное.").size());
//        assertEquals(0, testDictionaryManager.getSearch().searchByDefinitionText("Текст определения").size());
//    }
//
//    @Test
//    void getQuantityDefinition(){
//        testDictionaryManager = new DictionaryManager(entityManager);
//        assertEquals(17, testDictionaryManager.getStatistic().getQuantityDefinition());
//    }
//
//    @Test
//    void getQuantitySynonyms(){
//        testDictionaryManager = new DictionaryManager(entityManager);
//        assertEquals(2, testDictionaryManager.getStatistic().getQuantitySynonyms());
//    }
//}