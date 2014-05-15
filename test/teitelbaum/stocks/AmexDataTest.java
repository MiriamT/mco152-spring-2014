package teitelbaum.stocks;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AmexDataTest
{
	@Test
	public void testContains() throws IOException, ParseException
	{
		AmexData data = new AmexData();
		Assert.assertTrue(data.contains("AIP"));
		Assert.assertTrue(data.contains("ENA"));
		Assert.assertFalse(data.contains("MLT"));
	}

	@Test
	public void testGetPricesGivenSymbol() throws IOException, ParseException
	{
		AmexData data = new AmexData();
		List<DailyPrice> prices = data.getPrices("AIP");

		for (int i = 0; i < prices.size() - 1; i++)
		{
			Assert.assertTrue(prices.get(i).getDate().compareTo(prices.get(i + 1).getDate()) < 0);
		}

		//check that method returns an empty list if symbol doesnt exist
		prices = data.getPrices("MLT");
		Assert.assertEquals(new ArrayList<DailyPrice>(), prices);
	}

	@Test
	public void testGetPricesGivenDateRange() throws IOException, ParseException
	{
		AmexData data = new AmexData();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		//check that method returns an empty list if symbol doesnt exist
		List<DailyPrice> prices = data.getPrices("MLT", format.parse("2000-12-21"), format.parse("2000-12-31"));
		Assert.assertEquals(new ArrayList<DailyPrice>(), prices);

		//check that method returns an empty list if there are no dates in the date range
		prices = data.getPrices("AIP", format.parse("2020-12-21"), format.parse("2020-12-31"));
		Assert.assertEquals(new ArrayList<DailyPrice>(), prices);

		//check that method returns a list with prices inside the price range
		Date begin = format.parse("2009-01-01");
		Date end = format.parse("2009-12-31");
		prices = data.getPrices("AIP", begin, end);
		for (DailyPrice dp : prices)
		{
			Assert.assertTrue(dp.getDate().compareTo(begin) >= 0);
			Assert.assertTrue(dp.getDate().compareTo(end) <= 0);
		}

		for (int i = 0; i < prices.size() - 1; i++)
		{
			Assert.assertTrue(prices.get(i).getDate().compareTo(prices.get(i + 1).getDate()) < 0);
		}
	}
}
