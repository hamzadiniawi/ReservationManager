package service;

import dao.Paiement;
import java.util.List;

public interface IGestionPaiement {
    void ajouterPaiement(Paiement paiement);
    void modifierPaiement(int idPaiement, Paiement nouveauPaiement);
    void supprimerPaiement(int idPaiement);
    Paiement chercherParId(int idPaiement);
    List<Paiement> lister();
}
