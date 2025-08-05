package com.powerMockTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.powerMockSUT.Service;

//import junit.framework.Assert;

@RunWith(PowerMockRunner.class)
// For example, in the given declaration, PowerMockito will prepare all classes within the specified package for mocking.
@PrepareForTest(fullyQualifiedNames = "com.powerMockSUT.*")
//@PrepareForTest( { Service.class })
public class ServiceTest {
	
	@Test
	public void mockStaticMethodTest() {
		  //Mock static methods
		 PowerMockito.mockStatic(Service.class);

		  //Set expectation
		  Mockito.when(Service.staticMessage()).thenReturn("New Message from Mock!");

		  //invoke the method
		  String message = Service.staticMessage();

		  //Assert the stub response
		  assertEquals(message, "New Message from Mock!");
		}

	@Test
	  public void mockPrivateMethodTest() throws Exception {

	    Service mock = PowerMockito.spy(new Service());
	    PowerMockito.doReturn("New Message from Mock!").when(mock,"privateMessage");

	    String privateMessage = Whitebox.invokeMethod(mock, "privateMessage");
	    
	    assertEquals(privateMessage, "New Message from Mock!");
	  }
	
	 @Test
	  public void mockFinalMethodTest() {
	    //Mock final method
	    Service serviceMock = PowerMockito.mock(Service.class);

	    //Set expectation
	    Mockito.when(serviceMock.finalMessage()).thenReturn("New Message from Mock!");

	    //invoke the method
	    String message = serviceMock.finalMessage();

	    //Assert the stub response
	    assertEquals(message, "New Message from Mock!");
	  }
	  
}
