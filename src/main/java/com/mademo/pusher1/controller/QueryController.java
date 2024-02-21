package com.mademo.pusher1.controller;

import com.mademo.pusher1.EtudiantDao;
import com.mademo.pusher1.InsertionRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/query")
public class QueryController {
    private EtudiantDao dao;

    @Autowired
    public QueryController(EtudiantDao dao) {
        this.dao = dao;
    }

    @PostMapping("/insertLigne")
    public ResponseEntity<String> insertLigne(@RequestBody InsertionRequest request) {
        try {
            dao.insertEtudiant(
                    request.getNom(),
                    request.getAdresse(),
                    request.getBourse()
            );
            return ResponseEntity.ok("Insertion réussie");
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.toString());
        }
    }
}
