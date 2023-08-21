package com.example.java.service;

import com.example.java.dao.ParticipantRepository;
import com.example.java.domain.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository pr;

    public List<Participant> findAllParticipant() {
        return pr.findAllParticipant();
    }

    public Participant findById(int id) {
        return pr.findById(id);
    }

    public void save(Participant participant) {
       pr.save(participant);
    }

    public void delete(int id){
        pr.delete(id);
    }
}
