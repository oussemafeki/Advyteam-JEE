package tn.Advyteam.ServicesImp;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.Advyteam.IServices.ForumServiceRemote;
import tn.Advyteam.entities.Forum;


@Stateless
@LocalBean
public class ForumService implements ForumServiceRemote {
	@PersistenceContext
    private EntityManager entityManager;
	public static final String ACCOUNT_SID = "AC76a060b6ff45590fa684e89e877fb165";
    public static final String AUTH_TOKEN = "a16fafa3c49851b3c6f30bd870eb071c";
	@Override
	public void AjouterForum(Forum f) {
		entityManager.persist(f);
	}

	@Override
	public List<Forum> AfficherLesForums() {
		 TypedQuery<Forum> query = entityManager.createQuery("SELECT m FROM Forum m ",
	                Forum.class);

	        return query.getResultList();
	}
	
	@Override
	public void Supprimer(int id) {
		 entityManager.createQuery("Delete FROM Forum   where id ="+id).executeUpdate();
		
	}

	





	@Override
	public void ModifierLaQuantite() {
		// TODO Auto-generated method stub
		entityManager.createQuery("UPDATE Uniforme SET quantity= quantity-1 WHERE id="+1).executeUpdate(); 

	}

	@Override
	public void ModifierLesLikes(int id) {
		// TODO Auto-generated method stub
		entityManager.createQuery("UPDATE Forum SET likes= likes+1 WHERE id="+id).executeUpdate(); 
		
	}

	@Override
	public void ModifierLesDislike(int id) {
		// TODO Auto-generated method stub
		entityManager.createQuery("UPDATE Forum SET dislikes= dislikes+1 WHERE id="+id).executeUpdate(); 

	}

	@Override
	public List<Forum> RechercheForum(String recherche) {
		// TODO Auto-generated method stub
		TypedQuery<Forum> query = entityManager.createQuery("SELECT m FROM Forum m  where m.nometudiant = '"+recherche+"'",
				Forum.class);

        return query.getResultList();
	}
	
	
	

}
