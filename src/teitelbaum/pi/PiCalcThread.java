package teitelbaum.pi;

import javax.swing.JTextArea;

public class PiCalcThread extends Thread
{
	private final JTextArea piText;

	public PiCalcThread(JTextArea area)
	{
		piText = area;
	}

	@Override
	public void run()
	{
		double pi = 0;
		for (int i = 1; i < 1000000000; i++)
		{
			pi += 4 * Math.pow(-1, i + 1) / (2 * i - 1);
			piText.setText(String.valueOf(pi));
		}
	}
}
