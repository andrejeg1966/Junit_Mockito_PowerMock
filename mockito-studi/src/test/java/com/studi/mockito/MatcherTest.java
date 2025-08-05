package com.studi.mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.ArgumentMatcher;

import com.studi.LSF;
import com.studi.Studi;

public class MatcherTest {
	 @Test
	    public void testAnmelden() {
	        LSF lsf = mock(LSF.class);  
	        Studi studi = new Studi("Harald", lsf);

	        when(lsf.anmelden(anyString(), anyString())).thenReturn(false);
	        when(lsf.anmelden("Harald", "PM-Dungeon")).thenReturn(true);

	        assertTrue(studi.anmelden("PM-Dungeon"));
	        assertFalse(studi.anmelden("Wuppie?"));

	        verify(lsf, times(1)).anmelden("Harald", "PM-Dungeon");
	        verify(lsf, times(1)).anmelden("Harald", "Wuppie?");

	        verify(lsf, times(2)).anmelden(anyString(), anyString());
	        verify(lsf, times(1)).anmelden(eq("Harald"), eq("Wuppie?"));
	        verify(lsf, times(2)).anmelden(argThat(new MyHaraldMatcher()), anyString());
	    }


	    class MyHaraldMatcher implements ArgumentMatcher<String> {
	        public boolean matches(String s) { return s.equals("Harald"); }
	    }

}
