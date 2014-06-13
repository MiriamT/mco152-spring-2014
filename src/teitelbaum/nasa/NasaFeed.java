package teitelbaum.nasa;

import com.google.gson.annotations.SerializedName;

public class NasaFeed 
{
	private String mission;
	private int sol;
	@SerializedName("pcam_images")
	private Camera[] pcam;
	@SerializedName("ncam_images")
	private Camera[] ncam;
	@SerializedName("fcam_images")
	private Camera[] fcam;
	@SerializedName("rcam_images")
	private Camera[] rcam;
	
	public String getMission() {
		return mission;
	}
	public int getSol() {
		return sol;
	}
	public Camera[] getPcam() {
		return pcam;
	}
	public Camera[] getNcam() {
		return ncam;
	}
	public Camera[] getFcam() {
		return fcam;
	}
	public Camera[] getRcam() {
		return rcam;
	}
}
