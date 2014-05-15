package teitelbaum.morseCode;

import java.util.Scanner;

public class MorseCodeOld 
{	
	private String[][] symbols = {{" ","/"}, {"0","-----"}, {"1", ".----"}, {"2", "..---"}, {"3", "...--"}, {"4", "....-"}, {"5", "....."}, {"6","-...."}, {"7","--..."}, {"8","---.."}, {"9","----."} };
	
	public String toMorseCode(String plainText)
	{
		if (plainText == null)
		{
			return null;
		}
		String text = plainText.toUpperCase();
		StringBuilder morseCode = new StringBuilder();
		String index = null;
		boolean found;
		for (int i = 0; i < text.length(); i++)
		{
			index = text.substring(i, i+1);
			found = false;
			MorseCodeAlphabet test = null;
			for (MorseCodeAlphabet letter : MorseCodeAlphabet.values())
			{
				try
				{
					test = MorseCodeAlphabet.valueOf(index);
				}
				catch (IllegalArgumentException e)
				{
					break; //should break from loop because index was not a valid MorseCodeAlphabet value
				}
				if (letter.equals(test))
				{
					morseCode.append(letter.getMorseCode()).append(" ");
					found = true;
					break;
				}
			}
			if (!found)
			{
				for (int j = 0; j < symbols.length; j++)
				{
					if (index.equals(symbols[j][0]))
					{
						morseCode.append(symbols[j][1]).append(" ");
						found = true;
					}
				}
			}
		//	if (!found)
		//	{
				//if still not found, then char is undefined. I am putting in a ? since thats what the site does for unknown char's
		//		morseCode.append("? ");
		//	}
		}
		return morseCode.toString().trim(); //gets rid of extra " " at end
	}
	
	public String toPlainText(String morseCode)
	{
		Scanner interpreter = new Scanner(morseCode);
		StringBuilder translation = new StringBuilder();
		String token = null;
		boolean found;
		
		while (interpreter.hasNext())
		{
			token = interpreter.next();
			found = false;
			
			for (MorseCodeAlphabet mca : MorseCodeAlphabet.values())
			{
				if (token.equals(mca.getMorseCode()))
				{
					translation.append(mca.toString());
					found = true;
					break;
				}
			}
			
			if (!found)
			{
				for (int i = 0; i < symbols.length; i++)
				{
					if (token.equals(symbols[i][1]))
					{
						translation.append(symbols[i][0]);
						found = true;
						break;
					}
				}
			}
			
			//if (!found)
			//{
				//if still not found, then char is undefined. I am putting in a ? to represent this
			//	translation.append("?");
			//}
		}
		interpreter.close();
		return translation.toString();
	}
	
	//*
	public static void main(String[] args)
	{
		MorseCodeOld mc = new MorseCodeOld();
		String test = mc.toMorseCode("?>+abcdefghijklmnopqrstuvwxyz");
		System.out.println(test);
		test = mc.toPlainText("? ------ ........... .- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.. / .---- ..--- ...-- ....- ..... -.... --... ---.. ----. -----");
		System.out.println(test);
	}
	//*/
}
