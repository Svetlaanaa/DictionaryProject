package ru.teamscore.dictionary.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SynonymDto {
    private long id;
    private WordDto synonym;
    private DefinitionDto definitionDto;
}
