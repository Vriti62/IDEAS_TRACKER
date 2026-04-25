package com.Tracker.ideasTracker.ideas.mapper;

import com.Tracker.ideasTracker.ideas.dto.IdeaCreateRequest;
import com.Tracker.ideasTracker.ideas.dto.IdeaResponse;
import com.Tracker.ideasTracker.ideas.entity.Idea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface IdeaMapper {

    @Mapping(target="id", ignore=true)
    @Mapping(target="status", ignore = true)
    @Mapping(target="createdAt", ignore=true)
    @Mapping(target="updatedAt", ignore=true)
    Idea toEntity(IdeaCreateRequest req);

    IdeaResponse toResponse(Idea idea);

}

