import java.util.Scanner;

import java.util.Random;

public class DiceStats
{
    public static void main(String[] args) 
	{
        int NumberOfDevices;
        int NumberofRolls;

        int totalDiceSum;
        
        Scanner q = new Scanner(System.in);

        System.out.printf("How many devices will constitute one roll?");
 
        NumberOfDevices = q.nextInt();
        
        System.out.printf("How many rolls?");

        NumberofRolls = q.nextInt();

        totalDiceSum = NumberOfDevices * 6;

        int [] Randomizer;

        Randomizer = new int[totalDiceSum + 1];

        Random Mix = new Random();

        for(int i = 0; i < NumberofRolls; i++)
        {
            int RollTotal = 0;
            
            for(int j = 0; j < NumberOfDevices; j++)
            {
                RollTotal = RollTotal + (Mix.nextInt(6)+1);
            }

            Randomizer[RollTotal] = Randomizer[RollTotal] + 1;

        }

        System.out.println("Sum     # of times      Percentage");
        
        for(int i = NumberOfDevices; i < totalDiceSum + 1; i++)
        {
            System.out.printf("%-9d", i);
            System.out.printf("%-15d", Randomizer[i]);
            double column = Randomizer[i];
            double percent = ((column / NumberofRolls)*100.0);
            System.out.printf("%.2f", percent);
            System.out.println("%");
        }
        
        q.close();
    }
}
