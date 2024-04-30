package service;

import dao.Utilisateur;
import java.util.List;

public interface IGestionUtilisateur {
    void ajouterUtilisateur(Utilisateur utilisateur);
    void modifierUtilisateur(int idUtilisateur, Utilisateur nouveauUtilisateur);
    void supprimerUtilisateur(int idUtilisateur);
    Utilisateur chercherParId(int idUtilisateur);
    List<Utilisateur> lister();
}
