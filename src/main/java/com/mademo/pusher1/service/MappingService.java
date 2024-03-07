package com.mademo.pusher1.service;

import com.mademo.pusher1.EtudiantDto;
import com.pusher.rest.Pusher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;

import java.util.List;

@Service
public class MappingService {
    private final EntityManager entityManager;

    @Autowired
    public MappingService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<EtudiantDto> doQuery(String queryString) {
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    @Transactional
    public String otherQuery(String queryString) {
        try {
            Query query = entityManager.createNativeQuery(queryString);
            String queryType = queryString.split(" ")[0];
            switch (queryType) {
                case "DELETE":
                    Pusher pusher = new Pusher("1758867", "67bf07e6e0cc1ee95176", "d00d10fc598efe372785");
                    pusher.setCluster("ap2");
                    pusher.trigger("test-pusher", "my-event", ("delete"));
                    break;

                case "INSERT":
                    Pusher pusher1 = new Pusher("1758867", "67bf07e6e0cc1ee95176", "d00d10fc598efe372785");
                    pusher1.setCluster("ap2");
                    pusher1.trigger("test-pusher", "my-event", ("insert"));
                    break;

                case "UPDATE":
                    Pusher pusher2 = new Pusher("1758867", "67bf07e6e0cc1ee95176", "d00d10fc598efe372785");
                    pusher2.setCluster("ap2");
                    pusher2.trigger("test-pusher", "my-event", ("update"));
                    break;

                case "SELECT":
                    Pusher pusher3 = new Pusher("1758867", "67bf07e6e0cc1ee95176", "d00d10fc598efe372785");
                    pusher3.setCluster("ap2");
                    pusher3.trigger("test-pusher", "my-event", ("select"));
                    break;

                default:
                    break;
            }

            int rowsAffected = query.executeUpdate();

            if (rowsAffected > 0) {
                return "Requête exécutée avec succès. Nombre de lignes affectées : " + queryType;
            } else {
                return "Aucune ligne affectée par la requête : " + queryString;
            }
        } catch (UnexpectedRollbackException rollbackException) {
            rollbackException.printStackTrace();
            return "Echec de la tentative : La transaction a été annulée de manière inattendue.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Echec de la tentative : " + e.getMessage();
        }
    }

}
