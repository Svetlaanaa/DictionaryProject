package ru.teamscore.dictionary;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class OtherForms {
    @Getter
    private List<String> forms = new ArrayList<>();

    public void addForm(String form){
        this.forms.add(form);
    }

    public void deleteForm(String form){
        this.forms.remove(form);
    }

    public void editForm(String form, String newForm){
        this.forms.remove(form);
        this.forms.add(newForm);
    }
}
