import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JWindow;
import javax.swing.KeyStroke;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JScrollBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Scrollbar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ProfilePage {

	private JFrame frmProfilePage;
	private final JPanel panel = new JPanel();
	private JTextField searchBar;
	private JButton button;
	private JButton btnCreatePost;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilePage window = new ProfilePage();
					window.frmProfilePage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProfilePage() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProfilePage = new JFrame();
		frmProfilePage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
		});
		frmProfilePage.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to close?", "Close?",  JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION)
				{
				   System.exit(0);
				}
				else if(reply == JOptionPane.NO_OPTION){
					frmProfilePage.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		frmProfilePage.setTitle("Profile Page");
		frmProfilePage.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Burak\\workspace\\Facebook GUI\\personicon8.png"));
		frmProfilePage.setBounds(100, 100, 773, 728);
		frmProfilePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProfilePage.getContentPane().setLayout(null);
		panel.setBounds(0, 0, 756, 40);
		panel.setBackground(new Color(0, 102, 255));
		frmProfilePage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSearchFriends = new JLabel("Search Friends");
		lblSearchFriends.setForeground(new Color(255, 255, 255));
		lblSearchFriends.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSearchFriends.setBounds(92, 9, 115, 23);
		panel.add(lblSearchFriends);
		
		searchBar = new JTextField();
		
		
		
		
		
		
		
		searchBar.setBounds(198, 11, 205, 23);
		panel.add(searchBar);
		searchBar.setColumns(10);
		/////////
		///////////
		 AutoSuggestor autoSuggestor = new AutoSuggestor(searchBar, frmProfilePage, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
	            @Override
	            boolean wordTyped(String typedWord) {

	                ArrayList<String> words = new ArrayList<>();
		                for (User usern : UserCollection.userList) {
							words.add(usern.getName());
							
					}
	                	for (User users : UserCollection.userList) {
							for (String blocks : UserCollection.signinUser.blockedList) {
								if(users.getUserName().equals(blocks)){
									words.remove(users.getName());
								}
							}
					}
						
						
					
	              
	                setDictionary(words);
	               

	                return super.wordTyped(typedWord);
	            }
	        };

		////////////
		///////////
		button = new JButton("Logout");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserCollection.signinUser=null;
				frmProfilePage.dispose();
				LoginPage lp = new LoginPage();
				
			}
		});
		button.setBackground(Color.WHITE);
		button.setBounds(660, 11, 76, 23);
		panel.add(button);
		
		btnCreatePost = new JButton("Create a Post");
		btnCreatePost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddText cp = new AddText();
				frmProfilePage.dispose();
			}
		});
		btnCreatePost.setBackground(Color.WHITE);
		btnCreatePost.setBounds(532, 11, 115, 23);
		panel.add(btnCreatePost);
		
		
		
		label = new JLabel();
		label.setBounds(25, 65, 150, 152);
		label.setIcon(new ImageIcon("C:\\Users\\Burak\\workspace\\Facebook GUI\\personicon8.png"));
		frmProfilePage.getContentPane().add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 228, 198, 215);
		panel_1.setBorder(new TitledBorder(null, "Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setToolTipText("");
		frmProfilePage.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(25, 486, 198, 192);
		frmProfilePage.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		DefaultListModel<String> friendList = new DefaultListModel<String>();
		JList list = new JList(friendList);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(10, 11, 178, 139);
	
		for (String friends:UserCollection.signinUser.friendList) {
			friendList.addElement(friends);
			
		}
		panel_2.add(list);
		
		
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDateOfBirth.setBounds(10, 23, 88, 22);
		panel_1.add(lblDateOfBirth);
		
		JLabel lblSchoolGraduate = new JLabel("School Graduated");
		lblSchoolGraduate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSchoolGraduate.setBounds(10, 67, 119, 22);
		panel_1.add(lblSchoolGraduate);
		
		JLabel lblReleationshipStatus = new JLabel("Releationship Status");
		lblReleationshipStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReleationshipStatus.setBounds(10, 114, 155, 22);
		panel_1.add(lblReleationshipStatus);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"In a relationship", "Divorced", "Complicated", "Single"}));
		comboBox.setBounds(9, 143, 119, 22);
		panel_1.add(comboBox);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserCollection.signinUser.setRelationship(comboBox.getSelectedItem().toString());
			}
		});
		btnUpdate.setBounds(24, 178, 89, 23);
		panel_1.add(btnUpdate);
		
		JLabel DoB = new JLabel("");
		DoB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		DoB.setBounds(12, 45, 151, 14);
		panel_1.add(DoB);
		
		JLabel school = new JLabel("");
		school.setFont(new Font("Tahoma", Font.PLAIN, 11));
		school.setBounds(9, 92, 163, 14);
		panel_1.add(school);
		
		JLabel username = new JLabel("");
		username.setBounds(214, 183, 150, 34);
		username.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmProfilePage.getContentPane().add(username);
		
		
		DoB.setText(UserCollection.signinUser.getDoB());
		school.setText(UserCollection.signinUser.getSchool());
		username.setText(UserCollection.signinUser.getName());
		comboBox.setSelectedItem(UserCollection.signinUser.getRelationship());
		
		
		JLabel lblFriends = new JLabel("Friends");
		lblFriends.setBounds(35, 454, 60, 21);
		lblFriends.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmProfilePage.getContentPane().add(lblFriends);
		
		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		rdbtnNormal.setBounds(72, 454, 71, 23);
		rdbtnNormal.setSelected(true);
		frmProfilePage.getContentPane().add(rdbtnNormal);
		
	
		
		JRadioButton rdbtnBlock = new JRadioButton("Blocked");
		rdbtnBlock.setBounds(141, 454, 81, 23);
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(6, 5, 72, 31);
		panel.add(btnHome);
		btnHome.setVisible(false);
		
		if(btnHome.isVisible()==false){
		rdbtnBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNormal.setSelected(false);
				rdbtnBlock.setSelected(true);
				DefaultListModel<String> blockList = new DefaultListModel<String>();
				for (User users : UserCollection.userList) {
					if(username.getText().equals(users.getName())){
						for (String blocks : users.blockedList) {
							blockList.addElement(blocks);
						}
					}
				}
				
				list.setModel(blockList);
				
			}
		});
		
		rdbtnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNormal.setSelected(true);
				rdbtnBlock.setSelected(false);
				DefaultListModel<String> friendList = new DefaultListModel<String>();
			
				for (User users : UserCollection.userList) {
					if(username.getText().equals(users.getName())){
						for (String friends : users.friendList) {
							friendList.addElement(friends);
						}
					}
				}
				list.setModel(friendList);
				
			}
		});
		}
		frmProfilePage.getContentPane().add(rdbtnBlock);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(233, 233, 510, 445);
		frmProfilePage.getContentPane().add(tabbedPane);
		
		JPanel myPosts = new JPanel();
		tabbedPane.addTab("Posts", null, myPosts, null);
		
		JPanel friendPosts = new JPanel();
		tabbedPane.addTab("Friend's Posts", null, friendPosts, null);
		friendPosts.setLayout(null);
		////////////////
		JButton btnRemove = new JButton("Remove Selected User");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selected = (String)list.getSelectedValue();
				if(rdbtnNormal.isSelected()==true){
					for (User users : UserCollection.userList) {
						if(users.getUserName().equals(selected)){
							UserCollection.signinUser.friendList.remove(selected);
							for (User userz : UserCollection.userList) {
								if(userz.getUserName().equals(selected)){
									userz.friendList.remove(UserCollection.signinUser.getUserName());
								}
							}
							DefaultListModel<String> friendList = new DefaultListModel<String>();
							
							for (String friends:UserCollection.signinUser.friendList) {
								friendList.addElement(friends);
							}
							list.setModel(friendList);
							list.revalidate();
							friendposts(friendPosts,UserCollection.signinUser.getUserName());
							friendPosts.repaint();
							
						}
					}
				}
				else if(rdbtnBlock.isSelected()==true){
					for (User users : UserCollection.userList) {
						if(users.getUserName().equals(selected)){
							UserCollection.signinUser.blockedList.remove(selected);
							
							DefaultListModel<String> blockList = new DefaultListModel<String>();
							
							for (String block:UserCollection.signinUser.blockedList) {
								blockList.addElement(block);
							}
							list.setModel(blockList);
							list.revalidate();
						}
					}
				}
			
				
			}
		});
		btnRemove.setBounds(10, 158, 178, 23);
		panel_2.add(btnRemove);
		
		JButton btnAddFriend = new JButton("Add Friend");
		btnAddFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (User users : UserCollection.userList) {
					if(username.getText().equals(users.getName())){
						UserCollection.signinUser.friendList.add(users.getUserName());
						users.friendList.add(UserCollection.signinUser.getUserName());
						btnAddFriend.setVisible(false);
						String message = "You added "+users.getName()+" as a friend";
						JOptionPane.showMessageDialog(null, message, "", JOptionPane.INFORMATION_MESSAGE);
						DefaultListModel<String> newList = new DefaultListModel<String>();
						for(String friends : users.friendList){
							newList.addElement(friends);
						}
						list.setModel(newList);
						list.repaint();
					}
				}
			}
		});
		btnAddFriend.setBounds(478, 213, 98, 23);
		frmProfilePage.getContentPane().add(btnAddFriend);
		btnAddFriend.setVisible(false);
		
		JButton btnBlockThisUser = new JButton("Block this person");
		btnBlockThisUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (User users : UserCollection.userList) {
					if(users.getName().equals(searchBar.getText())){
						
						if(UserCollection.signinUser.friendList.contains(users.getUserName())){
							UserCollection.signinUser.friendList.remove(users.getUserName());
							users.friendList.remove(UserCollection.signinUser.getUserName());
							UserCollection.signinUser.blockedList.add(users.getUserName());
							users.blockedList.add(UserCollection.signinUser.getUserName());
							btnBlockThisUser.setVisible(false);
							btnHome.doClick();
							rdbtnNormal.setSelected(true);
							rdbtnBlock.setSelected(false);
							DefaultListModel<String> fList = new DefaultListModel<String>();
							for (String friends : UserCollection.signinUser.friendList) {
								fList.addElement(friends);
							}
							list.setModel(fList);
							list.repaint();
							searchBar.setText(null);
							
						}
						else{
							UserCollection.signinUser.blockedList.add(users.getUserName());
							users.blockedList.add(UserCollection.signinUser.getUserName());
							btnBlockThisUser.setVisible(false);
							btnHome.doClick();
							searchBar.setText(null);
							rdbtnNormal.setSelected(true);
							rdbtnBlock.setSelected(false);
							list.setModel(friendList);
							list.repaint();
						}
						String message = "You blocked "+users.getName();
						JOptionPane.showMessageDialog(null, message, "", JOptionPane.INFORMATION_MESSAGE);
						
					}
				}
			}
		});
		
