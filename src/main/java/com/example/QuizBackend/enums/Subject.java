package com.example.QuizBackend.enums;

import lombok.Getter;

@Getter
public enum Subject {

    MATHEMATICS("Mathematics"),
    BIOLOGY("Biology"),
    HISTORY("History"),
    PHYSICS("Physics"),
    CHEMISTRY("Chemistry"),
    COMPUTER_SCIENCE("Computer Science"),
    GEOGRAPHY("Geography"),
    ART("Art"),
    MUSIC("Music"),
    PHYSICAL_EDUCATION("Physical Education"),
    LITERATURE("Literature"),
    PHILOSOPHY("Philosophy"),
    PSYCHOLOGY("Psychology"),
    SOCIOLOGY("Sociology"),
    ECONOMICS("Economics"),
    POLITICAL_SCIENCE("Political Science"),
    ASTRONOMY("Astronomy"),
    ETHICS("Ethics"),
    RELIGION("Religion"),
    FOREIGN_LANGUAGES("Foreign Languages"),
    ENVIRONMENTAL_SCIENCE("Environmental Science"),
    ANTHROPOLOGY("Anthropology"),
    ARCHAEOLOGY("Archaeology"),
    EDUCATION("Education"),
    LAW("Law");

    private final String name;

    Subject(String name) {
        this.name = name;
    }

}
