package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import dao.Disponibilite;

public class GestionDisponibilite implements IGestionDisponibilite{
    EntityManager em;

    public GestionDisponibilite() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_Reservation");
        em = emf.createEntityManager();
    }

    public void ajouterDisponibilite(Disponibilite disponibilite) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(disponibilite);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public void modifierDisponibilite(int idDisponibilite, Disponibilite nouvelleDisponibilite) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Disponibilite disponibiliteAModifier = em.find(Disponibilite.class, idDisponibilite);
            if (disponibiliteAModifier != null) {
                disponibiliteAModifier.setDate(nouvelleDisponibilite.getDate());
                disponibiliteAModifier.setHeure_debut(nouvelleDisponibilite.getHeure_debut());
                disponibiliteAModifier.setHeure_fin(nouvelleDisponibilite.getHeure_fin());
                disponibiliteAModifier.setCapacite_disponible(nouvelleDisponibilite.getCapacite_disponible());
                em.merge(disponibiliteAModifier);
                tr.commit();
            } else {
                System.out.println("La disponibilité avec l'ID " + idDisponibilite + " n'existe pas.");
            }
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public void supprimerDisponibilite(int idDisponibilite) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Disponibilite disponibiliteASupprimer = em.find(Disponibilite.class, idDisponibilite);
            if (disponibiliteASupprimer != null) {
                em.remove(disponibiliteASupprimer);
                tr.commit();
            } else {
                System.out.println("La disponibilité avec l'ID " + idDisponibilite + " n'existe pas.");
            }
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public Disponibilite chercherParId(int idDisponibilite) {
        try {
            return em.find(Disponibilite.class, idDisponibilite);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Disponibilite> lister() {
        try {
            Query query = em.createQuery("SELECT d FROM Disponibilite d");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
