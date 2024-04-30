package dao;

import java.time.LocalDateTime;
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
@Table(name = "ConfirmationRappels")
public class ConfirmationRappel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_confirmation_rappel;
    @ManyToOne
    private Reservation reservation;
    private String type; // confirmation, rappel
    private LocalDateTime date_envoi;
    private String statut; // envoyé, reçu, etc.
	public int getId_confirmation_rappel() {
		return id_confirmation_rappel;
	}
	public void setId_confirmation_rappel(int id_confirmation_rappel) {
		this.id_confirmation_rappel = id_confirmation_rappel;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDateTime getDate_envoi() {
		return date_envoi;
	}
	public void setDate_envoi(LocalDateTime date_envoi) {
		this.date_envoi = date_envoi;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	@Override
	public int hashCode() {
		return Objects.hash(date_envoi, id_confirmation_rappel, reservation, statut, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConfirmationRappel other = (ConfirmationRappel) obj;
		return Objects.equals(date_envoi, other.date_envoi) && id_confirmation_rappel == other.id_confirmation_rappel
				&& Objects.equals(reservation, other.reservation) && Objects.equals(statut, other.statut)
				&& Objects.equals(type, other.type);
	}
	@Override
	public String toString() {
		return "ConfirmationRappel [id_confirmation_rappel=" + id_confirmation_rappel + ", reservation=" + reservation
				+ ", type=" + type + ", date_envoi=" + date_envoi + ", statut=" + statut + "]";
	}
	public ConfirmationRappel(int id_confirmation_rappel, Reservation reservation, String type,
			LocalDateTime date_envoi, String statut) {
		super();
		this.id_confirmation_rappel = id_confirmation_rappel;
		this.reservation = reservation;
		this.type = type;
		this.date_envoi = date_envoi;
		this.statut = statut;
	}
	public ConfirmationRappel() {
		super();
	}
	
	
    
    
}
