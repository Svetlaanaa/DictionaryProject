package ru.teamscore.dictionaty;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class WordDefinition {
    @Getter
    private List<Definition> definitions = new ArrayList<>();
    public WordDefinition(List<Definition> definitions){
        for(Definition definition : definitions){
            this.definitions.add(definition);
        }
    }

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
