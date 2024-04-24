package ru.teamscore.dictionary.dto;

import lombok.Data;

import java.util.List;

@Data
public class DefinitionDto {
    private String speechPart;
    private String definitionText;
    private String usageExample;
    private List<String> sources;
}
