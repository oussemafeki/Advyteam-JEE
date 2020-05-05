package tn.Advyteam.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Skills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private String Skillname;


	@ManyToMany
	@JsonBackReference
	private List<Mission> missions;

	public String getSkillname() {
		return Skillname;
	}


	public void setSkillname(String skillname) {
		Skillname = skillname;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	


	


	public List<Mission> getMissions() {
		return missions;
	}


	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}


	@Override
	public String toString() {
		return Skillname ;
	}
	
	
}
