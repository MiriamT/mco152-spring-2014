package teitelbaum.ufo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class CitiesTest
{
	@Test
	public void testConstructor() throws IOException
	{
		Cities c = new Cities();
		Assert.assertEquals("00501", c.getCities().get(0).getZip());
		Assert.assertEquals(40.922326, c.getCities().get(0).getLat(), .01);
		Assert.assertEquals(-072.637078, c.getCities().get(0).getLon(), .01);
		Assert.assertEquals("HOLTSVILLE", c.getCities().get(0).getName());
		Assert.assertEquals("NY", c.getCities().get(0).getState());
	}

	@Test
	public void testGetCity() throws IOException
	{
		Cities cities = new Cities();
		City c = cities.getCity("MORTON", "WA");
		Assert.assertEquals("MORTON", c.getName());
		Assert.assertEquals("WA", c.getState());

		c = cities.getCity("LA", "DIDA");
		Assert.assertNull(c);
	}
}
