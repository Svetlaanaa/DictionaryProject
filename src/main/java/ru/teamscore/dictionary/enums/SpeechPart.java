package ru.teamscore.dictionary.enums;

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
