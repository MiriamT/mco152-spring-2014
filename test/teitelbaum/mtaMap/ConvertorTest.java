package teitelbaum.mtaMap;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ConvertorTest
{
	@Test
	public void testConvert() throws IOException
	{
		Convertor c = new Convertor(null, new Shapes());
		double value = c.convert(40.512, 40.904, 0, 999, 40.6);
		Assert.assertEquals(224.2653, value, .001);
	}
}
