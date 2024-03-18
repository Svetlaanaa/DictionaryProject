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
public class Definition {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "word_id")
    @Getter
    private long wordId;
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private SpeechPart speechPart;
    @Column(name = "definition_text")
    @Getter
    @Setter
    private String definitionText;
    @Column(name = "usage_example")
    @Getter
    @Setter
    private String usageExample;
    @ElementCollection
    @CollectionTable(name = "source", joinColumns = @JoinColumn(name = "definition_id"))
    @Column(name = "source")
    @Getter
    private final List<String> sources = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "synonym",
            joinColumns = @JoinColumn(name = "definition_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    @Getter
    private final List<Word> synonyms = new ArrayList<>();
    private final static Pattern pattern = Pattern.compile(
            "^(http|https)://([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}(:\\d{1,5})?(/[\\w-./?%&=]*)?$");

    public Definition(int id, String definitionText, SpeechPart speechPart){
        this.id = id;
        this.definitionText = definitionText;
        this.speechPart = speechPart;
    }

    public Definition(int id, String definitionText, SpeechPart speechPart, Word synonym){
        this.id = id;
        this.definitionText = definitionText;
        this.speechPart = speechPart;
        this.synonyms.add(synonym);
    }

    public static boolean isUrl(String source){
        Matcher matcher = pattern.matcher(source);
        return matcher.matches();
    }

    public void addSynonym(Word word){
        this.synonyms.add(word);
    }

    public void deleteSynonym(String basicForm) {
        Iterator<Word> iterator = this.synonyms.iterator();
        while (iterator.hasNext()) {
            Word synonym = iterator.next();
            if (synonym.getBasicForm().equals(basicForm)) {
                iterator.remove();
            }
        }
    }

    public void deleteUsageExample(){
        this.usageExample = null;
    }

    public void addSource(String source){
        if(isUrl(source)){
            this.sources.add(source);
        }
    }

    public void deleteSource(String source){
        this.sources.remove(source);
    }
}
