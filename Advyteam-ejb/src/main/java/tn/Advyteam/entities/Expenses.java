package tn.Advyteam.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@XmlRootElement(name = "expense")

public class Expenses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;

	private Float distance;
	private Float prix_transport;
	private Float prix_hebergement;
	private Float prix_resto;
	private Float autres_frais;
	private Float total;
	
	@OneToOne(mappedBy = "expense")
	@JsonBackReference(value="expense")
	private Mission mission_exp;
	
	@Override
	public String toString() {
		return title;
	}
	@XmlElement(name = "title")

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public Expenses(String title, Float distance, Float prix_transport, Float prix_hebergement, Float prix_resto,
			Float autres_frais) {
		super();
		this.title = title;
		this.distance = distance;
		this.prix_transport = prix_transport;
		this.prix_hebergement = prix_hebergement;
		this.prix_resto = prix_resto;
		this.autres_frais = autres_frais;
	}

	public Expenses() {
		super();
	}
	@XmlAttribute(name = "id", required = false)

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name = "distance")

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}
	@XmlElement(name = "prix_transport")

	public Float getPrix_transport() {
		return prix_transport;
	}

	public void setPrix_transport(Float prix_transport) {
		this.prix_transport = prix_transport;
	}
	@XmlElement(name = "prix_hebergement")

	public Float getPrix_hebergement() {
		return prix_hebergement;
	}

	public void setPrix_hebergement(Float prix_hebergement) {
		this.prix_hebergement = prix_hebergement;
	}
	@XmlElement(name = "prix_resto")

	public Float getPrix_resto() {
		return prix_resto;
	}

	public void setPrix_resto(Float prix_resto) {
		this.prix_resto = prix_resto;
	}
	@XmlElement(name = "autres_frais")

	public Float getAutres_frais() {
		return autres_frais;
	}

	public void setAutres_frais(Float autres_frais) {
		this.autres_frais = autres_frais;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Mission getMission_exp() {
		return mission_exp;
	}

	public void setMission_exp(Mission mission_exp) {
		this.mission_exp = mission_exp;
	}

	
	
}
