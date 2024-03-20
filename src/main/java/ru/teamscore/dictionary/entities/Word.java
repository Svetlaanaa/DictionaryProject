package ru.teamscore.dictionary.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ru.teamscore.dictionary.DictionaryManager;
import ru.teamscore.dictionary.entities.Definition;
import ru.teamscore.dictionary.entities.OtherForms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "word", schema = "words")
@NamedQuery(name = "wordsCount", query = "select count(*) from Word")
public class Word {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column(name = "basic_form", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String basicForm;

    @Getter
    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL)
    private final List<Definition> definitions = new ArrayList<>();

    private DictionaryManager dictionaryManager;      //нужно ли поле?..

    public Word(int id, String basicForm, Definition definition){
        this.id = id;
        this.basicForm = basicForm;
        definitions.add(definition);
    }

    public Word(int id, String basicForm, Definition definition, DictionaryManager dictionaryManager){
        this.id = id;
        this.basicForm = basicForm;
        definitions.add(definition);
        this.dictionaryManager = dictionaryManager;
        //dictionaryManager.addWord(this);
    }

    public Definition getDefinition(int id) {
        for (Definition definition : definitions){
            if (definition.getId() == id){
                return definition;
            }
        }
        return null;
    }

    public void deleteDefinition(int id){
        Iterator<Definition> iterator = definitions.iterator();
        while (iterator.hasNext()) {
            Definition definition = iterator.next();
            if (definition.getId() == id) {
                iterator.remove();
            }
        }
    }

    public void addDefinition(Definition definition){
        for (Definition definition1 : definitions){
            if (definition1.getId() == definition.getId()){
                return;
            }
        }
        definitions.add(definition);
    }
}
