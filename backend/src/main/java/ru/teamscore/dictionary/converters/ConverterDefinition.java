package ru.teamscore.dictionary.converters;

import org.springframework.stereotype.Component;
import ru.teamscore.dictionary.dto.DefinitionDto;
import ru.teamscore.dictionary.model.entities.Definition;
import ru.teamscore.dictionary.model.enums.SpeechPart;

@Component
public class ConverterDefinition {
    public Definition fromDto(DefinitionDto definitionDto){
        Definition definition = new Definition();
        definition.setDefinitionText(definitionDto.getDefinitionText());
        definition.setSpeechPart(SpeechPart.valueOf(definitionDto.getSpeechPart())); //преобразовать к enum
        definition.setUsageExample(definitionDto.getUsageExample());
        definition.setSources(definition.getSources());
        return definition;
    }

    public DefinitionDto toDto(Definition definition){
        DefinitionDto definitionDto = new DefinitionDto();
        definitionDto.setDefinitionText(definition.getDefinitionText());
        definitionDto.setSpeechPart(definition.getSpeechPart() == null ? null :
                definition.getSpeechPart().toString());
        definitionDto.setUsageExample(definition.getUsageExample());
        definitionDto.setSources(definition.getSources());
        return definitionDto;
    }
}
