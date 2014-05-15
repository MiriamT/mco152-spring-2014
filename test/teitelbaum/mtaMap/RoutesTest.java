package teitelbaum.mtaMap;

import java.awt.Color;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class RoutesTest
{
	@Test
	public void testRoutesLoad() throws IOException
	{
		Routes rs = new Routes();
		Assert.assertEquals("1", rs.getRoutes().get(0).getRouteID());
		Assert.assertEquals(Color.decode("0xEE352E"), rs.getRoutes().get(0).getColor());
	}
}
