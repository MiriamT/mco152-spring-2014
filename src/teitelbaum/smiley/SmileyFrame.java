package teitelbaum.smiley;

import javax.swing.JFrame;

public class SmileyFrame extends JFrame
{
	public SmileyFrame()
	{
		setSize(800, 600);
		setTitle("Smiley Face");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLayout(new BorderLayout());
		//add(new SmileyFace(), BorderLayout.CENTER);
		add(new SmileyFace());
		//dont set visible in constructor - do it in main

	}

	public static void main(String[] args)
	{
		SmileyFrame s = new SmileyFrame();
		s.setVisible(true);

	}
}
