package com.sensor;

public class StubSensor implements Sensierbar{
	 
	Double offsetTemperature = 0.0;
	 public void setOffsetTemperature(Double temp){
	      this.offsetTemperature = temp;
	 }
	
	public Double getTemperatur(){
        return 13.45;
    }    
}
