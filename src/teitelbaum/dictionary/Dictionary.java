package teitelbaum.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Dictionary
{
	private final Map<String, String> map;

	public Dictionary() throws FileNotFoundException
	{
		map = new HashMap<>();
		Scanner inputFile = new Scanner(new File("./OWL.txt"));
		while (inputFile.hasNext())
		{
			map.put(inputFile.next(), inputFile.nextLine());

		}
		inputFile.close();
	}

	public boolean exists(String word)
	{
		if (word == null)
		{
			return false;
		}
		else
		{
			return map.containsKey(word.toUpperCase());
		}
	}

	public Iterator<String> iterator()
	{
		return map.keySet().iterator();
	}

	public int size()
	{
		return map.size();
	}

	public String getDefinition(String word)
	{
		return map.get(word.toUpperCase());
	}
}
