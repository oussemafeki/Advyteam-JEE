package tn.Advyteam.IServices;

import java.util.List;

import javax.ejb.Remote;

import tn.Advyteam.entities.Taches;
@Remote
public interface ITachesRemote {
	public void addTache (Taches tache);
	public List<Taches> getAllTaches() ;
	public void removeTache(int id);
	public void updateTache(Taches tache);
	public Taches findTacheById(int id);
	public List<Taches> getTacheModule(int id);
}
