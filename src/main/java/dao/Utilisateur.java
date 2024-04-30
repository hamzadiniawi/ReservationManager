package dao;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_utilisateur;
    
    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;
    
    @Column(name = "adresse_email")
    private String adresse_email;
    
    @Column(name = "mot_de_passe")
    private String mot_de_passe;
    
    @Column(name = "type_utilisateur")
    private String type_utilisateur; // client, administrateur, etc.
    
    
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse_email() {
		return adresse_email;
	}
	public void setAdresse_email(String adresse_email) {
		this.adresse_email = adresse_email;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	public String getType_utilisateur() {
		return type_utilisateur;
	}
	public void setType_utilisateur(String type_utilisateur) {
		this.type_utilisateur = type_utilisateur;
	}
	@Override
	public int hashCode() {
		return Objects.hash(adresse_email, id_utilisateur, mot_de_passe, nom, prenom, type_utilisateur);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(adresse_email, other.adresse_email) && id_utilisateur == other.id_utilisateur
				&& Objects.equals(mot_de_passe, other.mot_de_passe) && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom) && Objects.equals(type_utilisateur, other.type_utilisateur);
	}
	@Override
	public String toString() {
		return "Utilisateur [id_utilisateur=" + id_utilisateur + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse_email=" + adresse_email + ", mot_de_passe=" + mot_de_passe + ", type_utilisateur="
				+ type_utilisateur + "]";
	}
	public Utilisateur(int id_utilisateur, String nom, String prenom, String adresse_email, String mot_de_passe,
			String type_utilisateur) {
		super();
		this.id_utilisateur = id_utilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse_email = adresse_email;
		this.mot_de_passe = mot_de_passe;
		this.type_utilisateur = type_utilisateur;
	}
	public Utilisateur() {
		super();
	}
	
	
	
    
    
}
