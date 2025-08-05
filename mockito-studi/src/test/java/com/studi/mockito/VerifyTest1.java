package com.studi.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.studi.LSF;
import com.studi.Studi;

/*
 Mit der Methode verify() kann auf einem Mock oder Spy überprüft werden, ob und wie oft und in welcher Reihenfolge Methoden aufgerufen wurden 
 und mit welchen Argumenten. Auch hier lassen sich wieder Argument-Matcher wie anyString() einsetzen.
Ein einfaches verify(mock) prüft dabei, ob die entsprechende Methode exakt einmal vorher aufgerufen wurde. 
Dies ist äquivalent zu verify(mock, times(1)). 
Analog kann man mit den Parametern atLeast() oder atMost 
bestimmte Unter- oder Obergrenzen für die Aufrufe angeben und mit never() prüfen, ob es gar keinen Aufruf vorher gab.
verifyNoMoreInteractions(lsf) ist interessant: Es ist genau dann true, 
wenn es außer den vorher abgefragten Interaktionen keinerlei sonstigen Interaktionen mit dem Mock oder Spy gab. 
 * 
 */
public class VerifyTest1 {
	   @Test
	    public void testAnmelden() {
	        LSF lsf = mock(LSF.class);  
	        Studi studi = new Studi("Harald", lsf);
	        System.out.println("Hello");

	        when(lsf.anmelden("Harald", "PM-Dungeon")).thenReturn(true);
	       
	        studi.anmelden("PM-Dungeon");
	        assertTrue(studi.anmelden("PM-Dungeon"));
	        
	        //verify(lsf).anmelden("Harald", "PM-Dungeon");
	        verify(lsf, times(2)).anmelden("Harald", "PM-Dungeon");
	        verify(lsf, atLeast(1)).anmelden("Harald", "PM-Dungeon");
	        verify(lsf, atMost(2)).anmelden("Harald", "PM-Dungeon");
	        verify(lsf, never()).ergebnis("Harald", "PM-Dungeon");
	        verifyNoMoreInteractions(lsf);
	    }

}
