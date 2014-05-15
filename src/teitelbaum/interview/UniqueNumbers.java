package teitelbaum.interview;

import java.util.HashMap;
import java.util.Scanner;

public class UniqueNumbers
{
	public static void main(String[] args)
	{
		System.out.println("Enter 10 numbers:");
		HashMap<Integer, Integer> map = new HashMap<>();
		Scanner kb = new Scanner(System.in);
		for (int i = 0; i < 10; i++)
		{
			Integer num = kb.nextInt();
			if (!map.containsKey(num))
			{
				map.put(num, 1);
			}
			else
			{
				map.put(num, map.get(num) + 1);
			}
		}
		System.out.println("All numbers, and how many times each was entered:");
		{
			for (Integer i : map.keySet())
			{
				System.out.println(i + " " + map.get(i));
			}
		}
	}
}
