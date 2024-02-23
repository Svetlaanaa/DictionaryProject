package ru.teamscore.dictionary;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Word {
    @Getter
    private int id;
    @Getter
    @Setter
    private String basicForm;
    private OtherForms otherForms;
    private WordDefinition definitions = new WordDefinition();

    public Word(String basicForm, Definition definition){
        this.basicForm = basicForm;
        definitions.addDefinition(definition);
    }

    public List<String> getOtherForms(){
        return otherForms.getForms();
    }

    public List<Definition> getDefinition(){
        return definitions.getDefinitions();
    }

    public class WordDefinition {
        @Getter
        private List<Definition> definitions = new ArrayList<>();

        public void deleteDefinition(int id){
            for(Definition definition : definitions){
                if(definition.getId() == id)
                    definitions.remove(definition);
            }
        }

        public void addDefinition(Definition definition){
            definitions.add(definition);
        }
    }
}
