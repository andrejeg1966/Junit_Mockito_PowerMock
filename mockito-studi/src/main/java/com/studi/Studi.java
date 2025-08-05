package com.studi;

public class Studi {
    String name;  
    LSF lsf;
   
    public Studi(String name, LSF lsf) {
        this.name = name;  
        this.lsf = lsf;
    }

    public boolean anmelden(String modul) {
    	
    	return lsf.anmelden(name, modul); 
    }
    public boolean einsicht(String modul) { 
    	return lsf.ergebnis(name, modul) > 50; 
    }
}
