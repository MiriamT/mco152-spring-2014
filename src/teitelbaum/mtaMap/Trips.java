package teitelbaum.mtaMap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Trips
{
	private final List<Trip> trips;

	public Trips() throws IOException
	{
		trips = new ArrayList<Trip>();
		CSVReader reader = new CSVReader(new FileReader("./trips.txt"));
		reader.readNext(); //skip headings line

		String[] nextLine;
		while ((nextLine = reader.readNext()) != null)
		{
			Trip trip = new Trip(nextLine[0], nextLine[6]);
			if (!trips.contains(trip))
			{
				trips.add(trip);
			}
		}
		reader.close();
	}

	public List<Trip> getTrips()
	{
		return trips;
	}

	public Trip getTrip(String shapeID)
	{
		for (Trip t : trips)
		{
			if (t.getShapeID().equals(shapeID))
			{
				return t;
			}
		}
		return null;
	}

	public String getRouteID(String shapeID)
	{
		for (Trip t : trips)
		{
			if (t.getShapeID().equals(shapeID))
			{
				return t.getRouteID();
			}
		}
		return null;
	}

	public String getShapeID(String routeID)
	{
		for (Trip t : trips)
		{
			if (t.getRouteID().equals(routeID))
			{
				return t.getShapeID();
			}
		}
		return null;
	}
}
