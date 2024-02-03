package ru.teamscore.dictionaty;

import lombok.Getter;
import lombok.Setter;
import ru.teamscore.dictionaty.enums.SpeechPart;

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
}
