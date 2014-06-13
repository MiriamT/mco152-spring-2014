package teitelbaum.nasa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class NasaFrame extends JFrame {
	private DefaultListModel<Image> listModel;
	private JList<Image> imageList;
	private JLabel imageLabel;
	private JScrollPane scroll;
	JComboBox<Sol> comboBox;
	private DefaultComboBoxModel<Sol> comboModel;

	public NasaFrame() {
		setSize(800, 600);
		setTitle("NASA");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		listModel = new DefaultListModel<Image>();
		imageList = new JList<Image>(listModel);
		scroll = new JScrollPane(imageList);
		add(scroll, BorderLayout.WEST);

		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) 
			{
				if (e.getClickCount() == 1) 
				{

					Image selectedItem = (Image) imageList.getSelectedValue();
					DownloadImageThread imageThread = new DownloadImageThread(imageLabel, selectedItem.getUrl());
					imageThread.start();
				}
			}
		};
		imageList.addMouseListener(mouseListener);

		imageLabel = new JLabel();
		add(imageLabel, BorderLayout.CENTER);
		
		comboModel = new DefaultComboBoxModel<Sol>();
		comboBox = new JComboBox<>(comboModel);
		DownloadSolFeedThread solThread = new DownloadSolFeedThread(this);
		solThread.start();
		
		final NasaFrame me = this;
		comboBox.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JComboBox<Sol>  cb = (JComboBox<Sol>)e.getSource();
		        Sol sol = (Sol)cb.getSelectedItem();
		        DownloadNasaFeedThread thread = new DownloadNasaFeedThread(me, sol.getUrl());
				thread.start();
			}
			
			});
		add(comboBox, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		NasaFrame window = new NasaFrame();
		window.setVisible(true);
	}

	public void populateList(final ArrayList<Image> images) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				listModel.clear();
				for (Image i : images) {
					listModel.addElement(i);
				}
			}

		});
	}

	public void loadComboBox(Sol[] sols) 
	{
		for (Sol s : sols)
		{
			comboModel.addElement(s);
		}
	}

}
