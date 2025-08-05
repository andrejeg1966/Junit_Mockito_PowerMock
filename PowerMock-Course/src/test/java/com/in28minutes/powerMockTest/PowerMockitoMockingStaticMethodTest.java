package com.in28minutes.powerMockTest;



import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.in28minutes.powerMockSUT.SystemUnderTest;
import com.in28minutes.powerMockSUT.UtilityClass;
import com.in28minutes.powerMockSUT.*;
@RunWith(PowerMockRunner.class)
@PrepareForTest({ UtilityClass.class /*The class with static method to be mocked*/})
public class PowerMockitoMockingStaticMethodTest {

	@Mock
	Dependency dependencyMock;

	@InjectMocks
	SystemUnderTest systemUnderTest;

	@Test
	public void powerMockito_MockingAStaticMethodCall() {

		//Mockito for Array List
		when(dependencyMock.retrieveAllStats()).thenReturn(
				Arrays.asList(1, 2, 3));
		
		//PowerMock for static method
		PowerMockito.mockStatic(UtilityClass.class);
		when(UtilityClass.staticMethod(anyLong())).thenReturn(150);
		 //invoke the method
		assertEquals(150, systemUnderTest.methodCallingAStaticMethod());

		//To verify a specific method call
		//First : Call PowerMockito.verifyStatic() 
		//Second : Call the method to be verified
		PowerMockito.verifyStatic(null);
		UtilityClass.staticMethod(1 + 2 + 3);

		// verify exact number of calls
		//PowerMockito.verifyStatic(Mockito.times(1));

	}
}
