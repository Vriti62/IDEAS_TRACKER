package com.Tracker.ideasTracker.ideas.entity;

import com.Tracker.ideasTracker.Status;
import com.ethlo.time.DateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@Entity
@Table(name="ideas")
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String title;

    @Column(name ="problem_statement", nullable=false)
    private String problemStatement;

    @Column(name="problem_solution") //note for me: nullable== true by default
    private String potentialSolution;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false )
    private Status status;

    @Column(name ="created_at", nullable = false )
    private Instant createdAt;

    @Column(name ="updated_at" )
    private Instant updatedAt;

    //getters and setters
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
