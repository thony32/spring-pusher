package com.mademo.pusher1.service;

import com.mademo.pusher1.Etudiant;
import com.mademo.pusher1.EtudiantDto;

import java.util.List;

public interface EtudiantService {
    EtudiantDto save(EtudiantDto etudiantDto);

    List<EtudiantDto> findAll();
}
