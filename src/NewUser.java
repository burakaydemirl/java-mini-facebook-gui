import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NewUser {

	private JFrame frame;
	private JTextField userName;
	private JPasswordField pass;
	private JPasswordField repass;
	private JTextField nameSurname;
	private JTextField school;
	private JTextField DoB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser window = new NewUser();
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
	public NewUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
	
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 354, 407);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Facebooklogo1.png"));
		lblNewLabel.setBounds(20, -19, 318, 110);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCreateUser = new JLabel("Create User");
		lblCreateUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCreateUser.setBounds(93, 78, 163, 23);
		frame.getContentPane().add(lblCreateUser);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(39, 116, 74, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(39, 145, 74, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblPasswordretype = new JLabel("Password (re-type)");
		lblPasswordretype.setBounds(39, 174, 148, 23);
		frame.getContentPane().add(lblPasswordretype);
		
		JLabel lblNameSurname = new JLabel("Name Surname");
		lblNameSurname.setBounds(39, 206, 101, 23);
		frame.getContentPane().add(lblNameSurname);
		
		JLabel lblSchoolGraduate = new JLabel("School graduate");
		lblSchoolGraduate.setBounds(39, 240, 101, 23);
		frame.getContentPane().add(lblSchoolGraduate);
		
		JLabel lblBirth = new JLabel("Birth Date");
		lblBirth.setBounds(39, 274, 101, 23);
		frame.getContentPane().add(lblBirth);
		
		userName = new JTextField();
		userName.setBounds(170, 117, 86, 20);
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(170, 146, 86, 20);
		frame.getContentPane().add(pass);
		pass.setColumns(10);
		
		repass = new JPasswordField();
		repass.setBounds(170, 175, 86, 20);
		frame.getContentPane().add(repass);
		repass.setColumns(10);
		
		nameSurname = new JTextField();
		nameSurname.setBounds(170, 207, 158, 20);
		frame.getContentPane().add(nameSurname);
		nameSurname.setColumns(10);
		
		school = new JTextField();
		school.setBounds(170, 241, 158, 20);
		frame.getContentPane().add(school);
		school.setColumns(10);
		
		DoB = new JTextField();
		DoB.setBounds(170, 275, 86, 20);
		frame.getContentPane().add(DoB);
		DoB.setColumns(10);
		
		JLabel lblRelationshipStatus = new JLabel("Relationship Status");
		lblRelationshipStatus.setBounds(39, 304, 130, 23);
		frame.getContentPane().add(lblRelationshipStatus);
		
		JComboBox relaStatus = new JComboBox();
		relaStatus.setModel(new DefaultComboBoxModel(new String[] {"In a relationship", "Divorced", "Complicated", "Single"}));
		relaStatus.setBounds(170, 305, 130, 20);
		frame.getContentPane().add(relaStatus);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int userExit=0;
				int passExit=0;
					if(!UserCollection.userList.contains(userName)){
						userExit=1;
						if((String.valueOf(pass.getPassword()).equals((String.valueOf(repass.getPassword()))))&(String.valueOf(repass.getPassword())).length()>0){
							passExit=1;
							int lastUserID = UserCollection.userList.get(UserCollection.userList.size()-1).getUserID();
							UserCollection.addUser(lastUserID+1, nameSurname.getText(), userName.getText(), (String.valueOf(pass.getPassword())), DoB.getText(), school.getText(), relaStatus.getSelectedItem().toString());
    						JOptionPane.showMessageDialog(frame, "Success");
							LoginPage lp = new LoginPage();
							frame.dispose();
						
							
						}
					}
					
					
				
				if(userExit==0){
					JOptionPane.showMessageDialog(frame, "This username already taken!");
				}
				else if(passExit==0){
					JOptionPane.showMessageDialog(frame, "Passwords does not match!");
				}
				
				
			}
		});
		btnNewButton.setBounds(123, 334, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				LoginPage lp = new LoginPage();
			}
		});
		
		frame.setVisible(true);
		
	}
}
