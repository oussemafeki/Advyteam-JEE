package tn.Advyteam.dtos;

public class TimeSheetDto {

	private String nomEmploye;
	
	private int nbrHeures;
	
	public TimeSheetDto() {
		
	}

	public TimeSheetDto(String nomEmploye, int nbrHeures) {
		super();
		this.nomEmploye = nomEmploye;
		this.nbrHeures = nbrHeures;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public int getNbrHeures() {
		return nbrHeures;
	}

	public void setNbrHeures(int nbrHeures) {
		this.nbrHeures = nbrHeures;
	}
	
}
