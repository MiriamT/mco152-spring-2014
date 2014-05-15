package teitelbaum.triangle;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest 
{
	@Test
	public void testTriangle()
	{
		Triangle t = new Triangle(-1);
		String expected = "";
		Assert.assertEquals(expected, t.toString());
		
		t = new Triangle(0);
		Assert.assertEquals(expected, t.toString());
		
		t = new Triangle(3);
		expected = "  *\n * *\n*****";
		Assert.assertEquals(expected, t.toString());
		
		t = new Triangle(6);
		expected = "     *\n    * *\n   *   *\n  *     *\n *       *\n***********";
		Assert.assertEquals(expected, t.toString());
		
		t = new Triangle(10);
		expected = "         *\n        * *\n       *   *\n      *     *\n     *       *\n    *         *\n   *           *\n  *             *\n *               *\n*******************";
		Assert.assertEquals(expected, t.toString());
	}
}
