package com.mademo.pusher1.controller;

import com.mademo.pusher1.EtudiantDto;
import com.mademo.pusher1.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class MappingController {
    private final MappingService service;

    @Autowired
    public MappingController(MappingService service) {
        this.service = service;
    }

    @PostMapping("/custom-query")
    public List<EtudiantDto> getResultQuery(@RequestParam String query){
        return service.doQuery(query);
    }

    @PostMapping("/custom-query-other")
    public String executeNonSelectQuery(@RequestParam String query){
        return service.otherQuery(query);
    }


    @PostMapping("/custom-query-combined")
    public Object executeCombinedQuery(@RequestParam String query){
        if (!query.contains(";")) {
            return "Attention : n'oubliez pas de mettre la virgule dans la requête.";
        }
        if (query.endsWith(";")) {
            query = query.substring(0, query.length() - 1);
        }

        if (isDoQueryRequest(query)) {
            return service.doQuery(query);
        } else {
            return service.otherQuery(query);
        }
    }


    private boolean isDoQueryRequest(String query) {
        Pattern pattern = Pattern.compile("\\b(SELECT)\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(query);
        return matcher.find();
    }
}
