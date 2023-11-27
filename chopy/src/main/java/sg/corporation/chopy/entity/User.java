package sg.corporation.chopy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter @Setter @NoArgsConstructor
@Slf4j
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String planning;
	
	// Constructor
	public User(String username) {
		log.info("Constructeur de la classe User");
		this.username = username;
		this.planning = "";
	}
}