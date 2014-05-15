package teitelbaum.mtaMap;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class TripsTest
{
	@Test
	public void testTripsLoad() throws IOException
	{
		Trips ts = new Trips();
		Assert.assertEquals("1", ts.getTrips().get(0).getRouteID());
		Assert.assertEquals("1..S03R", ts.getTrips().get(0).getShapeID());
	}
}
