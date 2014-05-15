package teitelbaum.pi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class PiGUI extends JFrame implements Runnable, ActionListener
{
	private final JButton start;
	private final JTextArea piText;

	public PiGUI()
	{
		setSize(600, 600);
		setTitle("Pi Calculator");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		start = new JButton("Start");
		start.addActionListener(this);
		add(start, BorderLayout.SOUTH);

		piText = new JTextArea();
		add(piText, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Thread t = new Thread(this);
		t.start();
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

	public static void main(String[] args)
	{
		PiGUI p = new PiGUI();
		p.setVisible(true);
	}
}
