package com.codequest.backend.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data@Entity
public class TestCaseResult {
    private String input;
    private String expectedOutput;
    private String actualOutput;
    private boolean passed;

    public TestCaseResult(String input, String expectedOutput, String actualOutput, boolean passed) {
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.actualOutput = actualOutput;
        this.passed = passed;
    }

    // Getters and setters
}
