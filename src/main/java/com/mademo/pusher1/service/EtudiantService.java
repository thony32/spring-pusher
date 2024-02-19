package com.mademo.pusher1.service;

import com.mademo.pusher1.EtudiantDto;

import java.util.List;
import java.util.Map;

public interface EtudiantService {
    /*
    EtudiantDto save(EtudiantDto etudiantDto);

     */

    List<EtudiantDto> findAll();



    List<EtudiantDto> findQuerry(String querry);

}
