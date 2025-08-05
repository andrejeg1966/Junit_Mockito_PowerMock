package com.sensor.test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import com.sensor.*;

public class SensorAppMockito {
/*
	@Test()
	public void testGetInterpretedTemperature() {
        /// given: Preparation 
        SensorApp myApp = new SensorApp();
        Sensor mockSensor = mock(Sensor.class);
        when(mockSensor.getTemperatur()).thenReturn(12.345); // Use mock as stub
        myApp.setTempSensor(mockSensor);
        
        // when: Execution
        String result = myApp.getInterpretedTemperature();
        //prüfen, ob die Methode des Mock-Objekts im Rahmen des Tests wirklich aufgerufen wurde (das einfachste Verhalten). 
        verify(mockSensor).getTemperatur();


        // then: Verification 
        String expected = "It's ok";
        assertEquals(expected, result);

	}
*/
	@Test
	public void testCachedGetInterpretedTemperature() {
	    /* given: Preparation */
		SensorApp myApp = new SensorApp();
	    Sensor mockSensor = mock(Sensor.class);
	    when(mockSensor.getTemperatur()).thenReturn(12.345); // Use mock as stub
	    
	    //myApp.getInterpretedTemperature();
	    myApp.setTempSensor(mockSensor);
        /* when: Execution */
        String result = myApp.getInterpretedTemperature();
        String result2 = myApp.getInterpretedTemperature();

        /* then: Verification */
        String expected = "It's ok";
        assertEquals(expected, result);
        assertEquals(expected, result2);
        
        //ob der Setter (überhaupt) mit einem beliebigen Double-Wert (anyDouble()) aufgerufen wurde,
        verify(mockSensor).setOffsetTemperature(anyDouble());
        //ob der .getTemperatur(); (überhaupt) aufgerufen wurde,
        verify(mockSensor).getTemperatur();
        verify(mockSensor, times(1)).getTemperatur();
        verifyNoMoreInteractions(mockSensor);
        
        InOrder inOrder = Mockito.inOrder(mockSensor, mockSensor);
        //prüfen ob zuesrt setOffsetTemperature() in getInterpretedTemperature() aufgerufen wurde
        inOrder.verify(mockSensor).setOffsetTemperature(anyDouble());
        //prüfen ob  getTemperatur() danach in getInterpretedTemperature() aufgerufen wurde
        inOrder.verify(mockSensor).getTemperatur();
       
        verifyNoMoreInteractions(mockSensor);
	}
}
