package com.conference.scheduler.controllers;

import com.conference.scheduler.entities.Speaker;
import com.conference.scheduler.repositories.SpeakerRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
    @Autowired
    private SpeakerRepo speakerRepo;

    @GetMapping
    public List<Speaker> list(){
        return speakerRepo.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return speakerRepo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker create(@RequestBody final Speaker speaker){
        return speakerRepo.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        speakerRepo.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){
        Speaker existingSpeaker = speakerRepo.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepo.saveAndFlush(existingSpeaker);
    }


}
