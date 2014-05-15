package teitelbaum.morseCode;

import java.util.HashMap;
import java.util.Scanner;

public class MorseCode
{
	private final HashMap<String, String> map; //using only 1 map because <String, String> and key and value both Strings

	public MorseCode()
	{
		map = new HashMap<>();

		String[][] symbols =
		{
		{ " ", "/" },
		{ "0", "-----" },
		{ "1", ".----" },
		{ "2", "..---" },
		{ "3", "...--" },
		{ "4", "....-" },
		{ "5", "....." },
		{ "6", "-...." },
		{ "7", "--..." },
		{ "8", "---.." },
		{ "9", "----." } };

		for (String[] s : symbols)
		{
			map.put(s[0], s[1]);
			map.put(s[1], s[0]);
		}

		for (MorseCodeAlphabet a : MorseCodeAlphabet.values())
		{
			map.put(a.toString(), a.getMorseCode());
			map.put(a.getMorseCode(), a.toString());
		}
	}

	public String toMorseCode(String plainText)
	{
		if (plainText == null)
		{
			return null;
		}

		String text = plainText.toUpperCase();
		StringBuilder morseCode = new StringBuilder();
		String index;

		for (int i = 0; i < text.length(); i++)
		{
			index = text.substring(i, i + 1);
			if (map.containsKey(index))
			{
				morseCode.append(map.get(index)).append(" ");
			}
		}
		return morseCode.toString().trim(); //gets rid of extra " " at end
	}

	public String toPlainText(String morseCode)
	{
		Scanner interpreter = new Scanner(morseCode);
		StringBuilder translation = new StringBuilder();
		String token;

		while (interpreter.hasNext())
		{
			token = interpreter.next();
			if (map.containsKey(token))
			{
				translation.append(map.get(token));
			}
		}
		interpreter.close();
		return translation.toString();
	}
}
