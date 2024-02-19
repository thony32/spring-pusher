package com.mademo.pusher1;

import com.mademo.pusher1.model.Etudiant;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EtudiantDto {
    private int numero;
    private String nom;
    private String adresse;
    private double bourse;

    public static EtudiantDto fromEntity(Etudiant etudiant) {
        if (etudiant == null) {
            return null;
        }
        return EtudiantDto.builder()
                .numero(etudiant.getNumero())
                .nom(etudiant.getNom())
                .adresse(etudiant.getAdresse())
                .bourse(etudiant.getBourse())
                .build();
    }

    public static Etudiant toEntity(EtudiantDto etudiantDto){
        if(etudiantDto == null){
            return null;
        }
        Etudiant etudiant = new Etudiant();
        etudiant.setNumero(etudiantDto.getNumero());
        etudiant.setNom(etudiantDto.getNom());
        etudiant.setAdresse(etudiantDto.getAdresse());
        etudiant.setBourse(etudiantDto.getBourse());

        return etudiant;
    }
}
