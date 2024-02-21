package com.mademo.pusher1.model;

import com.mademo.pusher1.EtudiantDto;
import jakarta.persistence.*;

@Entity
@NamedNativeQuery(
        name = "find_query",
        query = "SELECT * FROM etudiant WHERE nom = :query",
        resultClass = Etudiant.class
)
@SqlResultSetMapping(
        name = "query_mapping",
        classes = @ConstructorResult(
                targetClass = EtudiantDto.class,
                columns = {
                        @ColumnResult(name = "numero", type = Integer.class),
                }
        )
)
public class QueryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;
}
