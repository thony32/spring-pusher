package com.mademo.pusher1.model;

import com.mademo.pusher1.EtudiantDto;
import jakarta.persistence.*;

/*
@Entity
@NamedNativeQuery(
        name = "do_querry",
        query = ":querry",
        resultSetMapping = "querry_mapping"
)
@SqlResultSetMapping(
        name = "querry_mapping",
        classes = @ConstructorResult(
                targetClass = EtudiantDto.class,
                columns = {
                        @ColumnResult(name = "numero", type = Integer.class),
                        @ColumnResult(name = "nom", type = String.class),
                        @ColumnResult(name = "adresse", type = String.class),
                        @ColumnResult(name = "bourse", type = Double.class)
                }
        )
)
public class MappingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;
}

 */

@Entity
@NamedNativeQuery(
        name = "do_querry",
        query = ":querry",
        resultClass = Etudiant.class
)
@SqlResultSetMapping(
        name = "querry_mapping",
        classes = @ConstructorResult(
                targetClass = EtudiantDto.class,
                columns = {
                        @ColumnResult(name = "numero", type = Integer.class),
                }
        )
)
public class MappingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;
}


