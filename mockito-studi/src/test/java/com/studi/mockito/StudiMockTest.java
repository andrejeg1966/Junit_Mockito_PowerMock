package com.studi.mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;


import org.junit.Before;
import org.junit.Test;


import com.studi.LSF;
import com.studi.Studi;

public class StudiMockTest {
    Studi studi;  
    LSF lsf;

    @Before
    public void setUp() { 
    	//Mocke die LSF class
    	lsf = mock(LSF.class);  
    	studi = new Studi("Harald", lsf);
    	//Wenn die Funktion anmelden aufgerfufen wird gebe true zurück
    	when(lsf.anmelden(anyString(), anyString())).thenReturn(true);
    	//Wenn die Funktion ergebnis aufgerfufen wird gebe 51 zurück
    	when(lsf.ergebnis("Harald", "PM-Dungeon")).thenReturn(51);
    }

    @Test
    public void testAnmelden() {
    	//prüfe ob die gemockte Funktion anmelden true zurückgibt
    	assertTrue(studi.anmelden("PM-Dungeon"));
    }

    @Test
    public void testEinsichtI() {
    	//prüfe ob die gemockte Funktion ergebnis 51 zurückgibt
        assertTrue(studi.einsicht("PM-Dungeon"));
    }
    @Test
    public void testEinsichtII() {
    	//Wenn die Funktion ergebnis aufgerfufen wird gebe 50 zurück
        when(lsf.ergebnis("Harald", "PM-Dungeon")).thenReturn(50);
      //prüfe ob die gemockte Funktion ergebnis 50 zurückgibt
        assertFalse(studi.einsicht("PM-Dungeon"));
    }
}
