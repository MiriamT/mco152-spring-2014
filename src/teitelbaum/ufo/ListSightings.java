package teitelbaum.ufo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;

public class ListSightings
{
	public static void main(String[] args) throws IOException
	{
		Gson gson = new Gson();

		FileReader reader = new FileReader("./ufo_awesome.json");
		SightingList list = gson.fromJson(reader, SightingList.class);

		System.out.println(list.size());

		Map<String, List<Sighting>> map = new HashMap<>();
		for (Sighting s : list)
		{
			String location = s.getLocation();
			List<Sighting> sightings = map.get(location);
			if (sightings == null)
			{
				sightings = new ArrayList<Sighting>();
			}
			sightings.add(s);
			map.put(location, sightings);
		}

		Cities cities = new Cities();
		//print out all sightings on "19950115" and their City
		Scanner parseLocation;
		String city, state;
		for (Sighting s : list)
		{
			if ("19950115".equals(s.getSightedAt()))
			{
				System.out.println(s);
				parseLocation = new Scanner(s.getLocation());
				parseLocation.useDelimiter(",");
				city = parseLocation.next();
				state = parseLocation.next();
				System.out.println(cities.getCity(city.toUpperCase().trim(), state.trim()) + "\n");
			}
		}
	}
}
