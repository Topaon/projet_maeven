package sg.corporation.entrainement_WSR.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @ NoArgsConstructor
public class Champion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String role;
	
	// Constructeur
	public Champion(Integer id, String nom, String role) {
		super();
		this.id = id;
		this.nom = nom;
		this.role = role;
	}

	// ToString
	@Override
	public String toString() {
		return "Champion [id=" + id + ", nom=" + nom + ", role=" + role + "]";
	}	
}
