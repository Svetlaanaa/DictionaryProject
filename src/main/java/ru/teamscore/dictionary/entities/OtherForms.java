package ru.teamscore.dictionary.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
public class OtherForms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ElementCollection
    private List<String> forms = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "word_id")
    private Word word;

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
