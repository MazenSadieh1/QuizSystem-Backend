package com.example.QuizBackend.controller;

import com.example.QuizBackend.dto.AnswerDTO;
import com.example.QuizBackend.entities.Answer;
import com.example.QuizBackend.services.AnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "api/v1")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/answers")
    public List<AnswerDTO> getAnswers() {
        return answerService.getAnswers();
    }

    @GetMapping("/answer/{id}")
    public AnswerDTO getAnswer(@PathVariable Long id) {
        return answerService.getAnswer(id);
    }

    @PostMapping("/answer")
    public AnswerDTO createAnswer(@RequestBody Answer answer) {
        return answerService.createAnswer(answer);
    }

    @PutMapping("/answer/{id}")
    public AnswerDTO updateAnswer(@PathVariable Long id, @RequestBody Answer answer) {
        return answerService.updateAnswer(id, answer);
    }

    @DeleteMapping("/answer/{id}")
    public void deleteAnswer(@PathVariable Long id) {
         answerService.deleteAnswer(id);
    }
}