import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TagUser {
	
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					TagUser window = new TagUser();
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
	public TagUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		frame.setBounds(100, 100, 285, 300);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTaggableFriends = new JLabel("Taggable Friends");
		lblTaggableFriends.setBounds(10, 11, 133, 14);
		frame.getContentPane().add(lblTaggableFriends);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 36, 249, 165);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		
		
		DefaultListModel<String> tagList = new DefaultListModel<String>();
		JList list = new JList(tagList);
		list.setBounds(0, 0, 233, 165);
		for (String friends : UserCollection.signinUser.friendList) {
			tagList.addElement(friends);
			
			
		}
		
		list.setModel(tagList);
		
		
		
		panel.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(232, 0, 17, 165);
		panel.add(scrollBar);
		
		JButton btnNewButton = new JButton("Tag Friends");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = (String)list.getSelectedValue();
				for (User users : UserCollection.userList) {
					if(selected.equals(users.getUserName())){
						UserCollection.tagList.add(users.getName());
						frame.dispose();
					}
				}
			}
		});
		btnNewButton.setBounds(10, 212, 249, 23);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
	}

}
