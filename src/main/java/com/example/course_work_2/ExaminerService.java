package com.example.course_work_2;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
