package com.studi.mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import com.studi.LSF;
import com.studi.Studi;

/*
Mit InOrder lassen sich Aufrufe auf einem Mock/Spy oder auch auf verschiedenen Mocks/Spies 
in eine zeitliche Reihenfolge bringen und so überprüfen.
 */
public class VerifyTest2 {
	@Test
    public void testAnmelden() {
		LSF lsf = mock(LSF.class);
		Studi studi = new Studi("Harald", lsf);

		when(lsf.anmelden("Harald", "PM-Dungeon")).thenReturn(true);

		InOrder inOrder = Mockito.inOrder(lsf);

		assertTrue(studi.anmelden("PM-Dungeon"));
		studi.anmelden("Wuppie");

		inOrder.verify(lsf).anmelden("Harald", "PM-Dungeon");
		inOrder.verify(lsf).anmelden("Harald", "Wuppie");
		
    }
}

