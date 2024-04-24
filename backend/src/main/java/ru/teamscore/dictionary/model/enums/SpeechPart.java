package ru.teamscore.dictionary.model.enums;

public enum SpeechPart {
    NOUN("существительное"),
    ADJECTIVE("прилагательное"),
    VERB("глагол"),
    ADVERB("наречие");
    private final String speechPart;

    SpeechPart(String speechPart) {
        this.speechPart = speechPart;
    }
}