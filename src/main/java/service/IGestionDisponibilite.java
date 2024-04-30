package service;

import dao.Disponibilite;
import java.util.List;

public interface IGestionDisponibilite {
    void ajouterDisponibilite(Disponibilite disponibilite);
    void modifierDisponibilite(int idDisponibilite, Disponibilite nouvelleDisponibilite);
    void supprimerDisponibilite(int idDisponibilite);
    Disponibilite chercherParId(int idDisponibilite);
    List<Disponibilite> lister();
}
