package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import dao.Utilisateur;

public class GestionUtilisateur implements IGestionUtilisateur {
    EntityManager em;

    public GestionUtilisateur() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_Reservation");
        em = emf.createEntityManager();
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(utilisateur);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public void modifierUtilisateur(int idUtilisateur, Utilisateur nouveauUtilisateur) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Utilisateur utilisateurAModifier = em.find(Utilisateur.class, idUtilisateur);
            if (utilisateurAModifier != null) {
                utilisateurAModifier.setNom(nouveauUtilisateur.getNom());
                utilisateurAModifier.setPrenom(nouveauUtilisateur.getPrenom());
                utilisateurAModifier.setAdresse_email(nouveauUtilisateur.getAdresse_email());
                utilisateurAModifier.setMot_de_passe(nouveauUtilisateur.getMot_de_passe());
                utilisateurAModifier.setType_utilisateur(nouveauUtilisateur.getType_utilisateur());
                em.merge(utilisateurAModifier);
                tr.commit();
            } else {
                System.out.println("L'utilisateur avec l'ID " + idUtilisateur + " n'existe pas.");
            }
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public void supprimerUtilisateur(int idUtilisateur) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            Utilisateur utilisateurASupprimer = em.find(Utilisateur.class, idUtilisateur);
            if (utilisateurASupprimer != null) {
                em.remove(utilisateurASupprimer);
                tr.commit();
            } else {
                System.out.println("L'utilisateur avec l'ID " + idUtilisateur + " n'existe pas.");
            }
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    public Utilisateur chercherParId(int idUtilisateur) {
        try {
            return em.find(Utilisateur.class, idUtilisateur);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Utilisateur> lister() {
        try {
            Query query = em.createQuery("SELECT u FROM Utilisateur u");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
