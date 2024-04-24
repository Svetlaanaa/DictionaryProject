package ru.teamscore.dictionary.converters;

import ru.teamscore.dictionary.dto.DefinitionDto;
import ru.teamscore.dictionary.dto.OtherFormDto;
import ru.teamscore.dictionary.dto.WordDto;
import ru.teamscore.dictionary.model.entities.Definition;
import ru.teamscore.dictionary.model.entities.OtherForm;
import ru.teamscore.dictionary.model.entities.Word;

import java.util.ArrayList;
import java.util.List;

public class ConverterWord {
    private ConverterDefinition converterDefinition;
    private ConverterOtherForm converterOtherForm;

    public Word fromDto(WordDto wordDto){
        Word word = new Word();
        word.setBasicForm(wordDto.getBasicForm());
        word.setDefinitions(getDefinitionList(wordDto.getDefinitionsDto()));//dto -> entity
        word.setOtherForms(getOtherForms(wordDto.getOtherFormsDto())); //dto -> entity
        return word;
    }

    public WordDto toDto(Word word){
        WordDto wordDto = new WordDto();
        wordDto.setBasicForm(word.getBasicForm());
        wordDto.setDefinitionsDto(setDefinitionList(word.getDefinitions()));
        wordDto.setOtherFormsDto(setOtherForms(word.getOtherForms()));
        return wordDto;
    }

    public List<Definition> getDefinitionList(List<DefinitionDto> definitionsDto){
        List<Definition> definitions = new ArrayList<>();
        for(DefinitionDto definitionDto : definitionsDto){
            definitions.add(converterDefinition.fromDto(definitionDto));
        }
        return definitions;
    }

    public List<OtherForm> getOtherForms(List<OtherFormDto> otherFormsDto){
        List<OtherForm> otherForms = new ArrayList<>();
        for(OtherFormDto otherFormDto : otherFormsDto){
            otherForms.add(converterOtherForm.fromDto(otherFormDto));
        }
        return otherForms;
    }
    public List<DefinitionDto> setDefinitionList(List<Definition> definitions){
        List<DefinitionDto> definitionsDto = new ArrayList<>();
        for(Definition definition : definitions){
            definitionsDto.add(converterDefinition.toDto(definition));
        }
        return definitionsDto;
    }

    public List<OtherFormDto> setOtherForms(List<OtherForm> otherForms){
        List<OtherFormDto> otherFormsDto = new ArrayList<>();
        for(OtherForm otherForm : otherForms){
            otherFormsDto.add(converterOtherForm.toDto(otherForm));
        }
        return otherFormsDto;
    }
}
