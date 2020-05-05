package tn.Advyteam.managedBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;
import org.primefaces.event.DragDropEvent;

import tn.Advyteam.ServicesImp.DetailsTacheServiceImpl;
import tn.Advyteam.ServicesImp.ModulesServiceRemoteImp;
import tn.Advyteam.ServicesImp.TachesServiceRemoteImp;
import tn.Advyteam.ServicesImp.UserServiceRemoteImpl;
import tn.Advyteam.dtos.TacheDto;
import tn.Advyteam.entities.DetailsTache;
import tn.Advyteam.entities.Employe;
import tn.Advyteam.entities.Modules;
import tn.Advyteam.entities.Project;
import tn.Advyteam.entities.Taches;


@ManagedBean(name = "detailsTacheBean")
@SessionScoped
public class DetailsTacheBean {

	private Project project;
	
	private List<Modules> modules;
	
	private List<TacheDto> tacheToDo;
	
	private List<TacheDto> tacheInProgress;
	
	private List<TacheDto> tacheDone;
	
	private int nbrHeures;
	
	private String description;
	
	private boolean isUpdate;
	
	private TacheDto tache;
	
	@EJB
	ModulesServiceRemoteImp moduleService;

	@EJB
	TachesServiceRemoteImp tacheService;
	
	@EJB
	UserServiceRemoteImpl userService;
	
	@EJB
	DetailsTacheServiceImpl detailTacheService;
	
	private Employe userConnecte;
	
	private static final int TACHE_TO_DO = 0;
	
	private static final int TACHE_IN_PROGRESS = 1;
	
	private static final int TACHE_DONE = 2;
	
	public void init() {
		if (project != null) {
			userConnecte = userService.getConnectedUser();
			modules = moduleService.getModulesProjet(project.getId());
			if(modules != null && !modules.isEmpty()) {
				tacheToDo = new ArrayList<TacheDto>();
				
				tacheInProgress = new ArrayList<TacheDto>();
				
				tacheDone = new ArrayList<TacheDto>();
				for (Modules mod : modules) {
					List<Taches> tachesByModule = tacheService.getTacheModule(mod.getId());
					if(tachesByModule != null && !tachesByModule.isEmpty()) {
						
						for (Taches tache : tachesByModule) {
							String nomEmploye = null;
							if(tache.getEmploye() != null) {
								nomEmploye = tache.getEmploye().getNom() + " " + tache.getEmploye().getPrenom();
							}
							TacheDto dto = new TacheDto(tache.getId(), mod.getNomModule(), tache.getNomTache(), tache.getDescriptionTache(),
									tache.getDateEstimer(), tache.getEtat(), nomEmploye);
							if(tache.getEtat() == TACHE_TO_DO) {
								tacheToDo.add(dto);
							}else if(tache.getEtat() == TACHE_IN_PROGRESS) {
								tacheInProgress.add(dto);
							}else if(tache.getEtat() == TACHE_DONE){
								tacheDone.add(dto);
							}
						}
					}
					
				}
			}
			
		}
	}
	 public void onTacheDrop(DragDropEvent ddEvent) {
		 System.out.println("ontachedrop methode ***");
	        TacheDto tacheDto = ((TacheDto) ddEvent.getData());
	        tacheInProgress.add(tacheDto);
	        Taches tache = tacheService.findTacheById(tacheDto.getIdTache());
	        tache.setEtat(TACHE_IN_PROGRESS);
	        tache.setDateDebut(new Date());
	        tache.setEmploye(userConnecte);
	        tacheService.updateTache(tache);
	        tacheToDo.remove(tacheDto);
	    }
	 
	 public void onTacheToDoneDrop(DragDropEvent ddEvent) {
		 TacheDto tacheDto = ((TacheDto) ddEvent.getData());
		 Taches tache = tacheService.findTacheById(tacheDto.getIdTache());
		 if(tache.getEmploye() != null && tache.getEmploye().getId() == userConnecte.getId()) {
			 tacheInProgress.remove(tacheDto);
			 tacheDone.add(tacheDto);
			 tache.setEtat(TACHE_DONE);
			 tache.setDateFin(new Date());
			 tacheService.updateTache(tache);
		 }
	 }
	 
	 public void validerDetailsTache() {
		 if(!isUpdate) {
			 DetailsTache details = new DetailsTache();
			 Taches t = tacheService.findTacheById(tache.getIdTache());
			 details.setTache(t);
			 details.setDescription(description);
			 details.setNbrHeures(nbrHeures);
			 details.setDate(new Date());
			 detailTacheService.save(details); 
		 }else {
			 Taches t = tacheService.findTacheById(tache.getIdTache());
			 DetailsTache detail = detailTacheService.getDetailTacheByDateAndTache(new Date(), t);
			 detail.setNbrHeures(nbrHeures);
			 detail.setDescription(description);
			 detailTacheService.update(detail);
		 }
		 
	 }
	 
	 public void showDialog() {
		 
		 Taches t = tacheService.findTacheById(tache.getIdTache());
		 DetailsTache detail = detailTacheService.getDetailTacheByDateAndTache(new Date(), t);
		 if(detail != null) {
			 nbrHeures = detail.getNbrHeures();
			 description = detail.getDescription();
			 isUpdate = true;
		 }else {
			 nbrHeures = 0;
			 description = "";
			 isUpdate = false;
		 }
		 
		 PrimeFaces current = PrimeFaces.current();
		 current.executeScript("PF('dlg2').show();");
	 }

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Modules> getModules() {
		return modules;
	}

	public void setModules(List<Modules> modules) {
		this.modules = modules;
	}

	public List<TacheDto> getTacheToDo() {
		return tacheToDo;
	}

	public void setTacheToDo(List<TacheDto> tacheToDo) {
		this.tacheToDo = tacheToDo;
	}

	public List<TacheDto> getTacheInProgress() {
		return tacheInProgress;
	}

	public void setTacheInProgress(List<TacheDto> tacheInProgress) {
		this.tacheInProgress = tacheInProgress;
	}

	public List<TacheDto> getTacheDone() {
		return tacheDone;
	}

	public void setTacheDone(List<TacheDto> tacheDone) {
		this.tacheDone = tacheDone;
	}
	public Employe getUserConnecte() {
		return userConnecte;
	}
	public void setUserConnecte(Employe userConnecte) {
		this.userConnecte = userConnecte;
	}
	public int getNbrHeures() {
		return nbrHeures;
	}
	public void setNbrHeures(int nbrHeures) {
		this.nbrHeures = nbrHeures;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TacheDto getTache() {
		return tache;
	}
	public void setTache(TacheDto tache) {
		this.tache = tache;
	}
	
}
