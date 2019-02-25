import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddVideo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVideo window = new AddVideo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddVideo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				ProfilePage pg = new ProfilePage();
			}
		});
		frame.setBounds(100, 100, 470, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPostType = new JLabel("Post Type");
		lblPostType.setBounds(31, 32, 78, 14);
		frame.getContentPane().add(lblPostType);
		
		JLabel lblText = new JLabel("Text:");
		lblText.setBounds(31, 57, 46, 14);
		frame.getContentPane().add(lblText);
		
		JLabel lblLo = new JLabel("Latitude:");
		lblLo.setBounds(31, 82, 46, 14);
		frame.getContentPane().add(lblLo);
		
		JTextField textField = new JTextField();
		textField.setBounds(105, 54, 321, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextField latText = new JTextField();
		latText.setBounds(105, 79, 86, 20);
		frame.getContentPane().add(latText);
		latText.setColumns(10);
		
		JLabel lblLongitude = new JLabel("Longitude:");
		lblLongitude.setBounds(201, 82, 68, 14);
		frame.getContentPane().add(lblLongitude);
		
		JTextField longText = new JTextField();
		longText.setColumns(10);
		longText.setBounds(269, 79, 86, 20);
		frame.getContentPane().add(longText);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().equals("TextPost")){
					AddText at = new AddText();
					frame.dispose();	
				}
				else if(comboBox.getSelectedItem().toString().equals("ImagePost")){
					AddImage ai = new AddImage();
					frame.dispose();
				}
			}
		});
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"TextPost", "ImagePost", "VideoPost"}));
		comboBox.setBounds(105, 29, 94, 20);
		frame.getContentPane().add(comboBox);
		comboBox.setSelectedIndex(2);
		
		
		
		JLabel lblFilename = new JLabel("Filename:");
		lblFilename.setBounds(31, 132, 58, 14);
		frame.getContentPane().add(lblFilename);
		
		JTextField flText = new JTextField();
		flText.setBounds(105, 129, 195, 20);
		frame.getContentPane().add(flText);
		flText.setColumns(10);
		
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setBounds(31, 157, 58, 14);
		frame.getContentPane().add(lblDuration);
		
		JTextField dText = new JTextField();
		dText.setColumns(10);
		dText.setBounds(105, 154, 68, 20);
		frame.getContentPane().add(dText);
		
		JButton btnAddPost = new JButton("Add Post");
		btnAddPost.setBounds(337, 28, 89, 23);
		frame.getContentPane().add(btnAddPost);
		btnAddPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem().toString().equals("VideoPost")){
					
					try {
						
						
						UserCollection.ADDPOSTVIDEO(UserCollection.signinUser.getUserName(), textField.getText(),
								Double.parseDouble(longText.getText()), Double.parseDouble(latText.getText()),"1:2", flText.getText(), Integer.parseInt(dText.getText()));
						frame.dispose();
						ProfilePage pg = new ProfilePage();
						
						
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		
		
		
		frame.setVisible(true);
	}

}
