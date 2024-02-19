package com.mademo.pusher1;

import com.mademo.pusher1.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EtudiantDao extends JpaRepository<Etudiant, Integer> {
    @Query(name = "do_querry", nativeQuery = true)
    List<EtudiantDto> findQuerry(@Param("querry") String querry);
}
