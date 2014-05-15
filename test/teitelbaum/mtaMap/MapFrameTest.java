package teitelbaum.mtaMap;

import java.io.IOException;

import org.junit.Test;

public class MapFrameTest
{
	@Test
	public void testConstructor() throws IOException
	{
		MapFrame m = new MapFrame();
		m.setVisible(true);
	}
}
