package dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Paiements")
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_paiement;
    @ManyToOne
    private Reservation reservation;
    private double montant;
    private LocalDate date_paiement;
    private String statut; // en attente, payé, remboursé, etc.
	public int getId_paiement() {
		return id_paiement;
	}
	public void setId_paiement(int id_paiement) {
		this.id_paiement = id_paiement;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double d) {
		this.montant = d;
	}
	public LocalDate getDate_paiement() {
		return date_paiement;
	}
	public void setDate_paiement(LocalDate date_paiement) {
		this.date_paiement = date_paiement;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	@Override
	public int hashCode() {
		return Objects.hash(date_paiement, id_paiement, montant, reservation, statut);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paiement other = (Paiement) obj;
		return Objects.equals(date_paiement, other.date_paiement) && id_paiement == other.id_paiement
				&& Objects.equals(montant, other.montant) && Objects.equals(reservation, other.reservation)
				&& Objects.equals(statut, other.statut);
	}
	@Override
	public String toString() {
		return "Paiement [id_paiement=" + id_paiement + ", reservation=" + reservation + ", montant=" + montant
				+ ", date_paiement=" + date_paiement + ", statut=" + statut + "]";
	}
	public Paiement(int id_paiement, Reservation reservation, double montant, LocalDate date_paiement,
			String statut) {
		super();
		this.id_paiement = id_paiement;
		this.reservation = reservation;
		this.montant = montant;
		this.date_paiement = date_paiement;
		this.statut = statut;
	}
	public Paiement() {
		super();
	}
    
    
    
}
