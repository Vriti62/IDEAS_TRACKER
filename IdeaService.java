package com.Tracker.ideasTracker.ideas.service;

import com.Tracker.ideasTracker.Status;
import com.Tracker.ideasTracker.ideas.dto.IdeaCreateRequest;
import com.Tracker.ideasTracker.ideas.dto.IdeaResponse;
import com.Tracker.ideasTracker.ideas.entity.Idea;
import com.Tracker.ideasTracker.ideas.mapper.IdeaMapper;
import com.Tracker.ideasTracker.ideas.repository.IdeaRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class IdeaService {
    private final IdeaRepository ideaRepository ;
    private IdeaMapper mapper;

    public IdeaService(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }

    public IdeaResponse createIdea(IdeaCreateRequest res){
        Idea idea = mapper.toEntity(res);
        idea.setTitle(res.getTitle());
        idea.setProblemStatement(res.getProblemStatement());
        idea.setPotentialSolution(res.getPotentialSolution());
        idea.setCreatedAt(Instant.now());
        idea.setStatus(Status.OPEN);
        idea.setUpdatedAt(Instant.now());
        Idea savedIdea = ideaRepository.save(idea);
        return mapper.toResponse(savedIdea);
    }


}
