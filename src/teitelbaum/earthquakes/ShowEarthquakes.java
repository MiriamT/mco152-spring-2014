package teitelbaum.earthquakes;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

public class ShowEarthquakes extends JFrame 
{
	DefaultListModel<EarthquakeData> listModel;
	//EarthquakeList quakes;
	JList<EarthquakeData> quakeList;
	
	public ShowEarthquakes() 
	{
		setSize(300, 800);
		setTitle("Earthquakes");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//quakes = new EarthquakeList();
		listModel = new DefaultListModel<EarthquakeData>();
		quakeList = new JList<EarthquakeData>(listModel);
		quakeList.setCellRenderer(new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                      boolean isSelected, boolean cellHasFocus) {
                 Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                 EarthquakeData data = (EarthquakeData) value;
                 double magnitude = data.getMagnitude();
                 if (magnitude < 2)
                 {
                	 setBackground(Color.decode("#660099"));
                 }
                 else if (magnitude < 3)
                 {
                	 setBackground(Color.decode("#0099FF"));
                 }
                 else if (magnitude < 4)
                 {
                	 setBackground(Color.decode("#00CC99"));
                 }
                 else if (magnitude < 5)
                 {
                	 setBackground(Color.decode("#99CC66"));
                 }
                 else if (magnitude < 6)
                 {
                	 setBackground(Color.decode("#99FF33"));
                 }
                 else if (magnitude < 7)
                 {
                	 setBackground(Color.decode("#FFFF33"));
                 }
                 else if (magnitude < 8)
                 {
                	 setBackground(Color.decode("#FFCC66"));
                 }
                 else if (magnitude < 9)
                 {
                	 setBackground(Color.decode("#FF9966"));
                 }
                 else if (magnitude < 10)
                 {
                	 setBackground(Color.decode("#FF3300"));
                 }
                 else
                 {
                	 setBackground(Color.decode("#CC0000"));
                 }
                 
                 
                 
                 
                 return c;
            }

       });
		
		
		
		
		
		
		add(quakeList);
		
		DownloadQuakesThread thread = new DownloadQuakesThread(this);
		thread.start();
	}
	
	
	public static void main(String[] args)
	{
		ShowEarthquakes window = new ShowEarthquakes();
		window.setVisible(true);
	}

	public void refresh(EarthquakeList list) 
	{
		listModel.clear();
		for (EarthquakeData data : list)
		{
			listModel.addElement(data);
		}
		
	}
}