//		for (String friends : UserCollection.signinUser.friendList) {
//			if(username.equals(users.getName())){
//				if(users.getUserName().equals(friends)){
//					System.out.println("sdafgdasukgfýdasþjfikdasf");
//					UserCollection.signinUser.friendList.remove(users.getUserName());
//					UserCollection.signinUser.blockedList.add(users.getUserName());
//				}
//			}
//		}
		btnBlockThisUser.setBounds(586, 213, 138, 23);
		frmProfilePage.getContentPane().add(btnBlockThisUser);
		btnBlockThisUser.setVisible(false);
		
		
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setEnabled(true);
				comboBox.setFocusable(true);
				btnHome.setVisible(false);
				btnUpdate.setVisible(true);
				btnRemove.setVisible(true);
				btnCreatePost.setVisible(true);
				btnAddFriend.setVisible(false);
				btnBlockThisUser.setVisible(false);
				username.setText(UserCollection.signinUser.getName());
				DoB.setText(UserCollection.signinUser.getDoB());
				school.setText(UserCollection.signinUser.getSchool());
				comboBox.setSelectedItem(UserCollection.signinUser.getRelationship());
				rdbtnNormal.setSelected(true);
				rdbtnBlock.setSelected(false);
				list.setModel(friendList);
				myPosts.removeAll();
				friendPosts.removeAll();
				userposts(myPosts,UserCollection.signinUser.getUserName());
				friendposts(friendPosts,UserCollection.signinUser.getUserName());
			}
		});
		
		
		/////////////////////////////////
		searchBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (User users : UserCollection.userList) {
					
					
					if(UserCollection.signinUser.blockedList.size()==0){
					
						if(searchBar.getText().equals(users.getName())){
							
							
								
								if(UserCollection.signinUser.friendList.contains(users.getUserName())){
									btnAddFriend.setVisible(false);
									btnBlockThisUser.setVisible(true);
								}
								else if(UserCollection.signinUser.blockedList.contains(users.getUserName())){
									btnHome.doClick();
								}
								else{
									btnAddFriend.setVisible(true);
									btnBlockThisUser.setVisible(true);
								}
								comboBox.setSelectedItem(users.getRelationship());
								comboBox.setEnabled(false);
								comboBox.setFocusable(false);
								btnHome.setVisible(true);
								btnUpdate.setVisible(false);
								btnRemove.setVisible(false);
								btnCreatePost.setVisible(false);
								username.setText(users.getName());
								DoB.setText(users.getDoB());
								school.setText(users.getSchool());
								myPosts.removeAll();
								friendPosts.removeAll();
								userposts(myPosts,users.getUserName());
								myPosts.repaint();
								friendposts(friendPosts,users.getUserName());
								friendPosts.repaint();
								
								if(rdbtnNormal.isSelected()==true){
									DefaultListModel<String> friendList = new DefaultListModel<String>();
									for (String friendn : users.friendList) {
										friendList.addElement(friendn);
									}
									list.setModel(friendList);
								}
								else if(rdbtnBlock.isSelected()==true){
									DefaultListModel<String> blockList = new DefaultListModel<String>();
									for (String blockn : users.blockedList) {
										blockList.addElement(blockn);
									}
									list.setModel(blockList);
								}
							
					
					}
					}
					else{
						for (String blocks : UserCollection.signinUser.blockedList) {
							if(!searchBar.getText().equals(blocks)){
								if(searchBar.getText().equals(users.getName())){
									for (User userz : UserCollection.userList) {
										if(userz.getUserName().equals(blocks)){
											if(!searchBar.getText().equals(userz.getName())){
												
													
													if(UserCollection.signinUser.friendList.contains(users.getUserName())){
														btnAddFriend.setVisible(false);
														btnBlockThisUser.setVisible(true);
													
													}
													else if(UserCollection.signinUser.blockedList.contains(users.getUserName())){
														
														btnHome.doClick();
													}
													else{
													
														btnAddFriend.setVisible(true);
														btnBlockThisUser.setVisible(true);
													}
													comboBox.setSelectedItem(users.getRelationship());
													comboBox.setEnabled(false);
													comboBox.setFocusable(false);
													btnHome.setVisible(true);
													btnUpdate.setVisible(false);
													btnRemove.setVisible(false);
													btnCreatePost.setVisible(false);
													username.setText(users.getName());
													DoB.setText(users.getDoB());
													school.setText(users.getSchool());
													myPosts.removeAll();
													friendPosts.removeAll();
													userposts(myPosts,users.getUserName());
													myPosts.repaint();
													friendposts(friendPosts,users.getUserName());
													friendPosts.repaint();
													
													if(rdbtnNormal.isSelected()==true){
														DefaultListModel<String> friendList = new DefaultListModel<String>();
														for (String friendn : users.friendList) {
															friendList.addElement(friendn);
														}
														list.setModel(friendList);
													}
													else if(rdbtnBlock.isSelected()==true){
														DefaultListModel<String> blockList = new DefaultListModel<String>();
														for (String blockn : users.blockedList) {
															blockList.addElement(blockn);
														}
														list.setModel(blockList);
													}
											}
										}
										
									}
							
								}
							}
						
						
						}
					}
		
			
			
			
		}
	
			}
		});
		
		
		
		searchBar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
					for (User users : UserCollection.userList) {
		
							
							if(UserCollection.signinUser.blockedList.size()==0){
							
								if(searchBar.getText().equals(users.getName())){
									
									if(e.getKeyCode()==KeyEvent.VK_ENTER){
										
										if(UserCollection.signinUser.friendList.contains(users.getUserName())){
											btnAddFriend.setVisible(false);
											btnBlockThisUser.setVisible(true);
										}
										else if(UserCollection.signinUser.blockedList.contains(users.getUserName())){
											btnHome.doClick();
										}
										else{
											btnAddFriend.setVisible(true);
											btnBlockThisUser.setVisible(true);
										}
										comboBox.setSelectedItem(users.getRelationship());
										comboBox.setEnabled(false);
										comboBox.setFocusable(false);
										btnHome.setVisible(true);
										btnUpdate.setVisible(false);
										btnRemove.setVisible(false);
										btnCreatePost.setVisible(false);
										username.setText(users.getName());
										DoB.setText(users.getDoB());
										school.setText(users.getSchool());
										myPosts.removeAll();
										friendPosts.removeAll();
										userposts(myPosts,users.getUserName());
										myPosts.repaint();
										friendposts(friendPosts,users.getUserName());
										friendPosts.repaint();
										
										if(rdbtnNormal.isSelected()==true){
											DefaultListModel<String> friendList = new DefaultListModel<String>();
											for (String friendn : users.friendList) {
												friendList.addElement(friendn);
											}
											list.setModel(friendList);
										}
										else if(rdbtnBlock.isSelected()==true){
											DefaultListModel<String> blockList = new DefaultListModel<String>();
											for (String blockn : users.blockedList) {
												blockList.addElement(blockn);
											}
											list.setModel(blockList);
										}
									}
								
							}
							}
							else{
								for (String blocks : UserCollection.signinUser.blockedList) {
									if(!searchBar.getText().equals(blocks)){
										if(searchBar.getText().equals(users.getName())){
											for (User userz : UserCollection.userList) {
												if(userz.getUserName().equals(blocks)){
													if(!searchBar.getText().equals(userz.getName())){
														if(e.getKeyCode()==KeyEvent.VK_ENTER){
															
															if(UserCollection.signinUser.friendList.contains(users.getUserName())){
																btnAddFriend.setVisible(false);
																btnBlockThisUser.setVisible(true);
															
															}
															else if(UserCollection.signinUser.blockedList.contains(users.getUserName())){
																
																btnHome.doClick();
															}
															else{
															
																btnAddFriend.setVisible(true);
																btnBlockThisUser.setVisible(true);
															}
															comboBox.setSelectedItem(users.getRelationship());
															comboBox.setEnabled(false);
															comboBox.setFocusable(false);
															btnHome.setVisible(true);
															btnUpdate.setVisible(false);
															btnRemove.setVisible(false);
															btnCreatePost.setVisible(false);
															username.setText(users.getName());
															DoB.setText(users.getDoB());
															school.setText(users.getSchool());
															myPosts.removeAll();
															friendPosts.removeAll();
															userposts(myPosts,users.getUserName());
															myPosts.repaint();
															friendposts(friendPosts,users.getUserName());
															friendPosts.repaint();
															
															if(rdbtnNormal.isSelected()==true){
																DefaultListModel<String> friendList = new DefaultListModel<String>();
																for (String friendn : users.friendList) {
																	friendList.addElement(friendn);
																}
																list.setModel(friendList);
															}
															else if(rdbtnBlock.isSelected()==true){
																DefaultListModel<String> blockList = new DefaultListModel<String>();
																for (String blockn : users.blockedList) {
																	blockList.addElement(blockn);
																}
																list.setModel(blockList);
															}
													}
												}
												
											}
									
										}
									}
								}
								}
							}
				
					
					
					
				}
			}
		});
		
		
		
		
		
		
		////////////////////////////
		////////////////////
