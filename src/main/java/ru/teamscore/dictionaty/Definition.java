package ru.teamscore.dictionaty;

import lombok.Getter;
import lombok.Setter;
import ru.teamscore.dictionaty.enums.SpeechPart;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Definition {
    @Getter
    private int id;
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

    public Definition(String definitionText, SpeechPart speechPart){
        this.definitionText = definitionText;
        this.speechPart = speechPart;
    }

    public Definition(String definitionText, SpeechPart speechPart, Word synonym){
        this.definitionText = definitionText;
        this.speechPart = speechPart;
        this.synonyms.add(synonym);
    }

    public boolean isUrl(String source){
        String regex = "^(http(s)?://)?[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        return matcher.matches();
    }

    public void addSynonym(Word word){
        this.synonyms.add(word);
    }

    public void deleteSynonym(String basicForm){
        for (Word synonym : this.synonyms) {
            if(synonym.getBasicForm() == basicForm){
                this.synonyms.remove(synonym);
            }
        }
    }

    public void deleteUsageExample(){
        this.usageExample = null;
    }

    public void deleteSource(String source){
        this.sources.remove(source);
    }
}
