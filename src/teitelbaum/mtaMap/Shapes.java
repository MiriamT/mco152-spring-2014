package teitelbaum.mtaMap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Shapes
{
	private final List<Shape> shapes;
	private final double MINLAT;
	private final double MAXLAT;
	private final double MINLON;
	private final double MAXLON;

	public Shapes() throws IOException
	{
		shapes = new ArrayList<Shape>();
		//read in csv
		Double minLat = null, maxLat = null, minLon = null, maxLon = null;

		CSVReader reader = new CSVReader(new FileReader("./shapes.txt"));
		reader.readNext(); //skip headings line

		String[] nextLine;
		while ((nextLine = reader.readNext()) != null)
		{
			double lat = Double.valueOf(nextLine[1]);
			double lon = Double.valueOf(nextLine[2]);
			if (minLat == null) //1st time
			{
				minLat = lat;
				maxLat = lat;
				minLon = lon;
				maxLon = lon;
			}
			else
			{
				if (lat < minLat)
				{
					minLat = lat;
				}
				else if (lat > maxLat)
				{
					maxLat = lat;
				}
				if (lon < minLon)
				{
					minLon = lon;
				}
				else if (lon > maxLon)
				{
					maxLon = lon;
				}
			}
			shapes.add(new Shape(nextLine[0], lat, lon));
		}
		reader.close();
		MINLAT = minLat;
		MAXLAT = maxLat;
		MINLON = minLon;
		MAXLON = maxLon;
	}

	public List<Shape> getShapes()
	{
		return shapes;
	}

	public double getMINLAT()
	{
		return MINLAT;
	}

	public double getMAXLAT()
	{
		return MAXLAT;
	}

	public double getMINLON()
	{
		return MINLON;
	}

	public double getMAXLON()
	{
		return MAXLON;
	}

	public List<Shape> getShapes(String shapeID)
	{
		ArrayList<Shape> specificShapes = new ArrayList<Shape>();
		for (Shape s : shapes)
		{
			if (s.getShapeID().equals(shapeID))
			{
				specificShapes.add(s);
			}
		}
		return specificShapes;
	}

	public List<String> getShapeIDs()
	{
		ArrayList<String> ids = new ArrayList<String>();
		for (Shape s : shapes)
		{
			if (!ids.contains(s.getShapeID()))
			{
				ids.add(s.getShapeID());
			}
		}
		return ids;
	}
}
