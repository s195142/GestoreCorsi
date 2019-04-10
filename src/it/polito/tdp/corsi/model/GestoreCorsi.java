package it.polito.tdp.corsi.model;

import java.util.*;

import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.db.StudenteDAO;

public class GestoreCorsi {

	public List<Corso> getCorsiByPeriodo(int periodo){
		CorsoDAO dao = new CorsoDAO();
		
		// sol 1
//		List<Corso> corsi = dao.listAll();
//		List<Corso> result = new ArrayList<Corso>();
//		
//		for(Corso c : corsi) {
//			if(c.getPd()==periodo) {
//				result.add(c);
//			}
//		}
		
		// sol 2
		return dao.listCorsiByPD(periodo);
		
	}
	
	public Map<String, Integer> getIscrittiCorsi(int periodo){
		CorsoDAO dao = new CorsoDAO();
		return dao.getIscrittiCorsi(periodo);
	}

	public List<Studente> elencaStudenti(String codins) {
		StudenteDAO dao = new StudenteDAO();
		return dao.elencaStud(codins);
	}
	
}
