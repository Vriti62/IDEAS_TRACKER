package com.Tracker.ideasTracker.ideas.dto;

import com.Tracker.ideasTracker.Status;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;


public class IdeaCreateRequest {

    @NotNull
    private String title;
    @NotNull
    private String problemStatement;
    private String potentialSolution;

    //getters and setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getProblemStatement() {
        return problemStatement;
    }
    public void setProblemStatement(String problem_statement) {
        this.problemStatement = problem_statement;
    }

    public String getPotentialSolution() {
        return potentialSolution;
    }
    public void setPotentialSolution(String potential_solution) {
        this.potentialSolution = potential_solution;
    }

}