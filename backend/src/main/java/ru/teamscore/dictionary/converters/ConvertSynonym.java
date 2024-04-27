package ru.teamscore.dictionary.converters;

import org.springframework.beans.factory.annotation.Autowired;
import ru.teamscore.dictionary.dto.SynonymDto;
import ru.teamscore.dictionary.dto.WordDto;
import ru.teamscore.dictionary.model.entities.Synonym;
import ru.teamscore.dictionary.model.entities.Word;

public class ConvertSynonym {
    @Autowired
    private ConverterDefinition converterDefinition;
    @Autowired
    private ConverterWord converterWord;

    public Synonym fromDto(SynonymDto synonymDto){
        Synonym synonym = new Synonym();
        synonym.setSynonymWord(converterWord.fromDto(synonymDto.getSynonym()));
        synonym.setDefinition(converterDefinition.fromDto(synonymDto.getDefinitionDto()));
        return synonym;
    }

    public SynonymDto toDto(Synonym synonym){
        SynonymDto synonymDto = new SynonymDto();
        synonymDto.setSynonym(converterWord.toDto(synonym.getSynonymWord()));
        synonymDto.setDefinitionDto(converterDefinition.toDto(synonym.getDefinition()));
        return synonymDto;
    }
}
