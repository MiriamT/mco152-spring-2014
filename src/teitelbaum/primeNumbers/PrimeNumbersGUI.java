package teitelbaum.primeNumbers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PrimeNumbersGUI extends JFrame implements Runnable, ActionListener
{
	private final JButton start;
	private final JTextArea primeText;
	private final JScrollPane scroll;

	public PrimeNumbersGUI()
	{
		setSize(600, 600);
		setTitle("Prime Numbers Calculator");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		start = new JButton("Start");
		start.addActionListener(this);
		add(start, BorderLayout.SOUTH);

		primeText = new JTextArea();
		scroll = new JScrollPane(primeText);
		add(scroll, BorderLayout.CENTER);

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
		boolean isPrime;
		for (int i = 2; i < 1000000000; i++)
		{
			isPrime = true;
			for (int j = 2; j < i; j++)
			{
				if (i % j == 0)
				{
					isPrime = false;
					break;
				}
			}
			if (isPrime)
			{
				primeText.setText(primeText.getText() + "\n" + i);
			}
		}
	}

	public static void main(String[] args)
	{
		PrimeNumbersGUI gui = new PrimeNumbersGUI();
		gui.setVisible(true);
	}
}