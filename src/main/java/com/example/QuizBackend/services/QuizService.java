package com.example.QuizBackend.services;

import com.example.QuizBackend.Mapper.Mapper;
import com.example.QuizBackend.dto.QuizDTO;
import com.example.QuizBackend.entities.Quiz;
import com.example.QuizBackend.repositories.QuizRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuizService {

    private QuizRepository quizRepository;

    public QuizDTO getQuiz(Long id){
        Quiz quiz = quizRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No quiz found with id: " + id));
        return Mapper.toQuizDTO(quiz);
    }

    public List<QuizDTO> getQuiz() {
        return quizRepository.findAll().stream().map(Mapper::toQuizDTO).toList();
    }

    public boolean checkIfTitleExists(String title) {
        return quizRepository.existsByTitle(title);
    }

    public QuizDTO createQuiz(Quiz quiz) {
        quiz.getQuestions().forEach(q -> {
            q.setQuiz(quiz);
            q.getAnswers().forEach(a  -> a.setQuestion(q));});
        quizRepository.save(quiz);
        return Mapper.toQuizDTO(quiz);
    }

    public QuizDTO updateQuiz(Long id, Quiz quiz) {
        Quiz quizToUpdate = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No quiz found with id: " + id));
        quizToUpdate.setSubject(quiz.getSubject());
        quizToUpdate.setCreator(quiz.getCreator());
        quizToUpdate.setTitle(quiz.getTitle());
        quizRepository.save(quizToUpdate);
        return Mapper.toQuizDTO(quizToUpdate);
    }

    public void deleteQuiz(Long id) {
        Quiz quizToDelete = quizRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No quiz found with id: " + id));
        quizRepository.delete(quizToDelete);
    }
}
