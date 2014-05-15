package teitelbaum.force2d;

import org.junit.Assert;
import org.junit.Test;

public class Force2DTest 
{
	@Test
	public void testMagnitude()
	{
		Force2D f = new Force2D(2, 5);
		double mag = f.getMagnitude();
		double expected = 5.3852;
		Assert.assertEquals(expected, mag, .01);
		
		Force2D f2 = new Force2D(4, 3);
		mag = f2.getMagnitude();
		expected = 5;
		Assert.assertEquals(expected, mag, .01);
		
		Force2D f3 = new Force2D(-1, -5);
		mag = f3.getMagnitude();
		expected = 5.099;
		Assert.assertEquals(expected, mag, .01);
	}
	
	@Test
	public void testAngle()
	{
		Force2D f = new Force2D(2, 5);
		double ang = f.getAngle();
		double expected = 68.199;
		Assert.assertEquals(expected, ang, .01);
		
		Force2D f2 = new Force2D(4, 3);
		ang = f2.getAngle();
		expected = 36.87;
		Assert.assertEquals(expected, ang, .01);
		
		Force2D f3 = new Force2D(-1, -5);
		ang = f3.getAngle();
		expected = -101.31;
		Assert.assertEquals(expected, ang, .01);
	}
	
	@Test
	public void testAdd()
	{
		Force2D f = new Force2D(2, 5);
		Force2D f2 = new Force2D(4, 3);
		Force2D f3 = f.add(f2);
		
		double mag = f3.getMagnitude();
		double expected = 10;
		Assert.assertEquals(expected, mag, .01);
		
		double ang = f3.getAngle();
		expected = 53.13;
		Assert.assertEquals(expected, ang, .01);
		
		
		f = new Force2D(-1, -5);
		f3 = f.add(f2);
		
		mag = f3.getMagnitude();
		expected = 3.6055;
		Assert.assertEquals(expected, mag, .01);
		
		ang = f3.getAngle();
		expected = -33.69;
		Assert.assertEquals(expected, ang, .01);
	}
}
