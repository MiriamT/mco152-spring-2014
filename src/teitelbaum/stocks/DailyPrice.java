package teitelbaum.stocks;

import java.util.Date;

public class DailyPrice implements Comparable<DailyPrice>
{
	private final String exchange;
	private final String symbol;
	private final Date date;
	private final double openPrice;
	private final double highPrice;
	private final double lowPrice;
	private final double closePrice;
	private final int volume;
	private final double adjustedClosePrice;

	public DailyPrice(String exchange, String symbol, Date date, double openPrice, double highPrice, double lowPrice, double closePrice, int volume, double adjustedClosePrice)
	{
		this.exchange = exchange;
		this.symbol = symbol;
		this.date = date;
		this.openPrice = openPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.closePrice = closePrice;
		this.volume = volume;
		this.adjustedClosePrice = adjustedClosePrice;
	}

	public String getExchange()
	{
		return exchange;
	}

	public String getSymbol()
	{
		return symbol;
	}

	public Date getDate()
	{
		return date;
	}

	public double getOpenPrice()
	{
		return openPrice;
	}

	public double getHighPrice()
	{
		return highPrice;
	}

	public double getLowPrice()
	{
		return lowPrice;
	}

	public double getClosePrice()
	{
		return closePrice;
	}

	public int getVolume()
	{
		return volume;
	}

	public double getAdjustedClosePrice()
	{
		return adjustedClosePrice;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		DailyPrice other = (DailyPrice) obj;
		if (symbol == null)
		{
			if (other.symbol != null)
			{
				return false;
			}
		}
		else if (!symbol.equals(other.symbol))
		{
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(DailyPrice p)
	{
		return date.compareTo(p.date);
	}

}
