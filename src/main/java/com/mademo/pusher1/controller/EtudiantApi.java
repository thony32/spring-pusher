package com.mademo.pusher1.controller;

import com.mademo.pusher1.EtudiantDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/etudiant")
public interface EtudiantApi {

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EtudiantDto> save(@RequestBody EtudiantDto etudiant);

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<EtudiantDto>> findAll();

    @GetMapping(value = "/find-by-query/{query}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<EtudiantDto>> getQuery(@PathVariable("query") String query);

}
