import java.util.Scanner;

public class Tanker {

    public static void main(String[] args) {
        // Milk Tanker program
        /*  Here we have a milk tanker with a capacity of 5,000 litres that can
         *  continue to visit farms until it is full.  Each farm gives a random 
         *  quantity of milk, and the tanker can drive 500km until it needs to 
         *  return to the factory, or it will return to the factory if full and
         *  will not visit any more farms.  Each farm is located a random
         *  distance away from the previous one.  
        */
        
        /* Program is currently incomplete, does not consider distance driven
         * Also does not consider number of farms visited
        */
        
        // Random numbers can be generated using Math.random().  These have a 
        // range between 0 and 1, and can be multiplied
        // Math.random() will produce a random double between 0 and 1
        // (Math.random()*10) will produce a random double between 0 and 10
        // (Math.random()*100) will produce a random double between 0 and 100
        
        // Capacity and distance are initialised
        double capacity = 5000; // capacity of tanker
        final double range = 1000; // range of tanker
        
        
        final double distanceDriven =0;
        int farmsvisited = 0;
        
        
        // While capacity is greater than 0, i.e. there is still capacity
        while(capacity >0){
            // Add one to the number of farms visited
            farmsvisited = farmsvisited+1;
            
            // generate a random quality of milk
            double milkQuantity = (Math.random()*1000);
            // add the milk to the tanker
            capacity = capacity - milkQuantity;
            
            // if the tank is full, set to zero, cannot have negative capacity!
            if (capacity<0){
                capacity=0;
            }
            
            // Display infomration about the status
            System.out.println("Visiting Farm Number " + farmsvisited);
            System.out.println("Milk Produced =" + milkQuantity + " litres");
            System.out.println("Remaining capacity in tanker is " + capacity + " litres");
            
            // Add an empty line
            System.out.println();
            
            // If the tanker has remaining capacity, continue to next farm, 
            // else return to factory
            if (capacity>0){
                System.out.println("Moving on to next farm");
            } else {
                System.out.println("Returning to the factory");
            }
            
            // Add an empty line and some decoration
            System.out.println();
            System.out.println("----------------------------------");
          
        }
        
    
        
    }
}