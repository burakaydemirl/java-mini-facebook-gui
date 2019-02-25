import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddImage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddImage window = new AddImage();
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
	public AddImage() {
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
		comboBox.setSelectedIndex(1);
		
		
		
		JLabel lblFilename = new JLabel("Filename:");
		lblFilename.setBounds(31, 132, 58, 14);
		frame.getContentPane().add(lblFilename);
		
		JTextField flText = new JTextField();
		flText.setBounds(105, 129, 195, 20);
		frame.getContentPane().add(flText);
		flText.setColumns(10);
		
		JLabel lblWidth = new JLabel("Width:");
		lblWidth.setBounds(31, 157, 46, 14);
		frame.getContentPane().add(lblWidth);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setBounds(183, 157, 46, 14);
		frame.getContentPane().add(lblHeight);
		
		JTextField hText = new JTextField();
		hText.setColumns(10);
		hText.setBounds(232, 154, 68, 20);
		frame.getContentPane().add(hText);
		
		JTextField wText = new JTextField();
		wText.setColumns(10);
		wText.setBounds(105, 154, 68, 20);
		frame.getContentPane().add(wText);
		
		JButton btnAddPost = new JButton("Add Post");
		btnAddPost.setBounds(337, 28, 89, 23);
		frame.getContentPane().add(btnAddPost);
		btnAddPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem().toString().equals("ImagePost")){
					
					try {
						int[] reso = new int[2];
						reso[0]=Integer.parseInt(wText.getText());
						reso[1]=Integer.parseInt(hText.getText());
						
						UserCollection.ADDPOSTIMAGE(UserCollection.signinUser.getUserName(), textField.getText(),
								Double.parseDouble(longText.getText()), Double.parseDouble(latText.getText()),"1:2", flText.getText(), reso);
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
