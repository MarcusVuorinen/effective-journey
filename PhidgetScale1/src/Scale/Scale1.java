package Scale;
 
import com.phidget22.*;

public class Scale1 {
    public static void main(String[] args) throws Exception{

        //Create
        VoltageRatioInput scale = new VoltageRatioInput();
        double totaloffset = 0;
        double offset = 0;
        
        //Open
        scale.open(1000);
        
        
        
        
        for (int i = 0; i < 64; i++) 
        {
        	totaloffset += scale.getVoltageRatio();
        	offset = totaloffset/64;
        	System.out.println("Calculating Offset");
        	
        }
        
        //Use your Offset Value
        double offsetValue = offset;
        
        //Use your Phidgets
        while(true){

            //Calculate Weight (kg)
            double weight = 23514 * (scale.getVoltageRatio() - offsetValue);
            
            //Display Weight
            System.out.println(String.format("%.3f kg", weight));      
            
            Thread.sleep(250);
        }
    }    
}
