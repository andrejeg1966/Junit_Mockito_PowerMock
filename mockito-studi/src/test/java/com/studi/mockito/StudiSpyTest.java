package com.studi.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.Before;
import org.junit.Test;

import com.studi.LSF;
import com.studi.Studi;

public class StudiSpyTest {
    Studi studi;  
    LSF lsf;

    @Before
    public void setUp() { 
    	lsf = spy(LSF.class);  
    	studi = new Studi("Harald", lsf); 
    }

    @Test
    public void testAnmelden() { 
    	//Unterschied zu Mocking, hier wird die echte Methode anmelden von LSF aufgerufen
    	assertTrue(studi.anmelden("PM-Dungeon")); 
    }

    @Test
    public void testEinsichtI() {
    	//nutze einen eigenen Rückgabewertbeim Aufruf der Methode
        doReturn(80).when(lsf).ergebnis("Harald", "PM-Dungeon");
        assertTrue(studi.einsicht("PM-Dungeon"));
    }
    @Test
    public void testEinsichtII() {
        doReturn(40).when(lsf).ergebnis("Harald", "PM-Dungeon");
        assertFalse(studi.einsicht("PM-Dungeon"));
    }
}
