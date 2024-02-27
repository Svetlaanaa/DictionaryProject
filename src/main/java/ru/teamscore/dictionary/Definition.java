package ru.teamscore.dictionary;

import lombok.Getter;
import lombok.Setter;
import ru.teamscore.dictionary.enums.SpeechPart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Definition {
    @Getter
    private final int id;
    @Getter
    @Setter
    private SpeechPart speechPart;
    @Getter
    @Setter
    private String definitionText;
    @Getter
    @Setter
    private String usageExample;
    @Getter
    private List<String> sources = new ArrayList<>();
    @Getter
    private List<Word> synonyms = new ArrayList<>();

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
        String regex = "^(http|https)://([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}(:\\d{1,5})?(/[\\w-./?%&=]*)?$";;
        Pattern pattern = Pattern.compile(regex);
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
