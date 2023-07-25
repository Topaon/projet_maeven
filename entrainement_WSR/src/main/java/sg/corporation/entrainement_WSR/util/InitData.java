package sg.corporation.entrainement_WSR.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sg.corporation.entrainement_WSR.dao.DaoChampion;
import sg.corporation.entrainement_WSR.entity.Champion;

@Component
public class InitData {
	
	@Autowired
	DaoChampion daoChampion;
	
	@PostConstruct
	public void init() {
		daoChampion.addChampion(new Champion(null, "Ekko", "Assassin"));
		daoChampion.addChampion(new Champion(null, "Jinx", "ADC"));
		daoChampion.addChampion(new Champion(null, "Twitch", "ADC"));
		daoChampion.addChampion(new Champion(null, "Shaco", "Assassin"));
		daoChampion.addChampion(new Champion(null, "Sion", "Tank"));
		daoChampion.addChampion(new Champion(null, "Zyra", "Mage"));
	}
}
