package teitelbaum.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class StatisticsOfOWL 
{
	public static void main(String[] args)
	{
		int numWords = 0;
		ArrayList<Alpha> usedLetters;
		int[] timesUsed = new int[26];
		double[] numWordsUsed = new double[26];

		try {
			Scanner inputFile = new Scanner (new File("./OWL.txt"));
			while (inputFile.hasNext()) //process word
			{
				usedLetters = new ArrayList<Alpha>();
				String word = inputFile.next();
				String letter;
				Alpha alpha;
				for (int i = 0; i < word.length(); i++) //process letters in word
				{
					letter = word.substring(i, i+1);
					alpha = Alpha.valueOf(letter);
					timesUsed[alpha.ordinal()]++;
					if (!usedLetters.contains(alpha))
					{
						numWordsUsed[alpha.ordinal()]++;
						usedLetters.add(alpha);
					}
				}
				numWords++;
				inputFile.nextLine();
			}
			inputFile.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//print output
		DecimalFormat df = new DecimalFormat("#0.00");
		for (Alpha a : Alpha.values())
		{
			System.out.print(a + "\t");
			System.out.print(timesUsed[a.ordinal()] + "\t");
			double percent = numWordsUsed[a.ordinal()] / numWords * 100;
			System.out.println(df.format(percent) + "%");
			//System.out.println(String.format("%.2f", percent) + "%");
			//System.out.println(numWordsUsed[a.ordinal()] + " " + numWords + " " + percent); //TEST
		}
	}
}
