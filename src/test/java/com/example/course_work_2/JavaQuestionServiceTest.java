package com.example.course_work_2;

import com.example.course_work_2.exception.QuestionNotFoundException;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static com.example.course_work_2.TestConstants.*;

class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    public void before() {
        questionService.add(Question_1);
        questionService.add(Question_2);
        questionService.add(Question_3);

    }

    @Test
    public void shouldAddQuestion() {
        int beforeAddCount = questionService.getAll().size();

        assertThat(questionService.add(Question_4))
                .isEqualTo(Question_4)
                .isIn(questionService.getAll());

        assertThat(questionService.getAll()).hasSize(beforeAddCount + 1);
    }

    @Test
    public void shouldRemoveQuestion() {
        int beforeRemoveCount = questionService.getAll().size();

        assertThat(questionService.remove(Question_1))
                .isEqualTo(Question_1)
                .isNotIn(questionService.getAll());

        assertThat(questionService.getAll()).hasSize(beforeRemoveCount - 1);
    }

    @Test
    public void shouldThrowQuestionNotFoundException() {
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> questionService.remove(NOT_FOUND_QUESTION));
    }

    @Test
    public void shouldReturnAllQuestions() {
        assertThat(questionService.getAll())
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        Question_1,
                        Question_2,
                        Question_3
                );
    }

    @Test
    public void shouldReturnRandomQuestion() {
        assertThat(questionService.getRandomQuestion())
                .isNotNull()
                .isIn(questionService.getAll());
    }

}