package teitelbaum.ufo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Cities
{
	private final List<City> cities;

	public Cities() throws IOException
	{
		cities = new ArrayList<City>();

		CSVReader reader = new CSVReader(new FileReader("./ZIP_CODES.txt"));
		String[] nextLine;
		String zip, name, state;
		Double lat, lon;
		while ((nextLine = reader.readNext()) != null)
		{
			zip = nextLine[0];
			lat = nextLine[1] == null || "".equals(nextLine[1]) ? null : Double.valueOf(nextLine[1]);
			lon = nextLine[2] == null || "".equals(nextLine[2]) ? null : Double.valueOf(nextLine[2]);
			name = nextLine[3];
			state = nextLine[4];

			cities.add(new City(zip, lat, lon, name, state));
		}
		reader.close();
	}

	public List<City> getCities()
	{
		return cities;
	}

	public City getCity(String city, String state)
	{
		if (city == null || state == null)
		{
			return null;
		}
		for (City c : cities)
		{
			if (c.getName().equals(city) && c.getState().equals(state))
			{
				return c;
			}
		}
		return null;
	}

}
