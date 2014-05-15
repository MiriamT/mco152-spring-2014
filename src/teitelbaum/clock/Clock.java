package teitelbaum.clock;

import java.util.Calendar;

public class Clock
{
	private int hours;
	private int minutes;
	private int seconds;

	public Clock()
	{
		setTime();
	}

	public void setTime()
	{
		Calendar currentTime = Calendar.getInstance();
		hours = currentTime.get(Calendar.HOUR);
		minutes = currentTime.get(Calendar.MINUTE);
		seconds = currentTime.get(Calendar.SECOND);
	}

	public Clock(int hours, int minutes, int seconds)
	{
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public double getMinuteAngle()
	{
		return minutes * 6 + seconds * .1;
	}

	public double getHourAngle()
	{
		return hours * 30 + minutes * .5 + seconds * .0083;
	}

	public double getSecondsAngle()
	{
		return seconds * 6;
	}

	public void setTime(int hours, int minutes, int seconds)
	{
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public void increaseSeconds()
	{
		seconds++;
		if (seconds == 60)
		{
			seconds = 0;
			minutes++;
			if (minutes == 60)
			{
				minutes = 0;
				hours++;
				if (hours == 13)
				{
					hours = 1;
				}
			}
		}
	}

	public double getMinutes()
	{
		return minutes;
	}

	@Override
	public String toString()
	{
		return hours + ":" + minutes + ":" + seconds + " " + getHourAngle() + ":" + getMinuteAngle() + ":" + getSecondsAngle();
	}

}
