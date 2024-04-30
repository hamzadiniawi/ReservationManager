package dao;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Etablissements")
public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_etablissement;
    private String nom;
    private String type; // hôtel, restaurant, salle de sport, etc.
    private String adresse;
    private String description;
    private String contact;
    private String autres_informations;
	public int getId_etablissement() {
		return id_etablissement;
	}
	public void setId_etablissement(int id_etablissement) {
		this.id_etablissement = id_etablissement;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAutres_informations() {
		return autres_informations;
	}
	public void setAutres_informations(String autres_informations) {
		this.autres_informations = autres_informations;
	}
	@Override
	public int hashCode() {
		return Objects.hash(adresse, autres_informations, contact, description, id_etablissement, nom, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etablissement other = (Etablissement) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(autres_informations, other.autres_informations)
				&& Objects.equals(contact, other.contact) && Objects.equals(description, other.description)
				&& id_etablissement == other.id_etablissement && Objects.equals(nom, other.nom)
				&& Objects.equals(type, other.type);
	}
	@Override
	public String toString() {
		return "Etablissement [id_etablissement=" + id_etablissement + ", nom=" + nom + ", type=" + type + ", adresse="
				+ adresse + ", description=" + description + ", contact=" + contact + ", autres_informations="
				+ autres_informations + "]";
	}
	public Etablissement(int id_etablissement, String nom, String type, String adresse, String description,
			String contact, String autres_informations) {
		super();
		this.id_etablissement = id_etablissement;
		this.nom = nom;
		this.type = type;
		this.adresse = adresse;
		this.description = description;
		this.contact = contact;
		this.autres_informations = autres_informations;
	}
	public Etablissement() {
		super();
	}
    
	
    
}
