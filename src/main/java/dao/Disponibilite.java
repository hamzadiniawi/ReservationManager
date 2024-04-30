package dao;

import java.time.LocalDate;
import java.time.LocalTime;
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
@Table(name = "Disponibilites")
public class Disponibilite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_disponibilite;
    @ManyToOne
    private Etablissement etablissement;
    private LocalDate date;
    private LocalTime heure_debut;
    private LocalTime heure_fin;
    private int capacite_disponible;
	public int getId_disponibilite() {
		return id_disponibilite;
	}
	public void setId_disponibilite(int id_disponibilite) {
		this.id_disponibilite = id_disponibilite;
	}
	public Etablissement getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getHeure_debut() {
		return heure_debut;
	}
	public void setHeure_debut(LocalTime heure_debut) {
		this.heure_debut = heure_debut;
	}
	public LocalTime getHeure_fin() {
		return heure_fin;
	}
	public void setHeure_fin(LocalTime heure_fin) {
		this.heure_fin = heure_fin;
	}
	public int getCapacite_disponible() {
		return capacite_disponible;
	}
	public void setCapacite_disponible(int capacite_disponible) {
		this.capacite_disponible = capacite_disponible;
	}
	@Override
	public int hashCode() {
		return Objects.hash(capacite_disponible, date, etablissement, heure_debut, heure_fin, id_disponibilite);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disponibilite other = (Disponibilite) obj;
		return capacite_disponible == other.capacite_disponible && Objects.equals(date, other.date)
				&& Objects.equals(etablissement, other.etablissement) && Objects.equals(heure_debut, other.heure_debut)
				&& Objects.equals(heure_fin, other.heure_fin) && id_disponibilite == other.id_disponibilite;
	}
	@Override
	public String toString() {
		return "Disponibilite [id_disponibilite=" + id_disponibilite + ", etablissement=" + etablissement + ", date="
				+ date + ", heure_debut=" + heure_debut + ", heure_fin=" + heure_fin + ", capacite_disponible="
				+ capacite_disponible + "]";
	}
	public Disponibilite(int id_disponibilite, Etablissement etablissement, LocalDate date, LocalTime heure_debut,
			LocalTime heure_fin, int capacite_disponible) {
		super();
		this.id_disponibilite = id_disponibilite;
		this.etablissement = etablissement;
		this.date = date;
		this.heure_debut = heure_debut;
		this.heure_fin = heure_fin;
		this.capacite_disponible = capacite_disponible;
	}
	public Disponibilite() {
		super();
	}
	
	
    
    
}
