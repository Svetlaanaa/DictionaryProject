package ru.teamscore.dictionary.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor(staticName = "load")
@Entity
@Table(name = "word", schema = "words")
@NamedQuery(name = "wordsCount", query = "select count(*) from Word")
@NamedQuery(name = "wordById", query = "from Word w where w.id = :id")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Getter
    @Setter
    @Column(name = "basic_form", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String basicForm;

    @Getter
    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL)
    private final List<Definition> definitions = new ArrayList<>();

    @Getter
    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL)
    private final List<OtherForms> otherForms = new ArrayList<>();

    public Word(int id, String basicForm, Definition definition){
        this.id = id;
        this.basicForm = basicForm;
        definitions.add(definition);
    }

    public Word(int id, String basicForm, Definition definition, DictionaryManager dictionaryManager){
        this.id = id;
        this.basicForm = basicForm;
        definitions.add(definition);
    }
}
