package sg.corporation.ygo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class Carte {
	private Long id;
	private String nom;
	
	@Override
	public String toString() {
		return "Carte [id=" + id + ", nom=" + nom + "]";
	}	
}
