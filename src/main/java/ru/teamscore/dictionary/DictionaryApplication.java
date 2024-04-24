package ru.teamscore.dictionary;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.teamscore.dictionary.model.entities.Definition;
import ru.teamscore.dictionary.model.entities.OtherForm;
import ru.teamscore.dictionary.model.entities.Synonym;
import ru.teamscore.dictionary.model.entities.Word;

@SpringBootApplication
public class DictionaryApplication {
    public static void main(String[] args) {
        // RestartClassLoader иногда вызывает конфликты классов при использовании java.util.stream
        // из-за загрузки в два разных class loader. Пример ошибки:
        // class ru.teamscore.java23.orders.model.statistics.OrdersStatistics cannot be cast
        // to class ru.teamscore.java23.orders.model.statistics.OrdersStatistics
        // (ru.teamscore.java23.orders.model.statistics.OrdersStatistics is in unnamed module of loader 'app';
        // ru.teamscore.java23.orders.model.statistics.OrdersStatistics is in unnamed module of loader
        // org.springframework.boot.devtools.restart.classloader.RestartClassLoader @61589606)
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(DictionaryApplication.class, args);
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Word.class)
                .addAnnotatedClass(OtherForm.class)
                .addAnnotatedClass(Synonym.class)
                .addAnnotatedClass(Definition.class)
                .buildSessionFactory();
    }

    @Bean
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

}