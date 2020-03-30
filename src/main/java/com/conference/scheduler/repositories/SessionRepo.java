package com.conference.scheduler.repositories;

import com.conference.scheduler.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepo extends JpaRepository<Session, Long> {

}
