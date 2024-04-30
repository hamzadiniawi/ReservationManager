package service;

import dao.ConfirmationRappel;
import java.util.List;

public interface IGestionConfirmationRappel {
    void ajouterConfirmationRappel(ConfirmationRappel confirmationRappel);
    void modifierConfirmationRappel(int idConfirmationRappel, ConfirmationRappel nouvelleConfirmationRappel);
    void supprimerConfirmationRappel(int idConfirmationRappel);
    ConfirmationRappel chercherParId(int idConfirmationRappel);
    List<ConfirmationRappel> lister();
}
