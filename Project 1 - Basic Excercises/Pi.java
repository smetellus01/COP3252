import java.util.Scanner;

public class Pi
{
	public static void main(String[] args) 
	{
       double pi = 4.0;
       int user = 0;

       Scanner q = new Scanner(System.in);

	   System.out.printf("Compute how many terms of the series? ");

		user = q.nextInt();

        for(int i = 1; i <= user; i++)
       {
           int temp = 1; 
           
            if(i % 2 == 0)
            {
               temp = -1;
            }
            if(i == 1)
            {
                pi = 4;
            }
            else
            {
                pi = pi + ((4.0/((2*i) - 1)) * temp);
            }

            System.out.printf("%-8d",i);
            System.out.println(pi);
       }
    }
}


