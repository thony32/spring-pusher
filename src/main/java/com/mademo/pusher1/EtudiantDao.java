package com.mademo.pusher1;

import com.mademo.pusher1.model.Etudiant;
import com.mademo.pusher1.model.MappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface EtudiantDao extends JpaRepository<Etudiant, Integer> {
    @Query(name = "do_querry", nativeQuery = true)
    List<EtudiantDto>findQuerry(@Param("querry") String querry);
}



/*
@Repository
public interface EtudiantDao extends JpaRepository<MappingEntity, Integer> {
    @Query(name = "do_querry", nativeQuery = true)
    List<EtudiantDto> findQuerry(@Param("querry") String querry);
}

 */

