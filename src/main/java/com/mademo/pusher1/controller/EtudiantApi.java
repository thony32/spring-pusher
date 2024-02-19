package com.mademo.pusher1.controller;

import com.mademo.pusher1.Etudiant;
import com.mademo.pusher1.EtudiantDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RequestMapping("/etudiant")
public interface EtudiantApi {
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EtudiantDto> save(@RequestBody EtudiantDto etudiant, @RequestBody Map<String, Object> message);

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<EtudiantDto>> findAll(@RequestBody Map<String, Object> message);

}
