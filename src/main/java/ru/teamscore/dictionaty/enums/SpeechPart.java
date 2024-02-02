package ru.teamscore.dictionaty.enums;

public enum SpeechPart {
    NOUN("существительное"),
    ADJECTIVE("прилагательное"),
    VERB("глагол"),
    ADVERB("наречие");
    private final String title;

    SpeechPart(String title) {
        this.title = title;
    }
}
