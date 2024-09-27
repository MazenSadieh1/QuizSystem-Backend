package com.example.QuizBackend.services;

import com.example.QuizBackend.Mapper.Mapper;
import com.example.QuizBackend.dto.AnswerDTO;
import com.example.QuizBackend.entities.Answer;
import com.example.QuizBackend.repositories.AnswerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class AnswerService {

    private AnswerRepository answerRepository;

    public AnswerDTO getAnswer(Long id){
        Answer answer = answerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No answer found with id: " + id)
        );
        return Mapper.toAnswerDTO(answer);
    }

    public List<AnswerDTO> getAnswers() {
        List<AnswerDTO> answers = answerRepository.findAll().stream().map(Mapper::toAnswerDTO).toList();
        return answers;
    }

    public AnswerDTO createAnswer(Answer answer) {
        answerRepository.save(answer);
        return Mapper.toAnswerDTO(answer);
    }

    public AnswerDTO updateAnswer(Long id, Answer answer) {
        Answer answerToUpdate = answerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No answer found with id: " + id)
        );
        answerToUpdate.setCorrect(answer.isCorrect());
        answerToUpdate.setText(answer.getText());
        answerToUpdate.setPoints(answer.getPoints());
        answerRepository.save(answerToUpdate);
        return Mapper.toAnswerDTO(answerToUpdate);
    }

    public void deleteAnswer(Long id) {
        Answer answerToDelete = answerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No answer found with id: " + id)
        );
        answerRepository.delete(answerToDelete);
    }
}
