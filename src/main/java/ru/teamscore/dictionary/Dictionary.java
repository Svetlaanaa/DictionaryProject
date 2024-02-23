package ru.teamscore.dictionary;

import ru.teamscore.dictionary.enums.SpeechPart;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private List<Word> words = new ArrayList<>();

    private final DictionarySearch search = new DictionarySearch();

    public List<Word> getWords(int page, int pageSize){
        return words.stream()
                .sorted(Comparator.comparing(Word::getBasicForm))
                .skip(page * pageSize)
                .limit(pageSize)
                .toList();
    }

    public Word getRandomWord(){
        Random random = new Random();
        int randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);
    }

    public void addWord(String basicForm, String definitionText, SpeechPart speechPart){
        words.add(new Word(basicForm, new Definition(definitionText, speechPart)));
    }

    public void deleteWord(int id){
        for(Word word : words){
            if(word.getId() == id){
                words.remove(word);
            }
        }
    }

    public class DictionarySearch {
        public List<Word> searchWords(String basicForm, boolean registerCheck){
            if(registerCheck)
                basicForm = basicForm.toLowerCase();
            List<Word> foundWords = new ArrayList<>();
            for(Word word : words){
                if((registerCheck ? word.getBasicForm() : word.getBasicForm().toLowerCase()) == basicForm){
                    foundWords.add(word);
                }
            }
            return foundWords;
        }

        public List<Word> searchWordsIgnoreMorphology(String basicForm, boolean registerCheck){
            if(registerCheck)
                basicForm = basicForm.toLowerCase();
            List<Word> foundWords = new ArrayList<>();
            for(Word word : words){
                if((registerCheck ? word.getBasicForm() : word.getBasicForm().toLowerCase()) == basicForm){
                    foundWords.add(word);
                }else {
                    for(String form : word.getOtherForms()){
                        if((registerCheck ? form : form.toLowerCase()) == basicForm){
                            foundWords.add(word);
                        }
                    }
                }
            }
            return foundWords;
        }

        public List<Word> searchBySynonyms(String basicForm, boolean registerCheck){
            if(registerCheck)
                basicForm = basicForm.toLowerCase();
            List<Word> foundWords = new ArrayList<>();
            for(Word word : words){
                if((registerCheck ? word.getBasicForm() : word.getBasicForm().toLowerCase()) == basicForm){
                    foundWords.add(word);
                }else {
                    for(String form : word.getOtherForms()){
                        if((registerCheck ? form : form.toLowerCase()) == basicForm){
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
                for (Definition definition : word.getDefinition()){
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
                quantity += word.getDefinition().size();
            }
            return quantity;
        }

        public int getQuantitySynonyms(){
            int quantity = 0;
            for (Word word : words){
                for(Definition definition : word.getDefinition()) {
                    quantity += definition.getSynonyms().size();
                }
            }
            return quantity;
        }
    }
}
