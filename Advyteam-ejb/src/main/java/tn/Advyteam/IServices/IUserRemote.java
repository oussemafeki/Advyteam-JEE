package tn.Advyteam.IServices;

import java.util.List;

import javax.ejb.Remote;

import tn.Advyteam.entities.Employe;



@Remote
public interface IUserRemote {

	List<Employe> getAllUsers();
	Employe getConnectedUser();
}
