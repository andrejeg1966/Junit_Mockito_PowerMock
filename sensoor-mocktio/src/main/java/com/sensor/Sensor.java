package com.sensor;

import java.util.Random;
public class Sensor implements Sensierbar{
	
	 Double offsetTemperature = 0.0;
	 public void setOffsetTemperature(Double temp){
	      this.offsetTemperature = temp;
	 }

	public Double getTemperatur(){
        // normalverteilte Zufallszahl als Pseudotemperatur
        return new Random().nextGaussian(10, 10);
}   } 
