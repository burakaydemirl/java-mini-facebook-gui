import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddText {

	private JFrame frame;
	private JTextField textField;
	private JTextField latText;
	private JTextField longText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddText window = new AddText();
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
	public AddText() {
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
		
		textField = new JTextField();
		textField.setBounds(105, 54, 321, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		latText = new JTextField();
		latText.setBounds(105, 79, 86, 20);
		frame.getContentPane().add(latText);
		latText.setColumns(10);
		
		JLabel lblLongitude = new JLabel("Longitude:");
		lblLongitude.setBounds(201, 82, 68, 14);
		frame.getContentPane().add(lblLongitude);
		
		longText = new JTextField();
		longText.setColumns(10);
		longText.setBounds(269, 79, 86, 20);
		frame.getContentPane().add(longText);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().equals("ImagePost")){
					AddImage ai = new AddImage();
					frame.dispose();
				}
				else if(comboBox.getSelectedItem().toString().equals("VideoPost")){
					AddVideo av = new AddVideo();
					frame.dispose();
				}
			}
		});
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"TextPost", "ImagePost", "VideoPost"}));
		comboBox.setBounds(105, 29, 94, 20);
		frame.getContentPane().add(comboBox);
		comboBox.setSelectedIndex(0);
		
		
		
		
		JButton btnAddPost = new JButton("Add Post");
		btnAddPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem().toString().equals("TextPost")){
					
					try {
						UserCollection.ADDPOSTTEXT(UserCollection.signinUser.getUserName(), textField.getText(),
								Double.parseDouble(longText.getText()), Double.parseDouble(latText.getText()),"1:2");
						frame.dispose();
						ProfilePage pg = new ProfilePage();
						
						
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnAddPost.setBounds(337, 28, 89, 23);
		frame.getContentPane().add(btnAddPost);
		
		
		
		frame.setVisible(true);
		
		
		
	}

	
}
