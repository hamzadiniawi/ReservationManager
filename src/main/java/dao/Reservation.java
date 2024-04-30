package dao;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reservation;
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private Disponibilite disponibilite;
    private LocalDate date_reservation;
    private String etat; // confirmée, en attente, annulée, etc.
	public int getId_reservation() {
		return id_reservation;
	}
	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Disponibilite getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(Disponibilite disponibilite) {
		this.disponibilite = disponibilite;
	}
	public LocalDate getDate_reservation() {
		return date_reservation;
	}
	public void setDate_reservation(LocalDate date_reservation) {
		this.date_reservation = date_reservation;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	@Override
	public int hashCode() {
		return Objects.hash(date_reservation, disponibilite, etat, id_reservation, utilisateur);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(date_reservation, other.date_reservation)
				&& Objects.equals(disponibilite, other.disponibilite) && Objects.equals(etat, other.etat)
				&& id_reservation == other.id_reservation && Objects.equals(utilisateur, other.utilisateur);
	}
	@Override
	public String toString() {
		return "Reservation [id_reservation=" + id_reservation + ", utilisateur=" + utilisateur + ", disponibilite="
				+ disponibilite + ", date_reservation=" + date_reservation + ", etat=" + etat + "]";
	}
	public Reservation(int id_reservation, Utilisateur utilisateur, Disponibilite disponibilite,
			LocalDate date_reservation, String etat) {
		super();
		this.id_reservation = id_reservation;
		this.utilisateur = utilisateur;
		this.disponibilite = disponibilite;
		this.date_reservation = date_reservation;
		this.etat = etat;
	}
	public Reservation() {
		super();
	}
	
	
    
    
}
