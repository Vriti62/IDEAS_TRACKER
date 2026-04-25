package com.Tracker.ideasTracker.ideas.repository;

import com.Tracker.ideasTracker.ideas.entity.Idea;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface IdeaRepository extends JpaRepository<Idea,Long>{

    }