//		JLabel lblTaggedUser = new JLabel(" Tagged Users: ");
//		lblTaggedUser.setVerticalAlignment(SwingConstants.BOTTOM);
//		lblTaggedUser.setFont(new Font("Tahoma", Font.PLAIN, 11));
//		lblTaggedUser.setBounds(0, -1, 485, 78);
//		friendPosts.add(lblTaggedUser);
//		
//		JLabel lblTagsUser = new JLabel("Tagli user");
//		lblTagsUser.setBounds(77, 63, 308, 14);
//		friendPosts.add(lblTagsUser);
//		
//		JLabel lblWhich = new JLabel("T");
//		lblWhich.setFont(new Font("Tahoma", Font.BOLD, 27));
//		lblWhich.setBounds(2, 12, 22, 35);
//		friendPosts.add(lblWhich);
//		
//		JLabel lblText = new JLabel("text");
//		lblText.setVerticalAlignment(SwingConstants.TOP);
//		lblText.setForeground(Color.BLUE);
//		lblText.setBounds(30, 18, 432, 44);
//		friendPosts.add(lblText);
//		
//		JLabel lblWho = new JLabel(" has shared");
//		lblWho.setBounds(4, 2, 328, 14);
//		friendPosts.add(lblWho);
		/////////////////////////////
		/////////////////////
		//////////////////////////
		
		userposts(myPosts,UserCollection.signinUser.getUserName());
		friendposts(friendPosts,UserCollection.signinUser.getUserName());
		myPosts.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(488, 0, 17, 417);
		myPosts.add(scrollBar);
		
		
		
