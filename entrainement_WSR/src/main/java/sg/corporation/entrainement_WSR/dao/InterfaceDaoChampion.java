package sg.corporation.entrainement_WSR.dao;

import java.util.List;

import sg.corporation.entrainement_WSR.entity.Champion;

public interface InterfaceDaoChampion {
	List<Champion> getAll();
	Champion getById(Integer id);
	Champion addChampion(Champion c);
	void updateChampion(Champion c);
	void deleteChampionById(Integer id);
}
