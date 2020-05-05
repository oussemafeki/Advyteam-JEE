package tn.Advyteam.IServices;

import java.util.List;
import javax.ejb.Remote;

import tn.Advyteam.entities.Poste;

@Remote
public interface IPosteService {
	
	public int addPoste(Poste p);
	public void removePoste(int id);
	public void updatePoste(Poste pos);
	public Poste findPosteById(int id);
	public List<Poste> getAllPoste();


}
