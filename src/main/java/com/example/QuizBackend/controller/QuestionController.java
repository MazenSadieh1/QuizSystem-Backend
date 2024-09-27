package com.example.QuizBackend.controller;

import com.example.QuizBackend.dto.QuestionDTO;
import com.example.QuizBackend.entities.Question;
import com.example.QuizBackend.services.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "api/v1")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public List<QuestionDTO> getQuestions() {return questionService.getQuestion();}

    @GetMapping("/question/{id}")
    public QuestionDTO getQuestion(@PathVariable Long id) {
        return questionService.getQuestion(id);
    }

    @PostMapping("/question")
    public QuestionDTO createQuestion(@RequestBody Question question) {return questionService.createQuestion(question);}

    @PutMapping("/question/{id}")
    public QuestionDTO updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        return questionService.updateQuestion(id, question);
    }

    @DeleteMapping("/question/{id}")
    public void deleteQuestion(@PathVariable Long id) {
         questionService.deleteQuestion(id);
    }
}