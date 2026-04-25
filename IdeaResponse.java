package com.Tracker.ideasTracker.ideas.dto;

import com.Tracker.ideasTracker.Status;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public class IdeaResponse {
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String problemStatement;
    private String potentialSolution;
    private Status status;
    private Instant createdAt;
    private Instant updatedAt;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

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

    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant created_at) {
        this.createdAt = created_at;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Instant updated_at) {
        this.updatedAt = updated_at;
    }
}
