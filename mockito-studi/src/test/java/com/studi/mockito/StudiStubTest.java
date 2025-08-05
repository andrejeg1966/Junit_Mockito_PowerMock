package com.studi.mockito;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.studi.*;
public class StudiStubTest {
	
    Studi studi_true;  
    LSF lsf_true;
    Studi studi_false;  
    LSF lsf_false;
   

    @Before
    public void setUp() { 
    	lsf_true = new LsfStub_true();
    	lsf_false = new LsfStub_false();

    	studi_true = new Studi("Harald", lsf_true);
    	studi_false = new Studi("Hans", lsf_false);
    }

    @Test
    public void testAnmelden_true() { 
    	assertTrue(studi_true.anmelden("PM-Dungeon")); 
    }
    
    @Test
    public void testEinsicht_true() { 
    	assertTrue(studi_true.einsicht("PM-Dungeon"));
    }
    
    @Test
    public void testAnmelden_false() { 
    	assertFalse(studi_false.anmelden("PM-Dungeon")); 
    }
    
    @Test
    public void testEinsicht_false() { 
    	assertFalse(studi_false.einsicht("PM-Dungeon"));
    }
    

    // Stubs für das noch nicht fertige LSF
    class LsfStub_true extends LSF {
        public boolean anmelden(String name, String modul) { 
        	return true; 
        }
        public int ergebnis(String name, String modul) { 
        	return 51; 
        }
    }
    
    class LsfStub_false extends LSF {
        public boolean anmelden(String name, String modul) { 
        return false; }
        public int ergebnis(String name, String modul) { 
        	return 50; 
        }
    }
    
   
    
}
