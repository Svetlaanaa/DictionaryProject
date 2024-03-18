package ru.teamscore.dictionary;

import jakarta.persistence.EntityManager;
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

    @Getter
    private final DictionaryStatistic statistic = new DictionaryStatistic();

//    public DictionaryManager(List<Word> words){
//        for(Word word : words){
//            this.words.add(word);
//        }
//    }

    public List<Word> getWordsPage(int page, int pageSize){
//        return words.stream()
//                .sorted(Comparator.comparing(Word::getId))
//                .skip(page * pageSize)
//                .limit(pageSize)
//                .toList();
        String jpql = "SELECT word FROM Word word ORDER BY word.id";
        TypedQuery<Word> query = entityManager.createQuery(jpql, Word.class);
        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();

    }

    public Word getRandomWord(){
        Random random = new Random();
        int randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);
    }

    public Optional<Word> getWord(long id){
        return words.stream()
                .filter(i -> i.getId() == id)
                .findFirst();
    }

    public void addWord(@NonNull Word newWord) {
        if (getWord(newWord.getId()).isEmpty()) {
            words.add(newWord);
        }
    }
    public void deleteWord(int id){
        Iterator<Word> iterator = words.iterator();
        while (iterator.hasNext()) {
            Word word = iterator.next();
            if (word.getId() == id) {
                iterator.remove();
            }
        }
    }

    public class DictionarySearch {
        public List<Word> searchWords(String basicForm, boolean registerCheck){
            if(!registerCheck)
                basicForm = basicForm.toLowerCase();
            List<Word> foundWords = new ArrayList<>();
            for(Word word : words){
                if((registerCheck ? word.getBasicForm() : word.getBasicForm().toLowerCase()).equals(basicForm)){
                    foundWords.add(word);
                }
            }
            return foundWords;
        }

        public List<Word> searchWordsIgnoreMorphology(String basicForm, boolean registerCheck){
            if(!registerCheck)
                basicForm = basicForm.toLowerCase();
            List<Word> foundWords = new ArrayList<>();
            for(Word word : words){
                if((registerCheck ? word.getBasicForm() : word.getBasicForm().toLowerCase()).equals(basicForm)){
                    foundWords.add(word);
                }else {
                    for(String form : word.getOtherForms().getForms()){
                        if((registerCheck ? form : form.toLowerCase()).equals(basicForm)){
                            foundWords.add(word);
                        }
                    }
                }
            }
            return foundWords;
        }

        public List<Word> searchBySynonyms(String basicForm, boolean registerCheck){
            if(!registerCheck)
                basicForm = basicForm.toLowerCase();
            List<Word> foundWords = new ArrayList<>();
            for(Word word : words){
                if((registerCheck ? word.getBasicForm() : word.getBasicForm().toLowerCase()).equals(basicForm)){
                    foundWords.add(word);
                }else {
                    for(String form : word.getOtherForms().getForms()){
                        if((registerCheck ? form : form.toLowerCase()).equals(basicForm)){
                            foundWords.add(word);
                        }
                    }
                }
            }
            return foundWords;
        }

        public List<Word> searchByDefinitionText(String definitionText) {
            List<Word> foundWords = new ArrayList<>();
            for(Word word : words){
                for (Definition definition : word.getDefinitions()){
                    if(definition.getDefinitionText() == definitionText)
                        foundWords.add(word);
                }
            }
            return foundWords;
        }
    }

    public class DictionaryStatistic{
        public int getQuantityWords(){
            return words.size();
        }

        public int getQuantityDefinition(){
            int quantity = 0;
            for (Word word : words){
                quantity += word.getDefinitions().size();
            }
            return quantity;
        }

        public int getQuantitySynonyms(){
            int quantity = 0;
            for (Word word : words){
                for(Definition definition : word.getDefinitions()) {
                    quantity += definition.getSynonyms().size();
                }
            }
            return quantity;
        }
    }
}
