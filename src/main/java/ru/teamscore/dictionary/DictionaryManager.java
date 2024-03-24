package ru.teamscore.dictionary;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.SynchronizationType;
import jakarta.persistence.TypedQuery;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ru.teamscore.dictionary.entities.Definition;
import ru.teamscore.dictionary.entities.Synonym;
import ru.teamscore.dictionary.entities.Word;

import java.util.*;

@RequiredArgsConstructor
public class DictionaryManager {
    @Getter
    private List<Word> words = new ArrayList<>();

    private final EntityManager entityManager;

    @Getter
    private final DictionarySearch search = new DictionarySearch();

    @Getter
    private final DictionaryStatistic statistic = new DictionaryStatistic();

    public List<Word> getWordsPage(int page, int pageSize){
        String jpql = "SELECT word FROM Word word ORDER BY word.id";
        TypedQuery<Word> query = entityManager.createQuery(jpql, Word.class);
        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    public long getWordsCount() {
        return entityManager
                .createNamedQuery("wordsCount", Long.class)
                .getSingleResult();
    }

    public Optional<Word> getRandomWord(){
        Random random = new Random();
        try{
            long randomIndex = random.nextLong(getWordsCount());
            return Optional.of(entityManager.createNamedQuery("wordById", Word.class)
                    .setParameter("id", randomIndex)
                    .getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

    public Optional<Word> getWord(long id){
        try{
            return Optional.of(entityManager.createNamedQuery("wordById", Word.class)
                    .setParameter("id", id)
                    .getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

    public void addWord(@NonNull Word newWord) {
        entityManager.getTransaction().begin();
        entityManager.persist(newWord);
        entityManager.getTransaction().commit();
    }

    public void deleteWord(long id){
        entityManager.getTransaction().begin();
        if(getWord(id).isPresent())
            entityManager.remove(getWord(id).get());
        entityManager.getTransaction().commit();
    }


    public class DictionarySearch {
        public List<Word> searchWords(String basicForm, boolean registerCheck, boolean morphologyCheck){
            String jpql = "SELECT w FROM Word w WHERE ";
            if (!registerCheck) {
                basicForm = basicForm.toLowerCase();
            }
            if (registerCheck) {
                jpql += "w.basicForm = :basicForm";
            } else {
                jpql += "LOWER(w.basicForm) = :basicForm";
            }
            TypedQuery<Word> query = entityManager.createQuery(jpql, Word.class);
            query.setParameter("basicForm", basicForm);
            List<Word> words = query.getResultList();
            if(!morphologyCheck){
                words.addAll(searchWordsIgnoreMorphology(basicForm, registerCheck));
            }
            return words;
        }

        public List<Word> searchWordsIgnoreMorphology(String basicForm, boolean registerCheck){
            String jpql = "SELECT of FROM OtherForms of WHERE ";
            if (registerCheck) {
                jpql += "of.form = :basicForm";
            } else {
                jpql += "LOWER(of.form) = :basicForm";
            }
            TypedQuery<Word> query = entityManager.createQuery(jpql, Word.class);
            query.setParameter("basicForm", basicForm);

            return query.getResultList();
        }

//        public List<Word> searchWordsBySynonyms(List<Word> words){
//            List<Definition> definitions = new ArrayList<>();
//            for (Word word : words) {
//                String jpql = "SELECT d FROM Definition d JOIN Word w ON d.word = w.id " +
//                                "WHERE d.word = :wordId";
//                TypedQuery<Definition> query = entityManager.createQuery(jpql, Definition.class);
//                query.setParameter("wordId", word.getId());
//                definitions.addAll(query.getResultList());
//            }
//
//            List<Synonym> synonyms = new ArrayList<>();
//            for (Definition definition : definitions) {
//                String synonymJpql = "SELECT s FROM Synonyms s JOIN Definition d ON s.definition_id = d.id " +
//                        "WHERE s.definition_id = :id";
//                TypedQuery<Synonym> query = entityManager.createQuery(synonymJpql, Synonym.class);
//                query.setParameter("id", definition.getId());
//                synonyms.addAll(query.getResultList());
//            }
//
//            List<Word> words2 = new ArrayList<>();
//            for (Synonym synonym : synonyms) {
//                String synonymJpql = "SELECT w FROM Word w JOIN Synonym s ON w.id = s.synonym";
//                TypedQuery<Word> query = entityManager.createQuery(synonymJpql, Word.class);
//                words2.addAll(query.getResultList());
//            }
//
//            return words2;
//        }

        public List<Word> searchByDefinitionText(String definitionText){
            String jpql = "SELECT w FROM Word w JOIN Definition d ON w.id = d.word.id WHERE d.definitionText LIKE :definitionText";
            TypedQuery<Word> query = entityManager.createQuery(jpql, Word.class);
            query.setParameter("definitionText", definitionText);
            return query.getResultList();
        }
    }

    public class DictionaryStatistic{
        public long getQuantityWords(){
            return entityManager
                    .createNamedQuery("wordsCount", Long.class)
                    .getSingleResult();
        }

        public long getQuantityDefinition(){
            return entityManager
                    .createNamedQuery("definitionsCount", Long.class)
                    .getSingleResult();
        }

        public long getQuantitySynonyms(){
            return entityManager
                    .createNamedQuery("synonymsCount", Long.class)
                    .getSingleResult();
        }
    }
}
