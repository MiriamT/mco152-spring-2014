package teitelbaum.clock;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

//reference for the angle conversions: http://en.wikipedia.org/wiki/Polar_coordinate_system

public class ClockComponent extends JComponent
{
	private final Clock clock;

	public ClockComponent()
	{
		clock = new Clock();
	}

	@Override
	public void paintComponent(Graphics g)
	{
		int width = getWidth();
		int height = getHeight();
		paintFrame(g, width, height);
		paintFace(g, width, height);

		clock.setTime(); //update to current time
		int centerX = width / 2;
		int centerY = height / 2;
		Graphics2D g2 = (Graphics2D) g;

		paintHourHand(centerX, centerY, g2);
		paintMinuteHand(g, width, height, centerX, centerY, g2);
		paintSecondHand(width, height, centerX, centerY, g2);
		paintNose(g, width, height);
	}

	private void paintNose(Graphics g, int width, int height)
	{
		g.setColor(Color.BLACK);
		g.fillOval(width / 2 - (int) (width * .04 / 2), height / 2 - (int) (height * .04 / 2), (int) (width * .04), (int) (height * .04));
	}

	private void paintSecondHand(int width, int height, int centerX, int centerY, Graphics2D g2)
	{
		double angle = convertAngle(clock.getSecondsAngle());
		double handLengthW = width * .45;
		double handLengthH = height * .45;
		int x2 = (int) (handLengthW * Math.cos(angle));
		int y2 = (int) (handLengthH * Math.sin(angle));

		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.RED);
		g2.draw(new Line2D.Float(centerX, centerY, centerX - x2, centerY - y2));
	}

	private void paintMinuteHand(Graphics g, int width, int height, int centerX, int centerY, Graphics2D g2)
	{
		double angle = convertAngle(clock.getMinuteAngle());
		double handLengthW = width * .35;
		double handLengthH = height * .35;
		int x2 = (int) (handLengthW * Math.cos(angle));
		int y2 = (int) (handLengthH * Math.sin(angle));

		g2.setStroke(new BasicStroke(5));
		g.setColor(Color.BLUE);
		g2.draw(new Line2D.Float(centerX, centerY, centerX - x2, centerY - y2));
	}

	private void paintFace(Graphics g, int width, int height)
	{
		g.setColor(Color.WHITE);
		g.fillOval((int) (height * .02), (int) (height * .02), (int) (width - width * .04), (int) (height - width * .04));
	}

	private void paintFrame(Graphics g, int width, int height)
	{
		g.fillOval(0, 0, width, height);
	}

	private void paintHourHand(int startX, int startY, Graphics2D g2)
	{
		double angle = convertAngle(clock.getHourAngle());
		double handLengthW = getWidth() * .25;
		double handLengthH = getHeight() * .25;
		int x2 = (int) (handLengthW * Math.cos(angle));
		int y2 = (int) (handLengthH * Math.sin(angle));

		g2.setStroke(new BasicStroke(7));
		g2.setColor(Color.CYAN);
		g2.draw(new Line2D.Float(startX, startY, startX - x2, startY - y2));
	}

	private double convertAngle(double angle)
	{
		//account for coordinate plane 0 vs 0 as vertical line
		angle = (angle + 90) % 360;
		//convert angle to radians
		angle = angle * Math.PI / 180;
		return angle;
	}
}
