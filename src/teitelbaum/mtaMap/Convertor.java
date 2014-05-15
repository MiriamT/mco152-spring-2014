package teitelbaum.mtaMap;

public class Convertor
{
	private final MapFrame window;
	private final double MOD_MINLAT; //modified to give a little border around map
	private final double MOD_MAXLAT;
	private final double MOD_MINLON;
	private final double MOD_MAXLON;

	public Convertor(MapFrame frame, Shapes s)
	{
		window = frame;
		MOD_MINLAT = s.getMINLAT() - s.getMINLAT() * .001;
		MOD_MAXLAT = s.getMAXLAT() + s.getMAXLAT() * .001;
		MOD_MINLON = s.getMINLON() + s.getMINLON() * .001;
		MOD_MAXLON = s.getMAXLON() - s.getMAXLON() * .001;
	}

	public double convertLatToY(double lat)
	{
		return convert(MOD_MINLAT, MOD_MAXLAT, window.getHeight() - 1, 0, lat);
	}

	public double convertLontoX(double lon)
	{
		return convert(MOD_MINLON, MOD_MAXLON, 0, window.getWidth() - 1, lon);
	}

	public double convert(double origMin, double origMax, double projMin, double projMax, double value)
	{
		double origRange = origMax - origMin;
		double projRange = projMax - projMin;
		double raw = value - origMin;
		double projection = raw * projRange / origRange;
		return projection + projMin;
	}
}
