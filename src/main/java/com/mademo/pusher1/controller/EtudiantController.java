package com.mademo.pusher1.controller;

import com.mademo.pusher1.EtudiantDto;
import com.mademo.pusher1.service.EtudiantService;
import com.pusher.rest.Pusher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class EtudiantController implements EtudiantApi {
    private EtudiantService etudiantService;
    // private Pusher pusher;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    /*
     * @Autowired
     * public EtudiantController(EtudiantService etudiantService, Pusher pusher) {
     * this.etudiantService = etudiantService;
     * this.pusher = pusher;
     * }
     * 
     */

    @Override
    public ResponseEntity<EtudiantDto> save(EtudiantDto etudiant) {
        // pusher.trigger("test-pusher","my-event",message);
        return ResponseEntity.ok(etudiantService.save(etudiant));
    }

    @Override
    public ResponseEntity<List<EtudiantDto>> findAll() {

        Pusher pusher = new Pusher("1758867", "67bf07e6e0cc1ee95176", "d00d10fc598efe372785");
        pusher.setCluster("ap2");

        pusher.trigger("test-pusher", "my-event", ("Event find all"));
        return ResponseEntity.ok(etudiantService.findAll());

    }

    /*
     * @Override
     * public ResponseEntity<List<EtudiantDto>> findAll(Map<String, Object> message)
     * {
     * pusher.trigger("","",message);
     * return ResponseEntity.ok(etudiantService.findAll());
     * }
     * 
     */

    @Override
    public ResponseEntity<List<EtudiantDto>> getQuery(String query) {
        List<EtudiantDto> groupedEtudiants = etudiantService.findQuery(query);

        if (!groupedEtudiants.isEmpty()) {
            return new ResponseEntity<>(groupedEtudiants, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
