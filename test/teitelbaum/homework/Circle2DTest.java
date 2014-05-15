package teitelbaum.homework;

import org.junit.Assert;
import org.junit.Test;

public class Circle2DTest {
	
	@Test
	public void testArea() 
	{
		Circle2D c = new Circle2D(2, 2, 5.5); 
		double area = c.getArea();
		double expected = 95.03317777109125;
		
		Assert.assertEquals(expected, area, .001);
	}

	@Test
	public void testPerimeter() 
	{
		Circle2D c = new Circle2D(2, 2, 5.5); 
		double perimeter = c.getPerimeter();
		double expected = 34.55751918948772;
		
		Assert.assertEquals(expected, perimeter, .001);
		
	}

	@Test
	public void testContainsPoint() 
	{
		Circle2D c = new Circle2D(2, 2, 5.5); 
		boolean contains = c.contains(3, 3);
		
		Assert.assertTrue(contains);
	}

	@Test
	public void testContainsCircle() 
	{
		Circle2D c = new Circle2D(2, 2, 5.5); 
		boolean contains = c.contains(new Circle2D(4, 5, 10.5));
		
		Assert.assertFalse(contains);
	}

	@Test
	public void testOverlaps() 
	{
		Circle2D c = new Circle2D(2, 2, 5.5); 
		boolean overlaps = c.overlaps(new Circle2D(3, 5, 2.3));
		
		Assert.assertTrue(overlaps);
	}
}
