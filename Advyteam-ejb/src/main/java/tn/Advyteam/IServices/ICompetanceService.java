package tn.Advyteam.IServices;

import java.util.List;

import javax.ejb.Remote;

import tn.Advyteam.entities.Competance;

@Remote
public interface ICompetanceService {
	
	public int addCompetance(Competance c);
	public void removeCompetance(int id);
	public void updateCompetance(Competance compet);
	public Competance findCompetanceById(int id);
	public List<Competance> getAllCompetance();
	public void assignCompetanceToPoste(int idCompetance, int idPoste);

}
