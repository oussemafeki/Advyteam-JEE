package tn.Advyteam.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
public class DetailsTache implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2877731615171133852L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date date;

	private int nbrHeures;

	private String description;

	@ManyToOne
	@JoinColumn(name = "id_tache")
	private Taches tache;
	
	public DetailsTache() {
		
	}

	public DetailsTache(int id, int nbrHeures, String description, Taches tache) {
		super();
		this.id = id;
		this.nbrHeures = nbrHeures;
		this.description = description;
		this.tache = tache;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Taches getTache() {
		return tache;
	}

	public void setTache(Taches tache) {
		this.tache = tache;
	}
	@JsonProperty("creationDateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
