package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTempo;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	//txtResult.setText("");
    	String parola = txtParola.getText();
    	elenco.addParola(parola);
    	String descrizione = "Tempo impiegato per inserire: ";
    	
    	double start = System.nanoTime();
    	
    	LinkedList<String> ep = new LinkedList<String>();
    	ep = (LinkedList<String>) elenco.getElenco();
    	
    	String s = "";
    	for(String s1 : ep) {
    		s= s+ s1+"\n";
    	}
    	txtResult.setText(s);
    	
    	double stop = System.nanoTime();
    	
    	descrizione = descrizione + (stop-start);
    	this.txtTempo.setText(descrizione);
    	txtParola.setText("");
    }

    @FXML
    void doReset(ActionEvent event) {
    	String descrizione = "Temp impiegato per il reset: ";
    	
    	double start = System.nanoTime();
    	elenco.reset();
    	double stop = System.nanoTime();
    	
    	descrizione = descrizione + (stop-start);
    	this.txtTempo.setText(descrizione);
    	
    	txtResult.setText("");
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	
    	String parola = this.txtResult.getSelectedText();
    	String descrizione = "Tempo impiegato per cancellare: ";
    	
    	double start = System.nanoTime();
    	this.elenco.cancellaSelezionato(parola);
    	
    	
    	
    	LinkedList<String> ep = new LinkedList<String>();
    	ep = (LinkedList<String>) elenco.getElenco();
    	
    	String s = "";
    	for(String s1 : ep) {
    		s= s+ s1+"\n";
    	}
    	txtResult.setText(s);
    	double stop = System.nanoTime();
    	
    	descrizione = descrizione + (stop-start);
    	this.txtTempo.setText(descrizione);
    	
    	txtParola.setText("");
    }
    
    

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
