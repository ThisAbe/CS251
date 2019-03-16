package dailyProgrammer;

import java.util.Scanner;


public class AlphaCipher {

	public static void main(String[] args)
	{
		char[][] Alpha = generateArray();
		
		String codeWord;
		String codeMsg;
		Scanner codeW = new Scanner(System.in);
		Scanner message = new Scanner(System.in);
		
		System.out.println("Enter memorized word: ");
		codeWord = codeW.next();
		System.out.println("Enter message(no spaces): ");
		codeMsg = message.next();
		
		int codeLen = codeWord.length();
		int msgLen = codeMsg.length();
		
		String repeated = new String(new char[codeMsg.length()/codeWord.length()]).replace("\0", codeWord);
		
		if(repeated.length() < codeMsg.length())
		{
			int temp;
			temp = codeMsg.length() - repeated.length();
			repeated = repeated + codeWord.substring(0,temp);
		}
		
		System.out.println("	" + repeated);
		System.out.println("	" + codeMsg);
		
		for(int i=0;i<codeMsg.length();i++)
		{
			System.out.print(Alpha[convert(repeated.charAt(i))][convert(codeMsg.charAt(i))]);
		}
			
		
		
		
	

	}
	
	public static char[][] generateArray() 
	{
		char alphaArr[][] = new char[26][26];
		for(int i = 0; i < 26; i++)
		{
			for(int j = 0; j < 26; j++)
			{
				int lett = i + j;
				
				if(lett >= 26)
					lett = lett - 26;
				
				lett = lett + 65;
				
				char letter = (char)lett;
				
				alphaArr[i][j] = letter;
			}
		}
		return alphaArr;
		
	}
	
	public static int convert(char a)
	{
		int i = 0;
		char[] array = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for(int j=0; j < 26; j++)
		{
			if(array[j] == a)
				i = j;
			
		}
		return i;
		
	}

}
