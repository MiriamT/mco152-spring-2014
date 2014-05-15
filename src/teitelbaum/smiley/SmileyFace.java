package teitelbaum.smiley;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileyFace extends JComponent
{
	@Override
	public void paintComponent(Graphics g)
	{
		//g.drawLine(0, 0, this.getWidth(), this.getHeight());
		//g.drawLine(0, getHeight(), getWidth(), 0);

		g.setColor(Color.YELLOW);
		g.fillOval(getWidth() / 2 - 50, getHeight() / 2 - 50, 100, 100); //-50 because need to offset to center the circle

		g.setColor(Color.BLACK);
		g.fillOval(getWidth() / 2 - 25, getHeight() / 2 - 15, 10, 10);
		g.fillOval(getWidth() / 2 + 15, getHeight() / 2 - 15, 10, 10);
		g.drawArc(getWidth() / 2 - 35, getHeight() / 2 - 75, 70, 100, -40, -100);
	}
}
