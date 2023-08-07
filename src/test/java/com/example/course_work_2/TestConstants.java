package com.example.course_work_2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TestConstants {
    public static final Question Question_1 = new Question("q1", "a1");
    public static final Question Question_2 = new Question("q2", "a2");
    public static final Question Question_3 = new Question("q3", "a3");
    public static final Question Question_4 = new Question("q4", "a4");
    public static final Question Question_5 = new Question("q5", "a5");


    public static final Question NOT_FOUND_QUESTION = new Question("NOT_FOUND", "NOT_FOUND");

    public static final Collection<Question> MOCK_QUESTIONS = Set.of(
            Question_1,
            Question_2,
            Question_3,
            Question_4
    );

}
