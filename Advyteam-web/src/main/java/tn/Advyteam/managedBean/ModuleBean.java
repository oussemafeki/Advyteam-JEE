package tn.Advyteam.managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.Advyteam.ServicesImp.ModulesServiceRemoteImp;
import tn.Advyteam.entities.Modules;
import tn.Advyteam.entities.Project;

@ManagedBean(name = "ModuleBean")
@ViewScoped 
public class ModuleBean {
@EJB
ModulesServiceRemoteImp moduleService;

private List<Modules> modules;

public List<Modules> getallModules() {
	modules=moduleService.getAllModules();
	return modules;
}

public List<Modules> getModulesProjet(int id) {
	modules=moduleService.getModulesProjet(id);
	return modules;
}
}
