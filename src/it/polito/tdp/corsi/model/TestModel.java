package it.polito.tdp.corsi.model;

import java.util.Map;
import java.util.Map.Entry;

public class TestModel {
	
	public void run() {
		GestoreCorsi model = new GestoreCorsi();
		Map<String, Integer> res = model.getIscrittiCorsi(1);
		
		for(Entry entry : res.entrySet()) { //scorro chiave e valore
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}

	public static void main(String[] args) {
		TestModel main = new TestModel();
		main.run();	
	}

}
