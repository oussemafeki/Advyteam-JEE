package tn.Advyteam.entities;

import java.io.Serializable
;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Departement implements Serializable {



	public Departement(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	private static final long serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	



	public Departement() {
		super();
	}
	
	public Departement(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

}
