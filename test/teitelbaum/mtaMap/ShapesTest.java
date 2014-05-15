package teitelbaum.mtaMap;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ShapesTest
{
	@Test
	public void testShapesLoad() throws IOException
	{
		Shapes ss = new Shapes();
		Assert.assertEquals("4..N06R", ss.getShapes().get(0).getShapeID());
		Assert.assertEquals(40.668897, ss.getShapes().get(0).getLat(), .01);
		Assert.assertEquals(-73.932942, ss.getShapes().get(0).getLon(), .01);
	}
}
