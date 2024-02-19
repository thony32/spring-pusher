package com.mademo.pusher1.controller;

import com.mademo.pusher1.Etudiant;
import com.mademo.pusher1.EtudiantDto;
import com.mademo.pusher1.service.EtudiantService;
import com.pusher.rest.Pusher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class EtudiantController implements EtudiantApi {
    private EtudiantService etudiantService;
    private Pusher pusher;

    @Autowired
    public EtudiantController(EtudiantService etudiantService, Pusher pusher) {
        this.etudiantService = etudiantService;
        this.pusher = pusher;
    }

    @Override
    public ResponseEntity<EtudiantDto> save(EtudiantDto etudiant, Map<String, Object> message) {
        pusher.trigger("test-pusher","my-event",message);
        return ResponseEntity.ok(etudiantService.save(etudiant));
    }

    @Override
    public ResponseEntity<List<EtudiantDto>> findAll(Map<String, Object> message) {
        pusher.trigger("","",message);
        return ResponseEntity.ok(etudiantService.findAll());
    }
}
