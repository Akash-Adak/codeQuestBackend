package com.codequest.backend.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class TestCase {
    private String input;
    private String expectedOutput;

    public TestCase() {}
    public TestCase(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    // Getters and setters
}
