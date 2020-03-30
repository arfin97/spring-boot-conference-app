package com.conference.scheduler.repositories;

import com.conference.scheduler.entities.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepo extends JpaRepository<Speaker, Long> {
}
