package teitelbaum.force2d;

public class Force2D
{
	private final double x;
	private final double y;

	public Force2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public double getMagnitude()
	{
		return Math.sqrt(x * x + y * y);
	}

	public double getAngle()
	{
		return Math.toDegrees(Math.atan2(y, x));
	}

	public Force2D add(Force2D f)
	{
		return new Force2D(x + f.x, y + f.y);
	}

	@Override
	public String toString()
	{
		return "Force2D vector (" + x + ", " + y + ") has a magnitude of " + getMagnitude() + " and an angle of " + getAngle();
	}
}
