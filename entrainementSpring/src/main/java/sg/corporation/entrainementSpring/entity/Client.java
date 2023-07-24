package sg.corporation.entrainementSpring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Client.getAllClients", query="SELECT c FROM Client c LEFT JOIN FETCH c.commandes")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String email;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "commanditaire")
	private List<Commande> commandes;
	
	// Constructeurs
	public Client() {
		super();
	}
	public Client(Integer id, String nom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.commandes = new ArrayList<Commande>();
	}
	
	// Getters Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	// toString()
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", email=" + email + "]";
	}	
}