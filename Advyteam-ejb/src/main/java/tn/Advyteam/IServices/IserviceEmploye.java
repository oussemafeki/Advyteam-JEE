package tn.Advyteam.IServices;



import java.util.Date;

import java.util.List;

import javax.ejb.Remote;

import tn.Advyteam.entities.Employe;




@Remote
public interface IserviceEmploye {
	
	public int ajouterEmploye(Employe employe);
	public void deleteEmployeById(int employeId);
	public long getNombreEmployeJPQL();
	public List<Employe> getAllEmployes();
	public void updateEmploye(Employe employe); 
	public Employe getUserByEmailAndPassword(String email, String password) ;
	public Employe getUserById(int email);

	
}
