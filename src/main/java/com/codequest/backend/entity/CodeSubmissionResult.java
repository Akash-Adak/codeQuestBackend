package com.codequest.backend.entity;

import com.codequest.backend.entity.TestCaseResult;
import lombok.Data;

import java.util.List;
@Data
public class CodeSubmissionResult {
    private String status;
    private List<TestCaseResult> results;

    public CodeSubmissionResult(String status, List<TestCaseResult> results) {
        this.status = status;
        this.results = results;
    }

    // Getters and setters
}
