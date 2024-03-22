package ru.teamscore.dictionary;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import lombok.NonNull;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;
import ru.teamscore.dictionary.entities.Definition;
import ru.teamscore.dictionary.entities.OtherForms;
import ru.teamscore.dictionary.entities.Synonym;
import ru.teamscore.dictionary.entities.Word;

import java.io.IOException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DefinitionManagerTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void setup() throws IOException {
        entityManagerFactory = new Configuration()
                .configure("hibernate-postgres.cfg.xml")
                .addAnnotatedClass(Word.class)
                .addAnnotatedClass(Definition.class)
                .addAnnotatedClass(OtherForms.class)
                .addAnnotatedClass(Synonym.class)
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

    DefinitionManager testDefinitionManager;

    @Test
    void addSource() {
        testDefinitionManager = new DefinitionManager(entityManager);
        String sql = "select count(*) from definitions.source";
        Query query = entityManager.createNativeQuery(sql);
        long count = ((Number) query.getSingleResult()).longValue();
        assertEquals(17, count);

        testDefinitionManager.addSource(2, "Ресурс");
        count = ((Number) query.getSingleResult()).longValue();
        assertEquals(18, count);
    }

    @Test
    void deleteSource() {
        testDefinitionManager = new DefinitionManager(entityManager);
        String sql = "select count(*) from definitions.source";
        Query query = entityManager.createNativeQuery(sql);
        long count = ((Number) query.getSingleResult()).longValue();
        assertEquals(17, count);

        testDefinitionManager.deleteSource(2, "Энциклопедия \"Слово\"");
        count = ((Number) query.getSingleResult()).longValue();
        assertEquals(16, count);
    }

    @Test
    void deleteDefinition(){
        testDefinitionManager = new DefinitionManager(entityManager);
        testDefinitionManager.deleteDefinition(0);
        assertEquals(17, testDefinitionManager.getDefinitionsCount());
        testDefinitionManager.deleteDefinition(2);
        assertEquals(16, testDefinitionManager.getDefinitionsCount());
    }

}