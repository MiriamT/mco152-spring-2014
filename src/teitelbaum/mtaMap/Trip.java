package teitelbaum.mtaMap;

public class Trip
{
	private final String routeID;
	private final String shapeID;

	public Trip(String routeID, String shapeID)
	{
		this.routeID = routeID;
		this.shapeID = shapeID;
	}

	public String getRouteID()
	{
		return routeID;
	}

	public String getShapeID()
	{
		return shapeID;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((routeID == null) ? 0 : routeID.hashCode());
		result = prime * result + ((shapeID == null) ? 0 : shapeID.hashCode());
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
		Trip other = (Trip) obj;
		if (routeID == null)
		{
			if (other.routeID != null)
			{
				return false;
			}
		}
		else if (!routeID.equals(other.routeID))
		{
			return false;
		}
		if (shapeID == null)
		{
			if (other.shapeID != null)
			{
				return false;
			}
		}
		else if (!shapeID.equals(other.shapeID))
		{
			return false;
		}
		return true;
	}
}
