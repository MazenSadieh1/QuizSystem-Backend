package com.example.QuizBackend.enums;

import lombok.Getter;

@Getter
public enum QuestionType {

        MULTIPLE_CHOICE("Multiple Choice"),
        TRUE_FALSE("True or False"),
        FILL_IN_THE_BLANK("Fill in the Blank");

        private final String name;

        QuestionType(String name) {
                this.name = name;
        }

}
