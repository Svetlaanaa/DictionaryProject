package ru.teamscore.dictionary.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.teamscore.dictionary.enums.SpeechPart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
@Entity
@Table(name = "definition", schema = "definitions")
@NamedQuery(name = "definitionsCount", query = "select count(*) from Definition")
@NamedQuery(name = "definitionById", query = "from Definition d where d.id = :id")
public class Definition {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "word_id")
    private Word word;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "speech_part", length = 100)
    private SpeechPart speechPart;

    @Column(name = "definition_text", nullable = false)
    @Getter
    @Setter
    private String definitionText;

    @Column(name = "usage_example")
    @Getter
    @Setter
    private String usageExample;

    @ElementCollection
    @CollectionTable(name = "source", schema = "definitions", joinColumns = @JoinColumn(name = "definition_id"))
    @Column(name = "source")
    @Getter
    private final List<String> sources = new ArrayList<>();


    public Definition(int id, String definitionText, SpeechPart speechPart){
        this.id = id;
        this.definitionText = definitionText;
        this.speechPart = speechPart;
    }

    public Definition(int id, String definitionText, SpeechPart speechPart, Word synonym){
        this.id = id;
        this.definitionText = definitionText;
        this.speechPart = speechPart;
    }
}
