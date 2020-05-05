package tn.Advyteam.managedBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import tn.Advyteam.ServicesImp.DetailsTacheServiceImpl;
import tn.Advyteam.dtos.TimeSheetDto;
import tn.Advyteam.entities.DetailsTache;
import tn.Advyteam.entities.Employe;
import tn.Advyteam.entities.Taches;


@ManagedBean(name = "timeSheetBean")
@ViewScoped
public class TimeSheetBean {

	private Date date;
	
	private List<DetailsTache> listDetailTaches;
	
	private List<TimeSheetDto> listTimeSheetDtos;
	
	@EJB
	DetailsTacheServiceImpl detailTacheService;
	
	@PostConstruct
	public void init() {
		date = new Date();
		rechercher(date);
	}
	
	public void rechercher(Date date) {
		listDetailTaches = detailTacheService.getDetailsTacheByDate(date);
		listTimeSheetDtos = new ArrayList<TimeSheetDto>();
		Map<Employe, Integer> map = new HashMap<>();
		if(listDetailTaches != null && !listDetailTaches.isEmpty()) {
			
			for(DetailsTache details : listDetailTaches ) {
				if(map.containsKey(details.getTache().getEmploye())) {
					map.put(details.getTache().getEmploye(), map.get(details.getTache().getEmploye())+details.getNbrHeures());
				}else {
					map.put(details.getTache().getEmploye(), details.getNbrHeures());
				}
			}
			for(Entry<Employe, Integer> entry : map.entrySet()) {
				String nomEmploye = entry.getKey().getNom() + " " + entry.getKey().getPrenom();
				TimeSheetDto dto = new TimeSheetDto(nomEmploye, entry.getValue());
				listTimeSheetDtos.add(dto);
			}
		}
	}
	
	public void onDateSelect(SelectEvent event) {
		Date date = (Date) event.getObject();
		rechercher(date);
    }
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<DetailsTache> getListDetailTaches() {
		return listDetailTaches;
	}
	public void setListDetailTaches(List<DetailsTache> listDetailTaches) {
		this.listDetailTaches = listDetailTaches;
	}
	public List<TimeSheetDto> getListTimeSheetDtos() {
		return listTimeSheetDtos;
	}
	public void setListTimeSheetDtos(List<TimeSheetDto> listTimeSheetDtos) {
		this.listTimeSheetDtos = listTimeSheetDtos;
	}
	
}
