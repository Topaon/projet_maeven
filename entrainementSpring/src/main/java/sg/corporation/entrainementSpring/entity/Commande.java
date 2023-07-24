package sg.corporation.entrainementSpring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String label;
	
	@ManyToOne
	@JoinColumn(name="client_ayant_passe_la_commande")
	private Client commanditaire;
	
	
	public Commande() {
		super();
	}
	public Commande(Integer id, String label, Client commanditaire) {
		super();
		this.id = id;
		this.label = label;
		this.commanditaire = commanditaire;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Client getCommanditaire() {
		return commanditaire;
	}
	public void setCommanditaire(Client commanditaire) {
		this.commanditaire = commanditaire;
	}


	@Override
	public String toString() {
		return "Commande [id=" + id + ", label=" + label + "]";
	}
}
