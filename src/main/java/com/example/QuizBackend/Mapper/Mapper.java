package com.example.QuizBackend.Mapper;

import com.example.QuizBackend.dto.AnswerDTO;
import com.example.QuizBackend.dto.QuestionDTO;
import com.example.QuizBackend.dto.QuizDTO;
import com.example.QuizBackend.entities.Answer;
import com.example.QuizBackend.entities.Question;
import com.example.QuizBackend.entities.Quiz;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Mapper {

    public static QuizDTO toQuizDTO(Quiz quiz){
        QuizDTO quizDTO = new QuizDTO();
        BeanUtils.copyProperties(quiz, quizDTO, "questions");
        Set<QuestionDTO> questionsDTO  = quiz.getQuestions().stream().map(Mapper::toQuestionDTO).collect(Collectors.toSet());
        quizDTO.setQuestions(questionsDTO);
        quizDTO.setPoints(quiz.getTotalPoints());
        return quizDTO;
    }

    public static QuestionDTO toQuestionDTO(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO, "answers");
        Set<AnswerDTO> answersDTO = question.getAnswers().stream().map(Mapper::toAnswerDTO).collect(Collectors.toSet());
        questionDTO.setAnswers(answersDTO);
        questionDTO.setPoints(question.getTotalPoints());
        return questionDTO;
    }

    public static AnswerDTO toAnswerDTO(Answer answer){
        AnswerDTO answerDTO = new AnswerDTO();
        BeanUtils.copyProperties(answer, answerDTO);
        return answerDTO;
    }

}
