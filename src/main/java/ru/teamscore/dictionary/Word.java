package ru.teamscore.dictionary;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Word {
    @Getter
    private final int id;
    @Getter
    @Setter
    private String basicForm;
    @Getter
    private final OtherForms otherForms = new OtherForms();
    @Getter
    private final List<Definition> definitions = new ArrayList<>();

    private Dictionary dictionary;

    public Word(int id, String basicForm, Definition definition){
        this.id = id;
        this.basicForm = basicForm;
        definitions.add(definition);
    }

    public Word(int id, String basicForm, Definition definition, Dictionary dictionary){
        this.id = id;
        this.basicForm = basicForm;
        definitions.add(definition);
        this.dictionary = dictionary;
        dictionary.addWord(this);
    }

    public Definition getDefinition(int id) {
        for (Definition definition : definitions){
            if (definition.getId() == id){
                return definition;
            }
        }
        return null;
    }

    public void deleteDefinition(int id){
        Iterator<Definition> iterator = definitions.iterator();
        while (iterator.hasNext()) {
            Definition definition = iterator.next();
            if (definition.getId() == id) {
                iterator.remove();
            }
        }
    }

    public void addDefinition(Definition definition){
        for (Definition definition1 : definitions){
            if (definition1.getId() == definition.getId()){
                return;
            }
        }
        definitions.add(definition);
    }
}
