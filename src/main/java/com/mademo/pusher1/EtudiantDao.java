package com.mademo.pusher1;

import com.mademo.pusher1.model.Etudiant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.HashMap;

import java.util.List;

public interface EtudiantDao extends JpaRepository<Etudiant, Integer> {

    // Requête native
    @Query(value = ":query", nativeQuery = true)
    List<Etudiant> findQuery(@Param("query") String query);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO etudiant (nom, adresse, bourse) VALUES (:nom, :adresse, :bourse)", nativeQuery = true)
    void insertEtudiant(@Param("nom") String nom,
            @Param("adresse") String adresse,
            @Param("bourse") double bourse);
}
