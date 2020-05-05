package tn.Advyteam.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@XmlRootElement(name = "missions")

public class Mission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nomMission;

	private String description;

	private String adresse;

	@JsonProperty("dateDeb")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
	private Date dateDeb;
	@JsonProperty("dateFin")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
	private Date dateFin;
	private String type;
	
	@OneToMany(mappedBy = "mission",cascade = CascadeType.ALL)
	@JsonBackReference(value="demandes")
	private List<Demande> demandes;
	
	@ManyToMany(mappedBy="missions",cascade = CascadeType.ALL)
	@JsonBackReference(value="skills")
	//@NotNull
	private List<Skills> listSkill;
	
	@ManyToOne
	@JsonBackReference(value="project")
    @JoinColumn(name = "idProject", referencedColumnName = "id")

	private Project projet;
	
	@OneToOne
	//@JsonBackReference(value="expense")
	private Expenses expense;
	@XmlElement(name = "type")

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	@XmlElement(name = "expense")

	public Expenses getExpense() {
		return expense;
	}

	public void setExpense(Expenses expense) {
		this.expense = expense;
	}


	@XmlElement(name = "nomMission")

	public String getNomMission() {
		return nomMission;
	}

	public void setNomMission(String nomMission) {
		this.nomMission = nomMission;
	}
	@XmlElement(name = "description")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement(name = "adresse")

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	@XmlElement(name = "dateDeb")
	@Temporal(TemporalType.DATE)
	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}
	@XmlElement(name = "dateFin")
	@Temporal(TemporalType.DATE)
	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public List<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

	

	
	@XmlElement(name = "projet")
	public Project getProjet() {
		return projet;
	}

	public void setProjet(Project projet) {
		this.projet = projet;
	}
	@XmlAttribute(name = "id", required = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	

	public Mission(String nomMission, String description, String adresse, Date dateDeb, Date dateFin, String type) {
		super();
		this.nomMission = nomMission;
		this.description = description;
		this.adresse = adresse;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.type = type;
	}

	public List<Skills> getListSkill() {
		return listSkill;
	}

	public void setListSkill(List<Skills> listSkill) {
		this.listSkill = listSkill;
	}

	public Mission(String nomMission, String description, String adresse, Date dateDeb, Date dateFin, String type,
			List<Demande> demandes) {
		super();
		this.nomMission = nomMission;
		this.description = description;
		this.adresse = adresse;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.type = type;
		this.demandes = demandes;
	}

	public Mission() {
		super();
	}


	@Override
	public String toString() {
		return "Mission [id=" + id + ", nomMission=" + nomMission + ", description=" + description + ", adresse="
				+ adresse + ", dateDeb=" + dateDeb + ", dateFin=" + dateFin + ", type=" + type + "]";
	}

	
	
	
}
