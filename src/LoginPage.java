import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class LoginPage {

	private JFrame frame;
	private JTextField userName;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 621, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Facebooklogo1.png"));
		lblNewLabel.setBounds(22, 63, 350, 93);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(76, 247, 423, 79);
		frame.getContentPane().add(panel);
		
		DefaultListModel<String> dList = new DefaultListModel<String>();
		JList list = new JList(dList);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				String selected=(String) list.getSelectedValue();
				for (User users : UserCollection.userList) {
					if(users.getUserName().equals(selected)){
						
						userName.setText(users.getUserName());
						pass.setText(users.getPass());
						
					}
				}
				
				
			}
		});
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setVisibleRowCount(2);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(Color.WHITE);
		list.setBounds(0, 0, 423, 79);
	
		for (User users : UserCollection.userList) {
			dList.addElement(users.getUserName());
		}

		panel.setLayout(null);
		panel.add(list);
	
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(382, 96, 69, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(382, 121, 69, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		userName = new JTextField();
		userName.setBounds(461, 93, 86, 20);
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(461, 118, 86, 20);
		frame.getContentPane().add(pass);
		pass.setColumns(10);
		
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int userExit=0;
				int passExit=0;
				for (User users : UserCollection.userList) {
					if(userName.getText().equals(users.getUserName())){
						userExit=1;
						if(users.getPass().equals(String.valueOf(pass.getText()))){
							passExit=1;
							UserCollection.signinUser = users;
							ProfilePage pp = new ProfilePage();
							frame.setVisible(false);
						}
					}
				}
			}
		});
		btnLogin.setBounds(461, 155, 86, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnNewButton = new JButton("New User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewUser create = new NewUser();
				frame.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(394, 337, 120, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.isSelectionEmpty()==false){
					int reply = JOptionPane.showConfirmDialog(null, "Are you sure remove this user?", "Remove?",  JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION)
					{
						String selected = (String)list.getSelectedValue();
						for (User users : UserCollection.userList) {
							if(users.friendList.contains(selected)){
								users.friendList.remove(selected);
							}
							else if(users.blockedList.contains(selected));{
								users.blockedList.remove(selected);
							}
							for (User userz : UserCollection.userList) {
								if(userz.getUserName().equals(selected)){
									UserCollection.userList.remove(userz);
								}
							}
						}
						DefaultListModel<String> uList = new DefaultListModel<String>();
						for (User usern : UserCollection.userList) {
							uList.addElement(usern.getUserName());
						}
						list.setModel(uList);
					}
				}
				
				
			}
		});
		btnRemoveUser.setBounds(55, 337, 110, 23);
		frame.getContentPane().add(btnRemoveUser);
		
		frame.setVisible(true);
	}
}
