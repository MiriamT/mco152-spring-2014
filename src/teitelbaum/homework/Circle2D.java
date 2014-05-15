package teitelbaum.homework;

public class Circle2D
{
	private final double x;
	private final double y;
	private final double radius;

	public Circle2D()
	{
		this(0, 0, 1);
	}

	public Circle2D(double x, double y, double radius)
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double getX()
	{
		return x;
	}

	public double getY()
	{
		return y;
	}

	public double getRadius()
	{
		return radius;
	}

	public double getArea()
	{
		return radius * radius * Math.PI;
	}

	public double getPerimeter()
	{
		return 2 * radius * Math.PI;
	}

	public boolean contains(double x, double y) //Circle A contains a point if the distance from the center of the circle to the point is less than the radius of the Circle.
	{
		return distance(x, y) < radius;
	}

	public boolean contains(Circle2D c) //Circle A contains Circle B if the distance from the center of A to B plus the radius of Circle B is less than the radius of Circle A.
	{
		return distance(c.x, c.y) + c.radius < radius;
	}

	public boolean overlaps(Circle2D c) //Circle A overlaps Circle B if the distance from the center of A to B is less than the sum of the radius of Circle A plus the radius of Circle B
	{
		return distance(c.x, c.y) < (radius + c.radius);
	}

	public double distance(double x1, double y1)
	{
		return Math.sqrt((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y)); //put it back to this when done testing
	}
}
