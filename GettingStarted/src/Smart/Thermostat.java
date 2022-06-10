package Smart;

import com.phidget22.*;

public class Thermostat 
{
	 public static void main(String[] args) throws Exception
	 {
	        
	        //Create | Here you've created a DigitalInput object for your button. An object represents how you interact with your device. DigitalInput is a class from the Phidgets library that's used to read the state of your button.
	        DigitalInput greenButton = new DigitalInput();
	        DigitalInput redButton = new DigitalInput();
	        TemperatureSensor temperatureSensor = new TemperatureSensor();
	        DigitalOutput greenLED = new DigitalOutput();
	        DigitalOutput redLED = new DigitalOutput();
	        temperatureSensor.open(1000); 
	        
	        int setTemp = 27;

	        //Address | This tells your program where to find the device you want to work with. Your button is connected to port 0 and your code reflects that. IsHubPortDevice must be set if you are not using a Smart Phidget (more on this later).
	        greenButton.setHubPort(5);
	        greenButton.setIsHubPortDevice(true);
	        redLED.setHubPort(1);
	        redLED.setIsHubPortDevice(true);

	        //Open | Open establishes a connection between your object and your physical Phidget. You provide a timeout value of 1000 to give the program 1000 milliseconds (1 second) to locate your Phidget. If your Phidget can't be found, an exception will be thrown.
	        greenButton.open(5000);
	        greenLED.setHubPort(4);
	        greenLED.setIsHubPortDevice(true);
	        
	        //Address | This tells your program where to find the device you want to work with. Your button is connected to port 0 and your code reflects that. IsHubPortDevice must be set if you are not using a Smart Phidget (more on this later).
	        redButton.setHubPort(0);
	        redButton.setIsHubPortDevice(true);

	        //Open | Open establishes a connection between your object and your physical Phidget. You provide a timeout value of 1000 to give the program 1000 milliseconds (1 second) to locate your Phidget. If your Phidget can't be found, an exception will be thrown.
	        redButton.open(5000);
	        //Open | Connect your program to your physical devices.
	        redButton.open(1000);
	        redLED.open(1000);
	        greenButton.open(1000);
	        greenLED.open(1000);
	        
	        boolean buttonState = false;

	        //Use your Phidgets | Here is where you use your Phidgets! This code checks the state of the button and prints true/false when the button is pressed/released. The sleep function means the button state is only checked every 150 milliseconds. Sleeping is used to make it easier to read the console output and to put less stress on your CPU.
	        while(true)
	        {
	        	
	        	if(greenButton.getState() && !buttonState)
	        	{
	        		setTemp += 1;
	        	}
	        	if(redButton.getState() && !buttonState)
	        	{
	        		setTemp -= 1;
	        	}
	        		
	            buttonState = greenButton.getState();
	            Thread.sleep(150);
	            System.out.println("Temperature: " + temperatureSensor.getTemperature() + " °C" );
	            System.out.println( "The  Set Temperature is:  " + setTemp);

	            
	            
	            
	            
	            
		        if (((temperatureSensor.getTemperature() - setTemp) <= 2) && ((setTemp - temperatureSensor.getTemperature()) <= 2))  
		        {
		        	
		        	
		        	greenLED.setState(true);
		        	redLED.setState(false);

		        }
		        
		        else
		        {
		        	
		        	redLED.setState(true);
		        	greenLED.setState(false);
		        	
		        	
		        	
		        }
		        
	        }
	 }
	 
}