package dailyProgrammer;

import java.util.Scanner;

public class GameOfThrees {

	public static void main(String[] args) 
	{
		int entry;
		Scanner gimme = new Scanner(System.in);
		
		System.out.println("Gimme a number fool: ");
		entry = gimme.nextInt();
		
		do
		{
		if(entry/3 == (int)entry/3)
			entry = entry/3;
			System.out.println(entry + "	0");
		if(((entry+1)/3) == (int)((entry+1)/3))
			entry = (entry+1)/3;
			System.out.println(entry + "	1");
		if((entry-1)/3 == (int)(entry-1)/3)
			entry = (entry-1)/3;
			System.out.println(entry + "	-1");
		
		}while(entry != 1);
		
		System.out.println("1");
		
	}

}
