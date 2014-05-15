package teitelbaum.clock;

public class AnimateClockThread extends Thread
{
	private ClockComponent clockComponent;
	
	public AnimateClockThread(ClockComponent clockComponent)
	{
		this.clockComponent = clockComponent;
	}

	@Override 
	public void run()
	{
		for (;;)
		{
			clockComponent.repaint();
			try
			{
				sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
