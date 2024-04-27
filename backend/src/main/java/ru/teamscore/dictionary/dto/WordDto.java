package ru.teamscore.dictionary.dto;

import lombok.Data;

import java.util.List;

@Data
public class WordDto {
    private long idWord;
    private String basicForm;
    private List<DefinitionDto> definitionsDto;
    private List<OtherFormDto> otherFormsDto;
}
