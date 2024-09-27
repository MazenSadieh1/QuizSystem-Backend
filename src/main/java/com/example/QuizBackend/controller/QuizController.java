package com.example.QuizBackend.controller;

import com.example.QuizBackend.dto.QuizDTO;
import com.example.QuizBackend.entities.Quiz;
import com.example.QuizBackend.services.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "api/v1")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/quizzes")
    public List<QuizDTO> getQuizzes() {
        return quizService.getQuiz();
    }

    @GetMapping("/quiz/{id}")
    public QuizDTO getQuiz(@PathVariable Long id) {
        return quizService.getQuiz(id);
    }

    @GetMapping("/quizzes/title")
    public boolean checkIfTitleExists(@RequestParam String title) { return quizService.checkIfTitleExists(title); }

    @PostMapping("/quiz")
    public QuizDTO createQuiz(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    @PutMapping("/quiz/{id}")
    public QuizDTO updateQuiz(@PathVariable Long id, @RequestBody Quiz quiz) {
        return quizService.updateQuiz(id, quiz);
    }

    @DeleteMapping("/quiz/{id}")
    public void deleteQuiz(@PathVariable Long id) { quizService.deleteQuiz(id);}
}
