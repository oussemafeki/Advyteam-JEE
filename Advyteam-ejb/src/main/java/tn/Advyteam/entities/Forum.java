package tn.Advyteam.entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Forum implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;
	 
	   @Column(name = "message")
	    private String message;
	   
	   @Column(name = "nometudiant")
	    private String nometudiant;
	   
	   @Column(name = "prenometudiant")
	    private String prenometudiant;
	   
	   @Temporal(TemporalType.DATE)
	    private Date datemessage;
	   
	   private int likes;
	   private int dislikes;

	
	public Date getDatemessage() {
		return datemessage;
	}

	public void setDatemessage(Date datemessage) {
		this.datemessage = datemessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNometudiant() {
		return nometudiant;
	}

	public void setNometudiant(String nometudiant) {
		this.nometudiant = nometudiant;
	}

	public String getPrenometudiant() {
		return prenometudiant;
	}

	public void setPrenometudiant(String prenometudiant) {
		this.prenometudiant = prenometudiant;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public Forum(int id,String message, String nometudiant, String prenometudiant) {
		super();
		this.message = message;
		this.nometudiant = nometudiant;
		this.prenometudiant = prenometudiant;
		this.id= id;
	
	}

	public Forum() {
		super();
	}
	   
	   

}
