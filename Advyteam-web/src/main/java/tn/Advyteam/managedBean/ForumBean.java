package tn.Advyteam.managedBean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.Advyteam.ServicesImp.ForumService;
import tn.Advyteam.entities.Forum;


@ManagedBean
@SessionScoped
public class ForumBean implements Serializable {
	public static final String ACCOUNT_SID = "AC76a060b6ff45590fa684e89e877fb165";
    public static final String AUTH_TOKEN = "a16fafa3c49851b3c6f30bd870eb071c";   
	
	    private static String message;
	   
	    private static String nometudiant;
	   
	    private static String prenometudiant;
	    private int id;

	    
	    private static ArrayList<Forum> forums;
	    
	    private static int choisi;
	    
	    private static String Choisi;
	    
	    private static String recherche;
	    
	    
	    public static List<Forum> forums2;
	    
	    
	 
	
		public static String getAccountSid() {
			return ACCOUNT_SID;
		}
		public static String getAuthToken() {
			return AUTH_TOKEN;
		}
		@EJB
	    ForumService fs;
		public ForumBean() {
			super();
		}
		public void AjouterForum()
		{
			Forum as = new Forum () ;
		LoginBean l = new LoginBean();
	as.setNometudiant(l.user.getNom());
	as.setPrenometudiant(l.user.getPrenom());
	as.setMessage(message);
	
			fs.AjouterForum(as); 
			
		}
		
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getNometudiant() {
			return nometudiant;
		}
		public void setNometudiant(String nometudiant) {
			this.nometudiant = nometudiant;
		}
		public String getPrenometudiant() {
			return prenometudiant;
		}
		public void setPrenometudiant(String prenometudiant) {
			this.prenometudiant = prenometudiant;
		}
		public ArrayList<Forum> getForums() {
			forums=(ArrayList<Forum>) fs.AfficherLesForums();
			return forums;
		}
		public void setForums(ArrayList<Forum> forums) {
			this.forums = forums;
		}
		public void ajouterEmoji1()
		{
			Choisi=" "+"&#x1F600;";
		}
		public void ajouterEmoji2()
		{
			Choisi= " "+"&#x1F600;  ";

		}
		public void ajouterEmoji3()
		{
			Choisi=" "+"&#x1F600;";

		}
		public String ajouterEmoji4()
		{
			String navigateTo = "null"; 
			
			
			navigateTo = "/template/AfficherForum?faces-redirect=false";
			Choisi=" "+"&#x1F610;";
			return navigateTo;
			
		}
		public static int getChoisi() {
			return choisi;
		}
		public static void setChoisi(int choisi) {
			ForumBean.choisi = choisi;
		}
		public static void setChoisi(String choisi) {
			Choisi = choisi;
		}
	 
	    public void like(Forum m)
	    {
	    	fs.ModifierLesLikes(m.getId());
	    }
	    public void disLike(Forum m)
	    {
	    	fs.ModifierLesDislike(m.getId());
	    }
	    
		public String getRecherche() {
			return recherche;
		}
		public void setRecherche(String recherche) {
			this.recherche = recherche;
		}
		public  List<Forum> getForums2() {
			return forums2;
		}
		public  void setForums2(List<Forum> forums2) {
			
			ForumBean.forums2 = forums2;
		}
	    
		public ForumService forumService() {
			return fs;
		}
		public void setUserService(ForumService fs) {
			this.fs = fs;
		}
		
	    public String rechercher(String recherche)
	    {
String navigateTo = "null"; 
			
			
			navigateTo = "/template/AfficherForumRecherce?faces-redirect=true";
			
			this.recherche = recherche;
			forums2=(ArrayList<Forum>) fs.RechercheForum(recherche);
			return navigateTo;
	    	
	    }
		
	    public String supprimerForum( int ids)
	    {
			
			

	    	fs.Supprimer(ids);
String navigateTo = "null"; 
			
			
			navigateTo = "/template/AfficherForum?faces-redirect=true";
			
			
			return navigateTo;
	    }
}
