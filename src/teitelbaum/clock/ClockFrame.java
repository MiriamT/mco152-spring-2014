package teitelbaum.clock;

import javax.swing.JFrame;

public class ClockFrame extends JFrame
{
	private final ClockComponent clockComponent;

	public ClockFrame()
	{
		setSize(600, 600);
		setTitle("Clock");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		clockComponent = new ClockComponent();
		add(clockComponent);
		AnimateClockThread animation = new AnimateClockThread(clockComponent);
		animation.start();
	}

	public static void main(String[] args)
	{
		ClockFrame c = new ClockFrame();
		c.setVisible(true);
	}
}
