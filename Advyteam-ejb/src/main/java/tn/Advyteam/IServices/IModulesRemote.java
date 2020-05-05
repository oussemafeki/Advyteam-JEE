package tn.Advyteam.IServices;

import java.util.List;

import javax.ejb.Remote;

import tn.Advyteam.entities.Modules;

@Remote
public interface IModulesRemote {
	public void addModule (Modules module);
	public List<Modules> getAllModules() ;
	public void removeModule(int id);
	public void updateModule(Modules module);
	public Modules findModuleById(int id);
	public List<Modules> getModulesProjet(int id);
}
