package tn.Advyteam.managedBean;




import java.io.Serializable;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import tn.Advyteam.ServicesImp.ServiceEmploye;
import tn.Advyteam.ServicesImp.UserServiceRemoteImpl;
import tn.Advyteam.entities.Employe;
import tn.Advyteam.entities.Role;
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable  {
	private List<Employe> employes;


	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	private  Employe emp;

	private static String login; 
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}




	public  void setEmp(Employe emp) {
		emp = emp;
	}

	private String prenom; private String nom; private String password;
	 public String getPrenom() {
		return prenom;
	}



	private Boolean isActif; private Role role; 	public static Employe user; 
	private Boolean loggedIn;
	@EJB
	ServiceEmploye userService;
	
	public  Employe getEmp() {
		 emp =  userService.getUserByEmailAndPassword(login, password);
		 return emp;
	}
	
	public String sendmail() {
		final String username = "oussamafeki1997@gmail.com\"";
		final String password = "99081197";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
			}
		  });
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("oussemafeki1997@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(login));
			message.setSubject("ADVYTEAM");
			message.setText("votre mot passe: 0000");
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
			
		return "sqss";
	
		}
	public String doLogin() {
		
		String navigateTo = "null";
		user = userService.getUserByEmailAndPassword(login, password);
		if (user!=null)   {
			
			//****************************

			navigateTo = "/Home.xhtml?faces-redirect=true"; loggedIn = true; }
		else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));}
		return navigateTo; }
	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true"; }
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Boolean getIsActif() {
		return isActif;
	}
	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employe getUser() {
		return user;
	}
	public void setUser(Employe user) {
		this.user = user;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public ServiceEmploye getUserService() {
		return userService;
	}
	public void setUserService(ServiceEmploye userService) {
		this.userService = userService;
	}
	
	


		
		
	public void addEmploye() {
		userService.ajouterEmploye(new Employe(nom, prenom, login, password, isActif,
		role)); }
	
	
	public List<Employe> getEmployes() {
	employes = userService.getAllEmployes();
	return employes;} 

	
	
	public void removeEmploye(int employeId)
	{
	userService.deleteEmployeById(employeId);
	}

	
	public void updateEmploye()
	{ userService.updateEmploye(new Employe(id, nom, prenom,
	login, password, isActif, role)); } 
	
	
	public void displayEmploye(Employe empl)
	{
	this.setPrenom(empl.getPrenom());
	this.setNom(empl.getNom());
	this.setIsActif(empl.getIsActif());
	this.setLogin(empl.getEmail());
	this.setRole(empl.getRole());
	this.setPassword(empl.getPassword());
	this.setId(empl.getId());
	}
	
}
