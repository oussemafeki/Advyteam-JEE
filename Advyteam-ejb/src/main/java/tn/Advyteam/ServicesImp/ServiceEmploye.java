package tn.Advyteam.ServicesImp;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.Advyteam.IServices.IserviceEmploye;
import tn.Advyteam.entities.Employe;


@Stateless
@LocalBean
public class ServiceEmploye  implements IserviceEmploye{
	@PersistenceContext
	EntityManager em;

	@Override
	public int ajouterEmploye(Employe employe) {
		System.out.println("In addEmplye : ");
		em.persist(employe);
		System.out.println("Out of addUser" + employe.getId());
		return employe.getId();
		
	}

	@Override
	public void deleteEmployeById(int employeId) {
		em.createQuery("DELETE FROM Employe d WHERE d.id=:Id").setParameter("Id", employeId).executeUpdate();
	   
		
	}

	@Override
	public long getNombreEmployeJPQL() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employe> getAllEmployes() {
	List<Employe> emp = em.createQuery("Select e from Employe e",Employe.class).getResultList();
	return emp;
	}

	@Override
	public void updateEmploye(Employe employe) {
	Employe emp = em.find(Employe.class, employe.getId());
	emp.setPrenom(employe.getPrenom());
	emp.setNom(employe.getNom());
	emp.setEmail(employe.getEmail());
	emp.setPassword(employe.getPassword());
	emp.setIsActif(employe.getIsActif());
	emp.setRole(employe.getRole());
	emp.setId(emp.getId());
	}

	@Override
	public Employe getUserByEmailAndPassword(String email, String password) {
		TypedQuery<Employe> query = 
				em.createQuery("select u from Employe u WHERE u.email=:email and u.password=:password ", Employe.class); 
		query.setParameter("email", email); 
		query.setParameter("password", password); 
		Employe user = null; 
		try { 			user = query.getSingleResult(); }
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return user;
	}
	@Override

	public Employe getUserById(int id) {
		Employe user = new Employe();
		TypedQuery<Employe> query = em.createQuery("select u from Employe u WHERE u.id=:id", Employe.class); 
		query.setParameter("id", id); 
		
		user=query.getSingleResult();
		return user;
	}
	
	
	
}
