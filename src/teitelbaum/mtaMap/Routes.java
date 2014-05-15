package teitelbaum.mtaMap;

import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Routes
{
	private final List<Route> routes;

	public Routes() throws IOException
	{
		routes = new ArrayList<Route>();
		CSVReader reader = new CSVReader(new FileReader("./routes.txt"));
		reader.readNext(); //skip headings line

		String[] nextLine;
		while ((nextLine = reader.readNext()) != null)
		{
			String routeID = nextLine[0];
			String colorString = nextLine[7].trim();
			Color color;
			if ("".equals(colorString))
			{
				if ("SI".equals(routeID))
				{
					color = Color.decode("0x00447B");
				}
				else if ("H".equals(routeID) || "FS".equals(routeID))
				{
					color = Color.decode("0x7F8184");
				}
				else
				{
					color = null;
				}
			}
			else
			{
				color = Color.decode("0x" + colorString);
			}
			routes.add(new Route(routeID, color));
		}
		reader.close();
	}

	public List<Route> getRoutes()
	{
		return routes;
	}

	public Color getColor(String routeID)
	{
		for (Route r : routes)
		{
			if (r.getRouteID().equals(routeID))
			{
				return r.getColor();
			}
		}
		return null;
	}
}
