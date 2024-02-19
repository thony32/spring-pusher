package com.mademo.pusher1.controller;

import com.mademo.pusher1.EtudiantDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/etudiant")
public interface EtudiantApi {
    /*
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EtudiantDto> save(@RequestBody EtudiantDto etudiant, @RequestBody Map<String, Object> message);




    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<EtudiantDto>> findAll(@RequestBody Map<String, Object> message);


     */



    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<EtudiantDto>> findAll();



    /*
    @GetMapping(value = "/querry/{querry}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Map<String, EtudiantDto>>> findQuerry(@PathVariable("querry") String querry);

     */

    @GetMapping(value = "/querry/{querry}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<EtudiantDto>> findQuerry(@PathVariable("querry") String querry);

}
