package tn.Advyteam.managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.Advyteam.ServicesImp.TachesServiceRemoteImp;

import tn.Advyteam.entities.Taches;


@ManagedBean(name = "TacheBean")
@ViewScoped
public class TacheBean {
@EJB
TachesServiceRemoteImp tacheService;
private List<Taches> taches;

public List<Taches> getallTaches() {
	taches=tacheService.getAllTaches();
	return taches;
}
public List<Taches> getTacheModule(int id) {
	taches=tacheService.getTacheModule(id);
	return taches;
}


}
