package Smart;

import com.phidget22.*;

public class HotOrCold 
{
	
	public static void main(String[] args) throws Exception
	{
		
		 TemperatureSensor temperatureSensor = new TemperatureSensor();
		 
		 temperatureSensor.open(1000);
	     DigitalOutput redLED = new DigitalOutput();
	     DigitalOutput greenLED = new DigitalOutput();
	  
	     redLED.setHubPort(1);
	     redLED.setIsHubPortDevice(true);
	     greenLED.setHubPort(4);
	     greenLED.setIsHubPortDevice(true);
	     
	     
	     redLED.open(1000);
	     greenLED.open(1000);
		 
		 
		 if(temperatureSensor.getTemperature() > 20 && temperatureSensor.getTemperature() < 24) 
	        {
			 
			 greenLED.setState(true);
			 System.out.println("Temperature is " + temperatureSensor.getTemperature() + " °C" );
			 
	        }
		 
		 else 
		 {
			 redLED.setState(true);
			 System.out.println("Temperature is " + temperatureSensor.getTemperature() + " °C" );
		 }
	
	
		
		
		
		
		
		
		
		
		
}
}