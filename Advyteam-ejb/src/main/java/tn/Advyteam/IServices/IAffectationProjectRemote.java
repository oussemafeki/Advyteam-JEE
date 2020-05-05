package tn.Advyteam.IServices;

import javax.ejb.Remote;

import tn.Advyteam.entities.AffectationProject;

@Remote
public interface IAffectationProjectRemote {
	int save(AffectationProject affProject);

}
