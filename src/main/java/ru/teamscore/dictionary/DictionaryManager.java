package ru.teamscore.dictionary;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ru.teamscore.dictionary.entities.Definition;
import ru.teamscore.dictionary.entities.Word;

import java.util.*;

@RequiredArgsConstructor
public class DictionaryManager {
    @Getter
    private List<Word> words = new ArrayList<>();

    private final EntityManager entityManager;

    @Getter
    private final DictionarySearch search = new DictionarySearch();

//    @Getter
//    private final DictionaryStatistic statistic = new DictionaryStatistic();

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

//        public List<Word> searchWordsSynonym(String basicForm, boolean registerCheck){
//            String jpql = "SELECT of FROM OtherForms of WHERE ";
//            if (registerCheck) {
//                jpql += "of.form = :basicForm";
//            } else {
//                jpql += "LOWER(of.form) = :basicForm";
//            }
//            TypedQuery<Word> query = entityManager.createQuery(jpql, Word.class);
//            query.setParameter("basicForm", basicForm);
//
//            return query.getResultList();
//        }

//        public List<Word> searchBySynonyms(String basicForm, boolean registerCheck){
//            if(!registerCheck)
//                basicForm = basicForm.toLowerCase();
//            List<Word> foundWords = new ArrayList<>();
//            for(Word word : words){
//                if((registerCheck ? word.getBasicForm() : word.getBasicForm().toLowerCase()).equals(basicForm)){
//                    foundWords.add(word);
//                }else {
//                    for(String form : word.getOtherForms().getForms()){
//                        if((registerCheck ? form : form.toLowerCase()).equals(basicForm)){
//                            foundWords.add(word);
//                        }
//                    }
//                }
//            }
//            return foundWords;
//        }
//
//        public List<Word> searchByDefinitionText(String definitionText) {
//            List<Word> foundWords = new ArrayList<>();
//            for(Word word : words){
//                for (Definition definition : word.getDefinitions()){
//                    if(definition.getDefinitionText() == definitionText)
//                        foundWords.add(word);
//                }
//            }
//            return foundWords;
//        }
    }

//    public class DictionaryStatistic{
//        public int getQuantityWords(){
//            return words.size();
//        }
//
//        public int getQuantityDefinition(){
//            int quantity = 0;
//            for (Word word : words){
//                quantity += word.getDefinitions().size();
//            }
//            return quantity;
//        }
//
//        public int getQuantitySynonyms(){
//            int quantity = 0;
//            for (Word word : words){
//                for(Definition definition : word.getDefinitions()) {
//                    quantity += definition.getSynonyms().size();
//                }
//            }
//            return quantity;
//        }
//    }
}
