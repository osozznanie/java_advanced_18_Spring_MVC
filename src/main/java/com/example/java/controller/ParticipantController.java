package com.example.java.controller;

import com.example.java.domain.Participant;
import com.example.java.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ParticipantController {

    @Autowired
    private ParticipantService ps;

    @GetMapping("/")
    public String init(HttpServletRequest req){
        req.setAttribute("participants" , ps.findAllParticipant());
        req.setAttribute("mode", "PARTICIPANTS_VIEW");
        return "index";
    }

    @GetMapping("/new")
    public String newParticipant(HttpServletRequest req){
        req.setAttribute("mode", "PARTICIPANTS_CREATE");
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Participant p, HttpServletRequest req) {
        ps.save(p);
        req.setAttribute("participants", ps.findAllParticipant());
        req.setAttribute("mode", "PARTICIPANTS_VIEW");
        return "index";
    }

    @GetMapping("/update")
    public String update(@RequestParam int id, HttpServletRequest req) {
        req.setAttribute("participants", ps.findById(id));
        req.setAttribute("mode", "PARTICIPANTS_EDIT");
        return "index";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam(required = false) Integer id, HttpServletRequest request) {
        if (id != null) {
            ps.delete(id);
            request.setAttribute("participants", ps.findAllParticipant());
            request.setAttribute("mode", "PARTICIPANTS_VIEW");
        } else {
            request.setAttribute("errorMessage", "Participant ID is missing");
        }

        return "index";
    }
}

