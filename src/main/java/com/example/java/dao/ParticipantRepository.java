package com.example.java.dao;

import com.example.java.domain.Participant;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ParticipantRepository {
    private List<Participant> participants = new ArrayList<>();

    @PostConstruct
    public void init() {
        Participant p1 = new Participant();
        p1.setId(1);
        p1.setName("Ivan");
        p1.setEmail("Ivan@gmail.com");
        p1.setLevel("L2");
        p1.setPrimarySkill("Fast read");

        Participant p2 = new Participant();
        p2.setId(2);
        p2.setName("Goova");
        p2.setEmail("Goova@gmail.com");
        p2.setLevel("L1");
        p2.setPrimarySkill("Speed");

        Participant p3 = new Participant();
        p3.setId(3);
        p3.setName("Lajeo");
        p3.setEmail("Lajeo@gmail.com");
        p3.setLevel("L5");
        p3.setPrimarySkill("Dancing");

        Participant p4 = new Participant();
        p4.setId(4);
        p4.setName("Maks");
        p4.setEmail("Maks@gmail.com");
        p4.setLevel("L1");
        p4.setPrimarySkill("Fast read");

        Participant p5 = new Participant();
        p5.setId(5);
        p5.setName("Homos");
        p5.setEmail("Homos@gmail.com");
        p5.setLevel("L4");
        p5.setPrimarySkill("Swimming");

        participants.add(p1);
        participants.add(p2);
        participants.add(p3);
        participants.add(p4);
        participants.add(p5);

    }

    public List<Participant> findAllParticipant() {
        return participants;
    }

    public Participant findById(int id) {
        return participants.stream().filter(participant -> participant.getId() == id).findFirst().orElse(null);
    }

    public void save(Participant participant) {
        Participant up = null;
        if (participant.getId() != null) {
            up = findById(participant.getId());
            int pId = participants.indexOf(up);
            up.setName(participant.getName());
            up.setLevel(participant.getLevel());
            up.setName(participant.getEmail());
            up.setPrimarySkill(participant.getPrimarySkill());
            participants.set(pId, up);
        } else {
            participant.setId(participants.size() + 1);
            participants.add(participant);
        }
    }


    public void delete(int id){
        Iterator<Participant> i = participants.iterator();
        while (i.hasNext()){
            if (i.next().getId() == id){
                i.remove();
            }
        }
    }

}
