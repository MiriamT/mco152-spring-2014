package teitelbaum.threads;

public class FactorialThreads
{

	public static void main(String[] args)
	{
		Thread t1 = new Factorial(500);
		Thread t2 = new Factorial(20);

		t1.start();
		t2.start();
	}
}
