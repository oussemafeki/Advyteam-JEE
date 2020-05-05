package tn.Advyteam.IServices;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.Advyteam.entities.DetailsTache;
import tn.Advyteam.entities.Taches;

@Remote
public interface IDetailsTacheRemoteService {

	int save(DetailsTache detailsTache);
	
	List<DetailsTache> getDetailsTacheByDate(Date date);
	
	DetailsTache getDetailTacheByDateAndTache(Date date, Taches tache);
	
	void update(DetailsTache newDetailTache);
}
