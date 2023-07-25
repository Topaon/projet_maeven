package sg.corporation.entrainement_WSR.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sg.corporation.entrainement_WSR.dao.DaoChampion;
import sg.corporation.entrainement_WSR.entity.Champion;

@RestController
@RequestMapping(path = "/api-champion/champion", headers = "Accept=application/json")
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST})
public class ChampionRestCtrl {
	
	@Autowired
	DaoChampion daoChampion;
	
	@GetMapping(value = "/all")
	public List<Champion> allChampion() {
		return daoChampion.getAll();
	}
}
