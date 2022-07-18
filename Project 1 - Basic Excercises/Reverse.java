import java.util.Scanner;

public class Reverse
{
	public static void main(String[] args) 
	{
		 
		 long userinput = 1;
		 long reverse = 0;
		 
		 Scanner q = new Scanner(System.in); // User Input
		 
		 
		 while(userinput != 0) // Loop for checking input and loop conditions
		 {
            System.out.printf("Please enter a long integer (0 to quit): ");
		    userinput = q.nextLong();
		    
		    if(userinput != 0) // Outputs Reverse Number
		    {
		        reverse = reverseFunct(userinput);
		        System.out.println("The number reversed is: " + reverse);
		    }
		 }
		 
		 System.out.println("Program Terminated!"); // Closing Program

		 
	}
	
	static long reverseFunct(long userinput) // Reverse Function
	{
        long reverse = 0;
        
        while(userinput != 0)
        {
        reverse = reverse * 10;
		reverse = reverse + userinput % 10;
		userinput = userinput / 10;
        }
        
        return reverse;
	}
	 
}
