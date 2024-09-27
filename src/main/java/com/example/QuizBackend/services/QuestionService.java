package com.example.QuizBackend.services;

import com.example.QuizBackend.Mapper.Mapper;
import com.example.QuizBackend.dto.QuestionDTO;
import com.example.QuizBackend.entities.Question;
import com.example.QuizBackend.repositories.QuestionRepository;
import com.example.QuizBackend.repositories.QuizRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionDTO getQuestion(Long id) {
        Question question = questionRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No question found with id: " + id)
        );
        return Mapper.toQuestionDTO(question);
    }

    public List<QuestionDTO> getQuestion() {
        return questionRepository.findAll().stream().map(Mapper::toQuestionDTO).toList();
    }

    public QuestionDTO createQuestion(Question question) {
        question.getAnswers().forEach(a -> a.setQuestion(question));
        questionRepository.save(question);
        return Mapper.toQuestionDTO(question);
    }

    public QuestionDTO updateQuestion(Long id, Question question) {

        Question questionToUpdate = questionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No question found with id: " + id)
        );
        questionToUpdate.setText(question.getText());
        questionRepository.save(questionToUpdate);
        return Mapper.toQuestionDTO(questionToUpdate);
    }

    public void deleteQuestion(Long id) {
        Question questionToDelete = questionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No question found with id: " + id)
        );
        questionRepository.delete(questionToDelete);
    }
}
