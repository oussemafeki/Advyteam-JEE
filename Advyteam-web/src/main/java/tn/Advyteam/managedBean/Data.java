package tn.Advyteam.managedBean;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.Advyteam.entities.Role;
import tn.Advyteam.entities.TypeContrat;
@ManagedBean(name = "data")
@ApplicationScoped
public class Data implements Serializable {
	private static final long serialVersionUID = 1L;
	public TypeContrat[] getTypeContrat() {
		return TypeContrat.values(); 
	}
	public Role[] getRoles() { return Role.values(); }
}