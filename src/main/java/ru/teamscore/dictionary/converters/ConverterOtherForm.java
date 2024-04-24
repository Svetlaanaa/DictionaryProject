package ru.teamscore.dictionary.converters;

import ru.teamscore.dictionary.dto.OtherFormDto;
import ru.teamscore.dictionary.dto.WordDto;
import ru.teamscore.dictionary.model.entities.OtherForm;
import ru.teamscore.dictionary.model.entities.Word;

public class ConverterOtherForm {
    public OtherForm fromDto(OtherFormDto otherFormDto){
        OtherForm otherForm = new OtherForm();
        otherForm.setForm(otherFormDto.getForm());
        return otherForm;
    }

    public OtherFormDto toDto(OtherForm otherForm){
        OtherFormDto otherFormDto = new OtherFormDto();
        otherFormDto.setForm(otherForm.getForm());
        return otherFormDto;
    }
}
