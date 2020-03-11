package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
		
	LinkedList<String> elencoParole;
	
	
	public Parole() {
		
		this.elencoParole = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		this.elencoParole.add(p);
		
	}
	
	public List<String> getElenco() {
		Collections.sort(this.elencoParole, new ComparatoreParole());
		return this.elencoParole;
	}
	
	public void reset() {
		
		for(int i = 0 ; i<this.elencoParole.size();i++) {
			this.elencoParole.removeAll(elencoParole);
		}
	}
	
	public void cancellaSelezionato(String s) {
		this.elencoParole.remove(s);
	}

}
