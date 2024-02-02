package ru.teamscore.dictionaty;

import lombok.Getter;

public class Word {
    private int id;
    @Getter
    private String basicForm;
    private OtherForms otherForms;
    private WordDefinition definitions;
}
