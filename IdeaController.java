package com.Tracker.ideasTracker.ideas.controller;

import com.Tracker.ideasTracker.ideas.dto.IdeaCreateRequest;
import com.Tracker.ideasTracker.ideas.dto.IdeaResponse;
import com.Tracker.ideasTracker.ideas.service.IdeaService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ideas")
public class IdeaController {

    private final IdeaService ideaService;

    public IdeaController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IdeaResponse createIdea(@Valid @RequestBody IdeaCreateRequest request) {
        return ideaService.createIdea(request);
    }
}