package teitelbaum.maxSum;

import java.util.Scanner;

public class MaxSum
{
	private int[][] array;
	private int size;
	
	public MaxSum(Scanner s)
	{
		size = s.nextInt();
		s.nextLine();
		array = new int[size][size];
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				array[i][j] = s.nextInt();
			}
		}
		s.close();
	}

	public int getSumMaxRect()
	{
		int max = array[0][0];
		int sum;

		for (int height = 0; height < size; height++) //controls height of rectangle
		{
			for (int length = 0; length < size; length++) //controls length of rectangle
			{
				for (int i = 0; i < size - height; i++) //shifts rectangle down
				{
					for (int j = 0; j < size - length; j++) //shifts rectangle right
					{
						sum = 0;
						for (int a = height; a >= 0; a--) //checks each rectangle's sum
						{
							for (int b = length; b >= 0; b--)
							{
								sum += array[a + i][b + j]; //adds the displacement to each position
							}
						}
						if (sum > max)
						{
							max = sum;
						}
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args)
	{
		MaxSum m = new MaxSum(new Scanner(System.in));
		System.out.println(m.getSumMaxRect());
	}
}
