package tn.Advyteam.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import tn.Advyteam.ServicesImp.ModulesServiceRemoteImp;
import tn.Advyteam.ServicesImp.TachesServiceRemoteImp;
import tn.Advyteam.dtos.TacheDto;
import tn.Advyteam.entities.Modules;
import tn.Advyteam.entities.Project;
import tn.Advyteam.entities.Taches;

@ManagedBean(name = "detailProjetBean")
@SessionScoped
public class DetailProjetBean {

	@EJB
	ModulesServiceRemoteImp moduleService;

	@EJB
	TachesServiceRemoteImp tacheService;

	private Project project;

	private List<Modules> modules;
	private List<Taches> tachesByModule ;
	private List<TacheDto> listeTachesDto;
	

	public void init() {
		modules=new ArrayList<Modules>();
		tachesByModule =new ArrayList<Taches>();
		listeTachesDto = new ArrayList<TacheDto>();
		if (project != null) {
		
			modules = moduleService.getModulesProjet(project.getId());
			if(modules != null && !modules.isEmpty()) {
			
				for (Modules mod : modules) {
						
				tachesByModule = tacheService.getTacheModule(mod.getId());
					if(tachesByModule != null && !tachesByModule.isEmpty()) {
						
						for (Taches tache : tachesByModule) {
							TacheDto dto = new TacheDto(mod.getNomModule(), tache.getNomTache(), tache.getDescriptionTache(),
									tache.getDateEstimer());
							listeTachesDto.add(dto);
						}
					}
					
				}
			}
			
		}

	}

	public DetailProjetBean() {
		// TODO Auto-generated constructor stub
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

	public List<TacheDto> getListeTachesDto() {
		return listeTachesDto;
	}

	public void setListeTachesDto(List<TacheDto> listeTachesDto) {
		this.listeTachesDto = listeTachesDto;
	}

	public void setModules(List<Modules> modules) {
		this.modules = modules;
	}

}
