package teitelbaum.threads;

import java.math.BigInteger;

public class Factorial extends Thread
{
	private final long x;

	public Factorial(long x)
	{
		this.x = x;
	}

	public static BigInteger factorial(long x)
	{
		BigInteger result = BigInteger.valueOf(x);
		for (long i = 2; i < x; i++)
		{
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}

	@Override
	public void run()
	{
		super.run();
		System.out.println(factorial(x));
	}

}
