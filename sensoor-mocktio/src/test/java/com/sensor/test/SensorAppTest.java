package com.sensor.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sensor.*;

public class SensorAppTest {

	@Test
	public void testManualStubGetInterpretedTemperature() {
	    /* given: Preparation */
		SensorApp myApp = new SensorApp();                  // Instanz der zu testenden Klasse wird erzeugt
	    Sensierbar stubSensor = new StubSensor();  			// Instanz des Stubsensors
	    myApp.setTempSensor(stubSensor);           			// Injezierung des StubSensors

	    /* when: Execution */
	    String result = myApp.getInterpretedTemperature();
	                                              			// der Wert des Stubs wird zurückgegeben: 13.45

	    /* then: Verification */
	    String expected = "It's ok";            			//gemäß Anforderungen werden 13°C als ok gewertet
	    assertEquals(expected, result);           			//Aufruf der Zusicherungsmethode
	}
}
