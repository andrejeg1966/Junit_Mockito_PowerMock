package com.sensor;

public class SensorApp {
	
	Sensierbar tempSensor;
	//falls jemand die Zeile  Double temp = tempSensor.getTemperatur(); überschreibt. 
	Double cachedTemp;
	
	public SensorApp(){
		//Referenzen in der App von konkret (Sensor) auf abstrakt (Sensierbar) ändern (das Dependency Inversion Prinzip, DIP, umsetzen)
        tempSensor = (Sensierbar) new Sensor();
      //falls jemand die Zeile  Double temp = tempSensor.getTemperatur(); überschreibt, z.B setzt Double temp = 15; 
        cachedTemp = -Double.MAX_VALUE;
    }
	public String getInterpretedTemperature(){
		
		/*Realer Objekt ohne Sensierbar interface
        Sensor tempSensor = new Sensor();
        */
		
		/*
		 * //falls die Zeile  Double temp = tempSensor.getTemperatur(); nicht überschreibt wird
        Double temp = tempSensor.getTemperatur();
        */
		
		Double temp;
        if (cachedTemp != -Double.MAX_VALUE){
            temp = cachedTemp;
        }else{
        	tempSensor.setOffsetTemperature(0.0);
        	//falls jemand die Zeile  Double temp = tempSensor.getTemperatur(); überschreibt, z.B setzt Double temp = 15; 
            temp = tempSensor.getTemperatur();
            cachedTemp = temp;
        }
        String interpretedTemperature = "";
        System.out.println("Interpretierter Wert: "+temp.toString());
        if (temp<0){
        	interpretedTemperature = "It's very cold";
        }else if (temp<10){
        	interpretedTemperature = "It's cold";
        }else if (temp<20){
        	interpretedTemperature = "It's ok";
        }else if (temp<30){
        	interpretedTemperature = "It's warm";
        }else {interpretedTemperature = "It's hot";
        }
        return interpretedTemperature;
    }
	
	public void setTempSensor(Sensierbar mySensor){
        this.tempSensor = mySensor;
    }

}
