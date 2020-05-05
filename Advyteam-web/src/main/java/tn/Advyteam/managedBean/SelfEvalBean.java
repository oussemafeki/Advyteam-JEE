package tn.Advyteam.managedBean;



import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.Advyteam.ServicesImp.SelfEvalService;
import tn.Advyteam.entities.Critere;
import tn.Advyteam.entities.Selfeval;



@ManagedBean(name = "selfevalBean") 
@SessionScoped 
public class SelfEvalBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private int value ;
	private String description ;
	private Critere critere =null;
	private String cri ;
	
	
	public Critere getCritere() {
		return critere;
	}
	public void setCritere(Critere critere) {
		this.critere = critere;
	}
	
	public String getCri() {
		return cri;
	}
	public void setCri(String cri) {
		this.cri = cri;
	}

	@EJB
	SelfEvalService ses;
	private List<Selfeval> selfevals;
	private int idevaluptodate;
	private double Moyenne;
	
	public void setMoyenne(double moyenne) {
		Moyenne = moyenne;
	}
	public double getMoyenne()
	{
		return ses.getMoy();
	}
	public List<Selfeval> getSelfevals() {
		selfevals = ses.getAllSelfEvals(1); return selfevals;
	}
	
	public void setSelfevals(List<Selfeval> selfevals) {
		this.selfevals = selfevals;
	}
	public String addEval() { 
		if((value<0)||(value>100))
		{
			System.out.println("la valeur doit être entre 0 et 100");
		}
		else if ((cri=="")||(value==0))
		{
			System.out.println("les champs sont obligatoires !");
		}
		else {
	critere = ses.getCritereByName(cri);
		System.out.println(cri);
		System.out.println(critere+"--");
		Selfeval se =new Selfeval(id, value, description, 1, critere);
		ses.ajouterSelfEval(se);
		}
		return "showevals?faces-redirect=true";}
	public void removeEval(int evalId) { ses.deleteSelfEvalById(evalId); }
	public String updateEvalInit(Selfeval s){

		this.setValue(s.getValue());
		this.setDescription(s.getDescription());
		this.setIdevaluptodate(s.getId());

		return "Updateevals?faces-redirect=true";


	}
	
	public int getIdevaluptodate() {
		return idevaluptodate;
	}
	public void setIdevaluptodate(int idevaluptodate) {
		this.idevaluptodate = idevaluptodate;
	}
	public String updateEval() { ses.updateSelfEval(new Selfeval(idevaluptodate, value, description));
	return "showevals?faces-redirect=true";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
