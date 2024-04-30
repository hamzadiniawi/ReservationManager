package service;

import dao.Etablissement;
import java.util.List;

public interface IGestionEtablissement {
    void ajouterEtablissement(Etablissement etablissement);
    void modifierEtablissement(int idEtablissement, Etablissement nouveauEtablissement);
    void supprimerEtablissement(int idEtablissement);
    Etablissement chercherParId(int idEtablissement);
    List<Etablissement> lister();
}
