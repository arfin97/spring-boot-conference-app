package com.conference.scheduler.controllers;

import com.conference.scheduler.entities.Session;
import com.conference.scheduler.repositories.SessionRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionRepo sessionRepo;

    @GetMapping
    public List<Session> list(){
        return sessionRepo.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        System.out.println(id);
        return sessionRepo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //custom response number
    public Session create(@RequestBody final Session session){
        return sessionRepo.saveAndFlush(session); //object create = save, object commited to db = flush
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        sessionRepo.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT) //g: put vs patch
    public Session update(@PathVariable Long id, @RequestBody Session session){
        Session existingSession = sessionRepo.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id"); //ignore the session id
        return sessionRepo.saveAndFlush(existingSession);
    }

 }
