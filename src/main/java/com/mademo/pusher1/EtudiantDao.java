package com.mademo.pusher1;

import com.mademo.pusher1.model.Etudiant;
import com.mademo.pusher1.model.MappingEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface EtudiantDao extends JpaRepository<Etudiant, Integer> {
    /*
    @Query(name = "find_query", nativeQuery = true)
    List<Etudiant> findQuery(@Param("query") String query);

     */

    @Query(value = ":query", nativeQuery = true)
    List<Etudiant> findQuery(@Param("query") String query);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO etudiant (nom, adresse, bourse) VALUES (:nom, :adresse, :bourse)", nativeQuery = true)
    void insertEtudiant(@Param("nom") String nom,
                        @Param("adresse") String adresse,
                        @Param("bourse") double bourse);
}






