package teitelbaum.triangle;

public class Triangle 
{
	private int height;
	
	public Triangle(int height)
	{
		this.height = height;
	}
	
	public String toString()
	{
		StringBuilder triangle = new StringBuilder();
		
		int row = 0;
		int outerSpaces = row;
		int innerSpaces = 0;
		while (row < height-1) //last row is special so stop before it
		{
			//print outer spaces
			while (height-1 - outerSpaces > 0)
				{
					triangle.append(" ");
					outerSpaces++;
				}
			triangle.append("*"); //now can add 1st star
			
			//print inner spaces
			while (innerSpaces > 0)
			{
				triangle.append(" ");
				innerSpaces--;
			}
			
			if (row != 0) //first row only gets 1 star
			{
				triangle.append("*"); //add second star
			}
			
			triangle.append("\n"); //end row
			row++;
			outerSpaces = row;
			innerSpaces = 1 + (row-1) * 2;
		}
		
		//last row
		for (int i = height * 2 - 1; i > 0; i--)
		{
			triangle.append("*");
		}
		
		return triangle.toString();
	}
	
	/*
	public static void main(String[] args)
	{
		System.out.println(new Triangle(-1));
		System.out.println(new Triangle(0));
		System.out.println(new Triangle(1));
		System.out.println(new Triangle(3));
		System.out.println(new Triangle(6));
		System.out.println(new Triangle(10));
		System.out.println(new Triangle(30));
		
	}
	*/
	
}
