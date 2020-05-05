package tn.Advyteam.IServices;

import java.util.List;

import javax.ejb.Remote;

import tn.Advyteam.entities.Critere;
import tn.Advyteam.entities.Selfeval;




@Remote
public interface ISelfEvalService {
	public int ajouterSelfEval(Selfeval selfeval);
	public List<Selfeval> getAllSelfEvals(int employe);
	public void deleteSelfEvalById(int SelfEvalId);
	public void updateSelfEval(Selfeval selfeval);
	public void affecterEvalCritere(int evalid,int critereid);
	public int ajouterCritere(Critere critere);
	public Critere getCritereByName(String name);
	public Double getMoy();
}
