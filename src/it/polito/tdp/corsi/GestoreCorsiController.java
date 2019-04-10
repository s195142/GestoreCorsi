package it.polito.tdp.corsi;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.GestoreCorsi;
import it.polito.tdp.corsi.model.Studente;

import java.awt.TextArea;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GestoreCorsiController {
	
	private GestoreCorsi model;
	
	/**
	 * Sample Skeleton for 'GestoreCorsi.fxml' Controller Class
	 */


	    @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="txtPeriodo"
	    private TextField txtPeriodo; // Value injected by FXMLLoader

	    @FXML // fx:id="btnCercaCorsi"
	    private Button btnCercaCorsi; // Value injected by FXMLLoader

	    @FXML // fx:id="btnStatCorsi"
	    private Button btnStatCorsi; // Value injected by FXMLLoader


	    @FXML // fx:id="txtCorso"
	    private TextField txtCorso; // Value injected by FXMLLoader

	    @FXML // fx:id="btnElenca"
	    private Button btnElenca; // Value injected by FXMLLoader

	    @FXML // fx:id="btnCds"
	    private Button btnCds; // Value injected by FXMLLoader

	    @FXML // fx:id="txtResult"
	    private TextArea txtResult; // Value injected by FXMLLoader

	    @FXML
	    void doCalcolaStatCorsi(ActionEvent event) {
	    	
	    }
	    
	    @FXML
	    void doCercaCorsi(ActionEvent event) {
	    	int periodo;
	    	try {
	    		periodo = Integer.parseInt(txtPeriodo.getText());
	    	}catch(NumberFormatException e){
	    		txtResult.appendText("Devi inserire un periodo (1 o 2-)");
	    		return;
	    	}
	    	
	    	if((periodo!=1)&&(periodo!=2)) {
	    		txtResult.appendText("Devi inserire un periodo (1 o 2-)");
	    		return;
	    	}
	    	

	    }
	    
	    
	    @FXML
	    void doElenca(ActionEvent event) {
	    	String codins = txtCorso.getText();
	    	List<Studente> studenti = this.model.elencaStudenti(codins);
	    	for(Studente s : studenti) {
	    		txtResult.appendText(s.toString()+"\n");
	    	}
	    }

	    @FXML
	    void doStatCds(ActionEvent event) {

	    }
	    
	    
	    

	    @FXML // This method is called by the FXMLLoader when initialization is complete
	    void initialize() {
	        assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
	        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
	        assert btnStatCorsi != null : "fx:id=\"btnStatCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
	        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
	        assert btnElenca != null : "fx:id=\"btnElenca\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
	        assert btnCds != null : "fx:id=\"btnCds\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
	        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
	    }

	

	public void setModel(GestoreCorsi model) {
		this.model=model;
	}
	
}
