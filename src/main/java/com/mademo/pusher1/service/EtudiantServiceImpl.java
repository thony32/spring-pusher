package com.mademo.pusher1.service;

import com.mademo.pusher1.EtudiantDao;
import com.mademo.pusher1.EtudiantDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class EtudiantServiceImpl implements EtudiantService{
    private EtudiantDao etudiantDao;

    @Autowired
    public EtudiantServiceImpl(EtudiantDao etudiantDao) {
        this.etudiantDao = etudiantDao;
    }

    /*
    @Override
    public EtudiantDto save(EtudiantDto etudiantDto) {
        return EtudiantDto.fromEntity
                (etudiantDao.save
                        (EtudiantDto.toEntity(etudiantDto)
                        )
                );
    }

     */

    @Override
    public List<EtudiantDto> findAll() {
        return etudiantDao.findAll().stream()
                .map(EtudiantDto::fromEntity)
                .collect(Collectors.toList());
    }



    @Override
    public List<EtudiantDto> findQuerry(String querry) {
        log.info(querry);
        return etudiantDao.findQuerry(querry);
    }



}
