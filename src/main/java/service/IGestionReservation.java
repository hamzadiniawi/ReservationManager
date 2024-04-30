package service;

import dao.Reservation;
import java.util.List;

public interface IGestionReservation {
    void ajouterReservation(Reservation reservation);
    void modifierReservation(int idReservation, Reservation nouvelleReservation);
    void supprimerReservation(int idReservation);
    Reservation chercherParId(int idReservation);
    List<Reservation> lister();
}
