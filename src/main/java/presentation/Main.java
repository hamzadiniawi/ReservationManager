package presentation;

import dao.Utilisateur;
import dao.Etablissement;
import dao.Disponibilite;
import dao.Reservation;
import dao.Paiement;
import dao.ConfirmationRappel;
import service.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.time.LocalTime;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    
    public static void main(String[] args) { 
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP_Reservation");
    	
        try {
            Scanner scanner = new Scanner(System.in);
            int choix;
            do {
                afficherMenu();
                System.out.print("Votre choix: ");
                choix = scanner.nextInt();
                switch (choix) {
                    case 1:
                        testerGestionUtilisateur(scanner);
                        break;
                    case 2:
                        testerGestionEtablissement(scanner);
                        break;
                    case 3:
                        testerGestionDisponibilite(scanner);
                        break;
                    case 4:
                        testerGestionReservation(scanner);
                        break;
                    case 5:
                        testerGestionPaiement(scanner);
                        break;
                    case 6:
                        testerGestionConfirmationRappel(scanner);
                        break;
                    case 0:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide !");
                        break;
                }
            } while (choix != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void afficherMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tester GestionUtilisateur");
        System.out.println("2. Tester GestionEtablissement");
        System.out.println("3. Tester GestionDisponibilite");
        System.out.println("4. Tester GestionReservation");
        System.out.println("5. Tester GestionPaiement");
        System.out.println("6. Tester GestionConfirmationRappel");
        System.out.println("0. Quitter");
    }
    
    private static void testerGestionUtilisateur(Scanner scanner) {
        IGestionUtilisateur gestionUtilisateur = new GestionUtilisateur();

        // Ajouter un utilisateur
        System.out.println("Ajouter un utilisateur:");
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("John");
        utilisateur.setPrenom("Doe");
        utilisateur.setAdresse_email("john.doe@example.com");
        utilisateur.setMot_de_passe("password");
        utilisateur.setType_utilisateur("client");
        gestionUtilisateur.ajouterUtilisateur(utilisateur);
        System.out.println("Utilisateur ajouté avec succès.");

        // Modifier un utilisateur
        System.out.println("Modifier un utilisateur:");
        System.out.print("Entrez l'ID de l'utilisateur à modifier: ");
        int idUtilisateur = scanner.nextInt();
        Utilisateur utilisateurModifie = gestionUtilisateur.chercherParId(idUtilisateur);
        if (utilisateurModifie != null) {
            System.out.println("Entrez les nouvelles informations:");
            System.out.print("Nom: ");
            utilisateurModifie.setNom(scanner.next());
            System.out.print("Prénom: ");
            utilisateurModifie.setPrenom(scanner.next());
            System.out.print("Adresse email: ");
            utilisateurModifie.setAdresse_email(scanner.next());
            System.out.print("Mot de passe: ");
            utilisateurModifie.setMot_de_passe(scanner.next());
            System.out.print("Type utilisateur: ");
            utilisateurModifie.setType_utilisateur(scanner.next());
            gestionUtilisateur.modifierUtilisateur(idUtilisateur, utilisateurModifie);
            System.out.println("Utilisateur modifié avec succès.");
        } else {
            System.out.println("Utilisateur non trouvé.");
        }

        // Supprimer un utilisateur
        System.out.println("Supprimer un utilisateur:");
        System.out.print("Entrez l'ID de l'utilisateur à supprimer: ");
        int idUtilisateurSupprimer = scanner.nextInt();
        gestionUtilisateur.supprimerUtilisateur(idUtilisateurSupprimer);
        System.out.println("Utilisateur supprimé avec succès.");

        // Afficher tous les utilisateurs
        System.out.println("Liste des utilisateurs:");
        List<Utilisateur> utilisateurs = gestionUtilisateur.lister();
        for (Utilisateur u : utilisateurs) {
            System.out.println(u);
        }
    }

    
    private static void testerGestionEtablissement(Scanner scanner) {
        IGestionEtablissement gestionEtablissement = new GestionEtablissement();

        // Ajouter un établissement
        System.out.println("Ajouter un établissement:");
        Etablissement etablissement = new Etablissement();
        etablissement.setNom("Hotel ABC");
        etablissement.setType("Hotel");
        etablissement.setAdresse("123 Rue de l'Établissement");
        etablissement.setDescription("Un bel hôtel avec vue sur la mer.");
        etablissement.setContact("contact@hotelabc.com");
        etablissement.setAutres_informations("Wi-Fi gratuit, piscine, restaurant.");
        gestionEtablissement.ajouterEtablissement(etablissement);
        System.out.println("Établissement ajouté avec succès.");

        // Modifier un établissement
        System.out.println("Modifier un établissement:");
        System.out.print("Entrez l'ID de l'établissement à modifier: ");
        int idEtablissement = scanner.nextInt();
        Etablissement etablissementModifie = gestionEtablissement.chercherParId(idEtablissement);
        if (etablissementModifie != null) {
            System.out.println("Entrez les nouvelles informations:");
            System.out.print("Nom: ");
            etablissementModifie.setNom(scanner.next());
            System.out.print("Type: ");
            etablissementModifie.setType(scanner.next());
            System.out.print("Adresse: ");
            etablissementModifie.setAdresse(scanner.next());
            System.out.print("Description: ");
            etablissementModifie.setDescription(scanner.next());
            System.out.print("Contact: ");
            etablissementModifie.setContact(scanner.next());
            System.out.print("Autres informations: ");
            etablissementModifie.setAutres_informations(scanner.next());
            gestionEtablissement.modifierEtablissement(idEtablissement, etablissementModifie);
            System.out.println("Établissement modifié avec succès.");
        } else {
            System.out.println("Établissement non trouvé.");
        }

        // Supprimer un établissement
        System.out.println("Supprimer un établissement:");
        System.out.print("Entrez l'ID de l'établissement à supprimer: ");
        int idEtablissementSupprimer = scanner.nextInt();
        gestionEtablissement.supprimerEtablissement(idEtablissementSupprimer);
        System.out.println("Établissement supprimé avec succès.");

        // Afficher tous les établissements
        System.out.println("Liste des établissements:");
        List<Etablissement> etablissements = gestionEtablissement.lister();
        for (Etablissement e : etablissements) {
            System.out.println(e);
        }
    }
 

    private static void testerGestionDisponibilite(Scanner scanner) {
        IGestionDisponibilite gestionDisponibilite = new GestionDisponibilite();

        // Ajouter une disponibilité
        System.out.println("Ajouter une disponibilité:");
        Disponibilite disponibilite = new Disponibilite();
        disponibilite.setEtablissement(new Etablissement()); // You need to set an Etablissement object
        disponibilite.setDate(LocalDate.now()); // Example current date
        disponibilite.setHeure_debut(LocalTime.of(9, 0)); // Example 09:00
        disponibilite.setHeure_fin(LocalTime.of(17, 0)); // Example 17:00
        disponibilite.setCapacite_disponible(50);
        gestionDisponibilite.ajouterDisponibilite(disponibilite);
        System.out.println("Disponibilité ajoutée avec succès.");

        // Modifier une disponibilité
        System.out.println("Modifier une disponibilité:");
        System.out.print("Entrez l'ID de la disponibilité à modifier: ");
        int idDisponibilite = scanner.nextInt();
        Disponibilite disponibiliteModifie = gestionDisponibilite.chercherParId(idDisponibilite);
        if (disponibiliteModifie != null) {
            System.out.println("Entrez les nouvelles informations:");
            System.out.print("Date (AAAA-MM-JJ): ");
            disponibiliteModifie.setDate(LocalDate.parse(scanner.next()));
            System.out.print("Heure de début (HH:MM): ");
            disponibiliteModifie.setHeure_debut(LocalTime.parse(scanner.next()));
            System.out.print("Heure de fin (HH:MM): ");
            disponibiliteModifie.setHeure_fin(LocalTime.parse(scanner.next()));
            System.out.print("Capacité disponible: ");
            disponibiliteModifie.setCapacite_disponible(scanner.nextInt());
            gestionDisponibilite.modifierDisponibilite(idDisponibilite, disponibiliteModifie);
            System.out.println("Disponibilité modifiée avec succès.");
        } else {
            System.out.println("Disponibilité non trouvée.");
        }

        // Supprimer une disponibilité
        System.out.println("Supprimer une disponibilité:");
        System.out.print("Entrez l'ID de la disponibilité à supprimer: ");
        int idDisponibiliteSupprimer = scanner.nextInt();
        gestionDisponibilite.supprimerDisponibilite(idDisponibiliteSupprimer);
        System.out.println("Disponibilité supprimée avec succès.");

        // Afficher toutes les disponibilités
        System.out.println("Liste des disponibilités:");
        List<Disponibilite> disponibilites = gestionDisponibilite.lister();
        for (Disponibilite d : disponibilites) {
            System.out.println(d);
        }
    }

    
    private static void testerGestionReservation(Scanner scanner) {
        IGestionReservation gestionReservation = new GestionReservation();

        // Ajouter une réservation
        System.out.println("Ajouter une réservation:");
        Reservation reservation = new Reservation();
        reservation.setUtilisateur(new Utilisateur()); // You need to set a Utilisateur object
        reservation.setDisponibilite(new Disponibilite()); // You need to set a Disponibilite object
        reservation.setDate_reservation(LocalDate.now()); // Example current date
        reservation.setEtat("confirmée");
        gestionReservation.ajouterReservation(reservation);
        System.out.println("Réservation ajoutée avec succès.");

        // Modifier une réservation
        System.out.println("Modifier une réservation:");
        System.out.print("Entrez l'ID de la réservation à modifier: ");
        int idReservation = scanner.nextInt();
        Reservation reservationModifie = gestionReservation.chercherParId(idReservation);
        if (reservationModifie != null) {
            System.out.println("Entrez les nouvelles informations:");
            System.out.print("ID de l'utilisateur: ");
            reservationModifie.getUtilisateur().setId_utilisateur(scanner.nextInt());
            System.out.print("ID de la disponibilité: ");
            reservationModifie.getDisponibilite().setId_disponibilite(scanner.nextInt());
            System.out.print("Date de réservation (AAAA-MM-JJ): ");
            reservationModifie.setDate_reservation(LocalDate.parse(scanner.next()));
            System.out.print("État de la réservation: ");
            reservationModifie.setEtat(scanner.next());
            gestionReservation.modifierReservation(idReservation, reservationModifie);
            System.out.println("Réservation modifiée avec succès.");
        } else {
            System.out.println("Réservation non trouvée.");
        }

        // Supprimer une réservation
        System.out.println("Supprimer une réservation:");
        System.out.print("Entrez l'ID de la réservation à supprimer: ");
        int idReservationSupprimer = scanner.nextInt();
        gestionReservation.supprimerReservation(idReservationSupprimer);
        System.out.println("Réservation supprimée avec succès.");

        // Afficher toutes les réservations
        System.out.println("Liste des réservations:");
        List<Reservation> reservations = gestionReservation.lister();
        for (Reservation r : reservations) {
            System.out.println(r);
        }
    }

    
    private static void testerGestionPaiement(Scanner scanner) {
        IGestionPaiement gestionPaiement = new GestionPaiement();

        // Ajouter un paiement
        System.out.println("Ajouter un paiement:");
        Paiement paiement = new Paiement();
        paiement.setReservation(new Reservation()); // You need to set a Reservation object
        paiement.setMontant(100.0); // Example amount
        paiement.setDate_paiement(LocalDate.now()); // Example current date
        paiement.setStatut("payé");
        gestionPaiement.ajouterPaiement(paiement);
        System.out.println("Paiement ajouté avec succès.");

        // Modifier un paiement
        System.out.println("Modifier un paiement:");
        System.out.print("Entrez l'ID du paiement à modifier: ");
        int idPaiement = scanner.nextInt();
        Paiement paiementModifie = gestionPaiement.chercherParId(idPaiement);
        if (paiementModifie != null) {
            System.out.println("Entrez les nouvelles informations:");
            System.out.print("ID de la réservation: ");
            paiementModifie.getReservation().setId_reservation(scanner.nextInt());
            System.out.print("Montant: ");
            paiementModifie.setMontant(scanner.nextDouble());
            System.out.print("Date de paiement (AAAA-MM-JJ): ");
            paiementModifie.setDate_paiement(LocalDate.parse(scanner.next()));
            System.out.print("Statut: ");
            paiementModifie.setStatut(scanner.next());
            gestionPaiement.modifierPaiement(idPaiement, paiementModifie);
            System.out.println("Paiement modifié avec succès.");
        } else {
            System.out.println("Paiement non trouvé.");
        }

        // Supprimer un paiement
        System.out.println("Supprimer un paiement:");
        System.out.print("Entrez l'ID du paiement à supprimer: ");
        int idPaiementSupprimer = scanner.nextInt();
        gestionPaiement.supprimerPaiement(idPaiementSupprimer);
        System.out.println("Paiement supprimé avec succès.");

        // Afficher tous les paiements
        System.out.println("Liste des paiements:");
        List<Paiement> paiements = gestionPaiement.lister();
        for (Paiement p : paiements) {
            System.out.println(p);
        }
    }

    
    private static void testerGestionConfirmationRappel(Scanner scanner) {
        IGestionConfirmationRappel gestionConfirmationRappel = new GestionConfirmationRappel();

        // Ajouter une confirmation/rappel
        System.out.println("Ajouter une confirmation/rappel:");
        ConfirmationRappel confirmationRappel = new ConfirmationRappel();
        confirmationRappel.setReservation(new Reservation()); // You need to set a Reservation object
        confirmationRappel.setType("confirmation");
        confirmationRappel.setDate_envoi(LocalDateTime.now()); // Example current date and time
        confirmationRappel.setStatut("envoyé");
        gestionConfirmationRappel.ajouterConfirmationRappel(confirmationRappel);
        System.out.println("Confirmation/Rappel ajouté avec succès.");

        // Modifier une confirmation/rappel
        System.out.println("Modifier une confirmation/rappel:");
        System.out.print("Entrez l'ID de la confirmation/rappel à modifier: ");
        int idConfirmationRappel = scanner.nextInt();
        ConfirmationRappel confirmationRappelModifie = gestionConfirmationRappel.chercherParId(idConfirmationRappel);
        if (confirmationRappelModifie != null) {
            System.out.println("Entrez les nouvelles informations:");
            System.out.print("ID de la réservation: ");
            confirmationRappelModifie.getReservation().setId_reservation(scanner.nextInt());
            System.out.print("Type (confirmation/rappel): ");
            confirmationRappelModifie.setType(scanner.next());
            System.out.print("Date d'envoi (AAAA-MM-JJ HH:MM:SS): ");
            confirmationRappelModifie.setDate_envoi(LocalDateTime.parse(scanner.next()));
            System.out.print("Statut: ");
            confirmationRappelModifie.setStatut(scanner.next());
            gestionConfirmationRappel.modifierConfirmationRappel(idConfirmationRappel, confirmationRappelModifie);
            System.out.println("Confirmation/Rappel modifié avec succès.");
        } else {
            System.out.println("Confirmation/Rappel non trouvé.");
        }

        // Supprimer une confirmation/rappel
        System.out.println("Supprimer une confirmation/rappel:");
        System.out.print("Entrez l'ID de la confirmation/rappel à supprimer: ");
        int idConfirmationRappelSupprimer = scanner.nextInt();
        gestionConfirmationRappel.supprimerConfirmationRappel(idConfirmationRappelSupprimer);
        System.out.println("Confirmation/Rappel supprimé avec succès.");

        // Afficher toutes les confirmations/rappels 
        System.out.println("Liste des confirmations/rappels:");
        List<ConfirmationRappel> confirmationRappels = gestionConfirmationRappel.lister();
        for (ConfirmationRappel cr : confirmationRappels) {
            System.out.println(cr);
        }
    }

    
    
}
