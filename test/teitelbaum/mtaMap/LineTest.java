package teitelbaum.mtaMap;

import java.awt.Color;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class LineTest
{
	@Test
	public void testLineLoad() throws IOException
	{
		Line l = new Line("4..N06R", new Shapes(), new Trips(), new Routes());
		Assert.assertEquals(Color.decode("0x00933C"), l.getColor());
		for (Shape s : l.getLineShapes())
		{
			Assert.assertEquals("4..N06R", s.getShapeID());
		}
	}
}
