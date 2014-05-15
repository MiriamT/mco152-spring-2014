package teitelbaum.pi;

public class PiCalculator
{
	private double pi;

	public static void main(String[] args)
	{
		double pi = 1;
		for (int i = 2; i < 1000000000; i++)
		{
			pi += (Math.pow(-1, i + 1) / (2 * i - 1));
		}
		pi *= 4;
		System.out.println(pi);
	}
}