//		scroll.setBounds(487, -3, 17, 420);
//		myPosts.add(scroll);
		
		
		
		
		
		
		
		

			/////
//		JLabel lblTaggedUsers_1 = new JLabel(" Tagged Users: ");
//		Border border = BorderFactory.createLineBorder(Color.BLACK,1);
//		lblTaggedUsers_1.setBorder(border);
//		lblTaggedUsers_1.setVerticalAlignment(SwingConstants.BOTTOM);
//		lblTaggedUsers_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
//		lblTaggedUsers_1.setBounds(1, 0, 485, 78);
//		myPosts.add(lblTaggedUsers_1);
//		
//		JLabel label_which = new JLabel("T");
//		label_which.setFont(new Font("Tahoma", Font.BOLD, 27));
//		label_which.setBounds(1, 4, 22, 35);
//		myPosts.add(label_which);
//		
//		JLabel lblText_1 = new JLabel("fcgfdshrsdfhsfdhdfsgsfdgsdfgdsfg");
//		lblText_1.setForeground(Color.BLUE);
//		lblText_1.setVerticalAlignment(SwingConstants.TOP);
//		lblText_1.setBounds(20, 2, 320, 55);
//		myPosts.add(lblText_1);
//	
//		JLabel lblTagged = new JLabel("sdgsfdgsdf");
//     	lblTagged.setBounds(78, 63, 308, 14);
//		myPosts.add(lblTagged);
//		
//		JButton button = new JButton("Tag Users");
//		button.setBounds(378, 4, 105, 35);
//		myPosts.add(button);
//		
			
		/////////
		
		
		frmProfilePage.setVisible(true);
	}

	
	
	public static void userposts(JPanel jpanel, String user){
		for (User users : UserCollection.userList) {
			if(users.getUserName().equals(user)){
				if(users.posts.size()>0){ 
					int distance=0;
				
					for (Post posts : users.posts) {
						
						if(posts.getClass().equals(TextPosts.class)){
							posts = (TextPosts)posts;
							JLabel lblTaggedUsers_1 = new JLabel(" Tagged Users: ");
							Border border = BorderFactory.createLineBorder(Color.BLACK,1);
							lblTaggedUsers_1.setBorder(border);
							lblTaggedUsers_1.setVerticalAlignment(SwingConstants.BOTTOM);
							lblTaggedUsers_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
							lblTaggedUsers_1.setBounds(1, 0+distance, 485, 78);
							jpanel.add(lblTaggedUsers_1);
							for(String tags : UserCollection.tagList){
								posts.taggedList.add(tags);
							}
							JLabel lblText_1 = new JLabel(posts.getText());
							lblText_1.setForeground(Color.BLUE);
							lblText_1.setVerticalAlignment(SwingConstants.TOP);
							lblText_1.setBounds(20, 2+distance, 320, 55);
							jpanel.add(lblText_1);
							
							JLabel lblTagged = new JLabel(posts.toString());
							lblTagged.setBounds(78, 63+distance, 308, 14);
							jpanel.add(lblTagged);
							JButton button = new JButton("Tag Users");
							button.setBounds(378, 4+distance, 105, 35);
							jpanel.add(button);
							
							
							JLabel label_which = new JLabel("T");
							label_which.setFont(new Font("Tahoma", Font.BOLD, 27));
							label_which.setBounds(1, 4+distance, 22, 35);
							jpanel.add(label_which);
							
							
							
							distance+=80;
							button.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									
									TagUser tu = new TagUser();
									
									
									
						}
							});
							UserCollection.tagList.remove(0);
						}
							
							
						
						else if(posts.getClass().equals(ImagePosts.class)){
							
							JLabel lblTaggedUsers_1 = new JLabel(" Tagged Users: ");
							Border border = BorderFactory.createLineBorder(Color.BLACK,1);
							lblTaggedUsers_1.setBorder(border);
							lblTaggedUsers_1.setVerticalAlignment(SwingConstants.BOTTOM);
							lblTaggedUsers_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
							lblTaggedUsers_1.setBounds(1, 0+distance, 485, 78);
							jpanel.add(lblTaggedUsers_1);
					
							JLabel lblText_1 = new JLabel(posts.getText());
							lblText_1.setForeground(Color.BLUE);
							lblText_1.setVerticalAlignment(SwingConstants.TOP);
							lblText_1.setBounds(20, 2+distance, 320, 55);
							jpanel.add(lblText_1);
							
							JLabel lblTagged = new JLabel(posts.toString());
							lblTagged.setBounds(78, 63+distance, 308, 14);
							jpanel.add(lblTagged);
							JLabel label_which = new JLabel("I");
							label_which.setFont(new Font("Tahoma", Font.BOLD, 27));
							label_which.setBounds(1, 4+distance, 22, 35);
							jpanel.add(label_which);
							JButton button = new JButton("Tag Users");
							button.setBounds(378, 4+distance, 105, 35);
							jpanel.add(button);
							
							distance+=80;
							button.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									TagUser tu =new TagUser();
								}
							});
						}
							
						
						else if(posts.getClass().equals(VideoPosts.class)){
							JLabel lblTaggedUsers_1 = new JLabel(" Tagged Users: ");
							Border border = BorderFactory.createLineBorder(Color.BLACK,1);
							lblTaggedUsers_1.setBorder(border);
							lblTaggedUsers_1.setVerticalAlignment(SwingConstants.BOTTOM);
							lblTaggedUsers_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
							lblTaggedUsers_1.setBounds(1, 0+distance, 485, 78);
							jpanel.add(lblTaggedUsers_1);
					
							JLabel lblText_1 = new JLabel(posts.getText());
							lblText_1.setForeground(Color.BLUE);
							lblText_1.setVerticalAlignment(SwingConstants.TOP);
							lblText_1.setBounds(20, 2+distance, 320, 55);
							jpanel.add(lblText_1);
							
							JLabel lblTagged = new JLabel(posts.toString());
							lblTagged.setBounds(78, 63+distance, 308, 14);
							jpanel.add(lblTagged);
							JButton button = new JButton("Tag Users");
							button.setBounds(378, 4+distance, 105, 35);
							jpanel.add(button);
							JLabel label_which = new JLabel("");
							label_which.setFont(new Font("Tahoma", Font.BOLD, 27));
							label_which.setBounds(1, 4+distance, 22, 35);
							jpanel.add(label_which);
							distance+=80;
							button.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									TagUser tu =new TagUser();
								}
							});
							
					}
						
				}
			}
		}
		}

	}
	public static void friendposts(JPanel jpanel, String user){
		for (User users : UserCollection.userList) {
			if(users.getUserName().equals(user)){
				int space=0;
				for (String friends : users.friendList) {
					for (User usern : UserCollection.userList) {
						if(usern.getUserName().equals(friends)){
							if(usern.posts.size()>0){
								
								for (Post postn : usern.posts) {
									if(postn.getClass().equals(TextPosts.class)){
										JLabel lblTaggedUser = new JLabel(" Tagged Users: ");
										Border border = BorderFactory.createLineBorder(Color.BLACK,1);
										lblTaggedUser.setBorder(border);
										lblTaggedUser.setVerticalAlignment(SwingConstants.BOTTOM);
										lblTaggedUser.setFont(new Font("Tahoma", Font.PLAIN, 11));
										lblTaggedUser.setBounds(0, -1+space, 485, 78);
										jpanel.add(lblTaggedUser);
										
										JLabel lblTagsUser = new JLabel(postn.toString());
										lblTagsUser.setBounds(77, 63+space, 308, 14);
										jpanel.add(lblTagsUser);
										
										JLabel lblWhich = new JLabel("T");
										lblWhich.setFont(new Font("Tahoma", Font.BOLD, 27));
										lblWhich.setBounds(2, 12+space, 22, 35);
										jpanel.add(lblWhich);
										
										JLabel lblText = new JLabel(postn.getText());
										lblText.setVerticalAlignment(SwingConstants.TOP);
										lblText.setForeground(Color.BLUE);
										lblText.setBounds(30, 18+space, 432, 44);
										jpanel.add(lblText);
										
										JLabel lblWho = new JLabel(usern.getName()+" has shared");
										lblWho.setBounds(4, 2+space, 328, 14);
										jpanel.add(lblWho);
										space+=80;
									}
									else if(postn.getClass().equals(ImagePosts.class)){
										JLabel lblTaggedUser = new JLabel(" Tagged Users: ");
										Border border = BorderFactory.createLineBorder(Color.BLACK,1);
										lblTaggedUser.setBorder(border);
										lblTaggedUser.setVerticalAlignment(SwingConstants.BOTTOM);
										lblTaggedUser.setFont(new Font("Tahoma", Font.PLAIN, 11));
										lblTaggedUser.setBounds(0, -1+space, 485, 78);
										jpanel.add(lblTaggedUser);
										
										JLabel lblTagsUser = new JLabel(postn.toString());
										lblTagsUser.setBounds(77, 63+space, 308, 14);
										jpanel.add(lblTagsUser);
										
										JLabel lblWhich = new JLabel("I");
										lblWhich.setFont(new Font("Tahoma", Font.BOLD, 27));
										lblWhich.setBounds(2, 12+space, 22, 35);
										jpanel.add(lblWhich);
										
										JLabel lblText = new JLabel(postn.getText());
										lblText.setVerticalAlignment(SwingConstants.TOP);
										lblText.setForeground(Color.BLUE);
										lblText.setBounds(30, 18+space, 432, 44);
										jpanel.add(lblText);
										
										JLabel lblWho = new JLabel(usern.getName()+" has shared");
										lblWho.setBounds(4, 2+space, 328, 14);
										jpanel.add(lblWho);
										space+=80;
									}
									else if(postn.getClass().equals(VideoPosts.class)){
										JLabel lblTaggedUser = new JLabel(" Tagged Users: ");
										Border border = BorderFactory.createLineBorder(Color.BLACK,1);
										lblTaggedUser.setBorder(border);
										lblTaggedUser.setVerticalAlignment(SwingConstants.BOTTOM);
										lblTaggedUser.setFont(new Font("Tahoma", Font.PLAIN, 11));
										lblTaggedUser.setBounds(0, -1+space, 485, 78);
										jpanel.add(lblTaggedUser);
										
										JLabel lblTagsUser = new JLabel(postn.toString());
										lblTagsUser.setBounds(77, 63+space, 308, 14);
										jpanel.add(lblTagsUser);
										
										JLabel lblWhich = new JLabel("V");
										lblWhich.setFont(new Font("Tahoma", Font.BOLD, 27));
										lblWhich.setBounds(2, 12+space, 22, 35);
										jpanel.add(lblWhich);
										
										JLabel lblText = new JLabel(postn.getText());
										lblText.setVerticalAlignment(SwingConstants.TOP);
										lblText.setForeground(Color.BLUE);
										lblText.setBounds(30, 18+space, 432, 44);
										jpanel.add(lblText);
										
										JLabel lblWho = new JLabel(usern.getName()+" has shared");
										lblWho.setBounds(4, 2+space, 328, 14);
										jpanel.add(lblWho);
										
										space+=80;
									}
									
								}
							}
							
						}
					}
					
				}
			}
		}
		
	}
				
			
	class AutoSuggestor {

	    private final JTextField textField;
	    private final Window container;
	    private JPanel suggestionsPanel;
	    private JWindow autoSuggestionPopUpWindow;
	    private String typedWord;
	    private final ArrayList<String> dictionary = new ArrayList<>();
	    private int currentIndexOfSpace, tW, tH;
	    private DocumentListener documentListener = new DocumentListener() {
	        @Override
	        public void insertUpdate(DocumentEvent de) {
	            checkForAndShowSuggestions();
	        }

	        @Override
	        public void removeUpdate(DocumentEvent de) {
	            checkForAndShowSuggestions();
	        }

	        @Override
	        public void changedUpdate(DocumentEvent de) {
	            checkForAndShowSuggestions();
	        }
	    };
	    private final Color suggestionsTextColor;
	    private final Color suggestionFocusedColor;

	    public AutoSuggestor(JTextField textField, Window mainWindow, ArrayList<String> words, Color popUpBackground, Color textColor, Color suggestionFocusedColor, float opacity) {
	        this.textField = textField;
	        this.suggestionsTextColor = textColor;
	        this.container = mainWindow;
	        this.suggestionFocusedColor = suggestionFocusedColor;
	        this.textField.getDocument().addDocumentListener(documentListener);

	        setDictionary(words);

	        typedWord = "";
	        currentIndexOfSpace = 0;
	        tW = 0;
	        tH = 0;

	        autoSuggestionPopUpWindow = new JWindow(mainWindow);
	        autoSuggestionPopUpWindow.setOpacity(opacity);

	        suggestionsPanel = new JPanel();
	        suggestionsPanel.setLayout(new GridLayout(0, 1));
	        suggestionsPanel.setBackground(popUpBackground);

	        addKeyBindingToRequestFocusInPopUpWindow();
	    }

	    private void addKeyBindingToRequestFocusInPopUpWindow() {
	        textField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "Down released");
	        textField.getActionMap().put("Down released", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent ae) {//focuses the first label on popwindow
	                for (int i = 0; i < suggestionsPanel.getComponentCount(); i++) {
	                    if (suggestionsPanel.getComponent(i) instanceof SuggestionLabel) {
	                        ((SuggestionLabel) suggestionsPanel.getComponent(i)).setFocused(true);
	                        autoSuggestionPopUpWindow.toFront();
	                        autoSuggestionPopUpWindow.requestFocusInWindow();
	                        suggestionsPanel.requestFocusInWindow();
	                        suggestionsPanel.getComponent(i).requestFocusInWindow();
	                        break;
	                    }
	                }
	            }
	        });
	        suggestionsPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "Down released");
	        suggestionsPanel.getActionMap().put("Down released", new AbstractAction() {
	            int lastFocusableIndex = 0;

	            @Override
	            public void actionPerformed(ActionEvent ae) {//allows scrolling of labels in pop window (I know very hacky for now :))

	                ArrayList<SuggestionLabel> sls = getAddedSuggestionLabels();
	                int max = sls.size();

	                if (max > 1) {//more than 1 suggestion
	                    for (int i = 0; i < max; i++) {
	                        SuggestionLabel sl = sls.get(i);
	                        if (sl.isFocused()) {
	                            if (lastFocusableIndex == max - 1) {
	                                lastFocusableIndex = 0;
	                                sl.setFocused(false);
	                                autoSuggestionPopUpWindow.setVisible(false);
	                                setFocusToTextField();
	                                checkForAndShowSuggestions();//fire method as if document listener change occured and fired it

	                            } else {
	                                sl.setFocused(false);
	                                lastFocusableIndex = i;
	                            }
	                        } else if (lastFocusableIndex <= i) {
	                            if (i < max) {
	                                sl.setFocused(true);
	                                autoSuggestionPopUpWindow.toFront();
	                                autoSuggestionPopUpWindow.requestFocusInWindow();
	                                suggestionsPanel.requestFocusInWindow();
	                                suggestionsPanel.getComponent(i).requestFocusInWindow();
	                                lastFocusableIndex = i;
	                                break;
	                            }
	                        }
	                    }
	                } else {//only a single suggestion was given
	                    autoSuggestionPopUpWindow.setVisible(false);
	                    setFocusToTextField();
	                    checkForAndShowSuggestions();//fire method as if document listener change occured and fired it
	                }
	            }
	        });
	    }

	    private void setFocusToTextField() {
	        container.toFront();
	        container.requestFocusInWindow();
	        textField.requestFocusInWindow();
	    }

	    public ArrayList<SuggestionLabel> getAddedSuggestionLabels() {
	        ArrayList<SuggestionLabel> sls = new ArrayList<>();
	        for (int i = 0; i < suggestionsPanel.getComponentCount(); i++) {
	            if (suggestionsPanel.getComponent(i) instanceof SuggestionLabel) {
	                SuggestionLabel sl = (SuggestionLabel) suggestionsPanel.getComponent(i);
	                sls.add(sl);
	            }
	        }
	        return sls;
	    }

	    private void checkForAndShowSuggestions() {
	        typedWord = getCurrentlyTypedWord();

	        suggestionsPanel.removeAll();//remove previos words/jlabels that were added

	        //used to calcualte size of JWindow as new Jlabels are added
	        tW = 0;
	        tH = 0;

	        boolean added = wordTyped(typedWord);

	        if (!added) {
	            if (autoSuggestionPopUpWindow.isVisible()) {
	                autoSuggestionPopUpWindow.setVisible(false);
	            }
	        } else {
	            showPopUpWindow();
	            setFocusToTextField();
	        }
	    }

	    protected void addWordToSuggestions(String word) {
	        SuggestionLabel suggestionLabel = new SuggestionLabel(word, suggestionFocusedColor, suggestionsTextColor, this);

	        calculatePopUpWindowSize(suggestionLabel);

	        suggestionsPanel.add(suggestionLabel);
	    }

	    public String getCurrentlyTypedWord() {//get newest word after last white spaceif any or the first word if no white spaces
	        String text = textField.getText();
	        String wordBeingTyped = "";
	        if (text.contains(" ")) {
	            int tmp = text.lastIndexOf(" ");
	            if (tmp >= currentIndexOfSpace) {
	                currentIndexOfSpace = tmp;
	                wordBeingTyped = text.substring(text.lastIndexOf(" "));
	            }
	        } else {
	            wordBeingTyped = text;
	        }
	        return wordBeingTyped.trim();
	    }

	    private void calculatePopUpWindowSize(JLabel label) {
	        //so we can size the JWindow correctly
	        if (tW < label.getPreferredSize().width) {
	            tW = label.getPreferredSize().width;
	        }
	        tH += label.getPreferredSize().height;
	    }

	    private void showPopUpWindow() {
	        autoSuggestionPopUpWindow.getContentPane().add(suggestionsPanel);
	        autoSuggestionPopUpWindow.setMinimumSize(new Dimension(textField.getWidth(), 30));
	        autoSuggestionPopUpWindow.setSize(tW, tH);
	        autoSuggestionPopUpWindow.setVisible(true);

	        int windowX = 0;
	        int windowY = 0;

	        windowX = container.getX() + textField.getX() + 5;
	        if (suggestionsPanel.getHeight() > autoSuggestionPopUpWindow.getMinimumSize().height) {
	            windowY = container.getY() + textField.getY() + textField.getHeight() + autoSuggestionPopUpWindow.getMinimumSize().height;
	        } else {
	            windowY = container.getY() + textField.getY() + textField.getHeight() + autoSuggestionPopUpWindow.getHeight();
	        }

	        autoSuggestionPopUpWindow.setLocation(windowX, windowY);
	        autoSuggestionPopUpWindow.setMinimumSize(new Dimension(textField.getWidth(), 30));
	        autoSuggestionPopUpWindow.revalidate();
	        autoSuggestionPopUpWindow.repaint();

	    }

	    public void setDictionary(ArrayList<String> words) {
	        dictionary.clear();
	        if (words == null) {
	            return;//so we can call constructor with null value for dictionary without exception thrown
	        }
	        for (String word : words) {
	            dictionary.add(word);
	        }
	    }

	    public JWindow getAutoSuggestionPopUpWindow() {
	        return autoSuggestionPopUpWindow;
	    }

	    public Window getContainer() {
	        return container;
	    }

	    public JTextField getTextField() {
	        return textField;
	    }

	    public void addToDictionary(String word) {
	        dictionary.add(word);
	    }

	    boolean wordTyped(String typedWord) {

	        if (typedWord.isEmpty()) {
	            return false;
	        }
	        //System.out.println("Typed word: " + typedWord);

	        boolean suggestionAdded = false;

	        for (String word : dictionary) {//get words in the dictionary which we added
	            boolean fullymatches = true;
	            for (int i = 0; i < typedWord.length(); i++) {//each string in the word
	                if (!typedWord.toLowerCase().startsWith(String.valueOf(word.toLowerCase().charAt(i)), i)) {//check for match
	                    fullymatches = false;
	                    break;
	                }
	            }
	            if (fullymatches) {
	                addWordToSuggestions(word);
	                suggestionAdded = true;
	            }
	        }
	        return suggestionAdded;
	    }
	}

	class SuggestionLabel extends JLabel {

	    private boolean focused = false;
	    private final JWindow autoSuggestionsPopUpWindow;
	    private final JTextField textField;
	    private final AutoSuggestor autoSuggestor;
	    private Color suggestionsTextColor, suggestionBorderColor;

	    public SuggestionLabel(String string, final Color borderColor, Color suggestionsTextColor, AutoSuggestor autoSuggestor) {
	        super(string);

	        this.suggestionsTextColor = suggestionsTextColor;
	        this.autoSuggestor = autoSuggestor;
	        this.textField = autoSuggestor.getTextField();
	        this.suggestionBorderColor = borderColor;
	        this.autoSuggestionsPopUpWindow = autoSuggestor.getAutoSuggestionPopUpWindow();

	        initComponent();
	    }

	    private void initComponent() {
	        setFocusable(true);
	        setForeground(suggestionsTextColor);

	        addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent me) {
	                super.mouseClicked(me);

	                replaceWithSuggestedText();

	                autoSuggestionsPopUpWindow.setVisible(false);
	            }
	        });

	        getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "Enter released");
	        getActionMap().put("Enter released", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent ae) {
	                replaceWithSuggestedText();
	                autoSuggestionsPopUpWindow.setVisible(false);
	            }
	        });
	    }

	    public void setFocused(boolean focused) {
	        if (focused) {
	            setBorder(new LineBorder(suggestionBorderColor));
	        } else {
	            setBorder(null);
	        }
	        repaint();
	        this.focused = focused;
	    }

	    public boolean isFocused() {
	        return focused;
	    }

	    private void replaceWithSuggestedText() {
	        String suggestedWord = getText();
	        String text = textField.getText();
	        String typedWord = autoSuggestor.getCurrentlyTypedWord();
	        String t = text.substring(0, text.lastIndexOf(typedWord));
	        String tmp = t + text.substring(text.lastIndexOf(typedWord)).replace(typedWord, suggestedWord);
	        textField.setText(tmp);
	    }
	}
}

