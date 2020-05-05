package tn.Advyteam.IServices;

import java.util.List;

import tn.Advyteam.entities.Critere;
import tn.Advyteam.entities.Selfeval;

public interface ICritereService {
	public int ajouterCritere(Critere critere);
	public List<Critere> getAllCriteres();
	public List<Critere> getAllCriteresByUser(int IdUser);
	public List<Critere> getAllCriteresByUserManager(int IdUser);
	public void deleteCritereById(int critere);
	public void updateCritere(Critere critere);
	public String notification (int IdUser);
	public Critere getCritereById(int id);
	
	
}
