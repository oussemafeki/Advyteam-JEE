package tn.Advyteam.IServices;

import java.util.List;


import javax.ejb.Remote;

import tn.Advyteam.entities.*;


@Remote
public interface ForumServiceRemote {
	public void AjouterForum(Forum f);
	public List<Forum> AfficherLesForums();
	public void Supprimer(int id);
	public void ModifierLaQuantite();
	public void ModifierLesLikes(int id);
	public void ModifierLesDislike(int id);
	public List<Forum> RechercheForum(String recherche);


}
