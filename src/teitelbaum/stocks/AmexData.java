package teitelbaum.stocks;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

public class AmexData
{
	private final Map<String, List<DailyPrice>> map; //string is the stock symbol

	public AmexData() throws IOException, ParseException
	{
		map = new HashMap<>();

		String[] fileNames =
		{ "0.csv", "1.csv", "2.csv", "3.csv", "4.csv", "5.csv", "6.csv", "7.csv", "8.csv", "9.csv", "A.csv", "B.csv", "C.csv", "D.csv", "E.csv", "F.csv", "G.csv", "H.csv", "I.csv", "J.csv", "K.csv",
				"L.csv", "M.csv", "N.csv", "O.csv", "P.csv", "Q.csv", "R.csv", "S.csv", "T.csv", "U.csv", "V.csv", "W.csv", "X.csv", "Y.csv", "Z.csv", };

		for (String fileName : fileNames)
		{
			CSVReader reader = new CSVReader(new FileReader("./resources/amex/AMEX_daily_prices_" + fileName));
			reader.readNext(); //skip headings line

			String[] nextLine;
			while ((nextLine = reader.readNext()) != null)
			{
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				DailyPrice price = new DailyPrice(nextLine[0], nextLine[1], format.parse(nextLine[2]), Double.parseDouble(nextLine[3]), Double.parseDouble(nextLine[4]),
						Double.parseDouble(nextLine[5]), Double.parseDouble(nextLine[6]), Integer.parseInt(nextLine[7]), Double.parseDouble(nextLine[8]));

				String symbol = nextLine[1];
				List<DailyPrice> prices = map.get(symbol);
				if (prices == null)
				{
					prices = new ArrayList<DailyPrice>();
				}
				prices.add(price);
				map.put(symbol, prices);
			}
			reader.close();
		}
		for (String symbol : map.keySet())
		{
			Collections.sort(map.get(symbol));
		}
	}

	public boolean contains(String symbol)
	{
		return map.containsKey(symbol);
	}

	public List<DailyPrice> getPrices(String symbol)
	{
		if (contains(symbol))
		{
			return map.get(symbol);
		}
		else
		{
			return new ArrayList<DailyPrice>();
		}
	}

	public List<DailyPrice> getPrices(String symbol, Date startDate, Date endDate)
	{
		List<DailyPrice> list = new ArrayList<DailyPrice>();
		if (contains(symbol))
		{
			List<DailyPrice> prices = map.get(symbol);
			for (DailyPrice p : prices)
			{
				Date date = p.getDate();
				if (!date.before(startDate) && !date.after(endDate)) //date is outside range and doesnt belong in list
				{
					list.add(p);
				}
			}
		}
		return list;
	}

}
