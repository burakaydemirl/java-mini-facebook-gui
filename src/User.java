import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Burak
 *
 */
public class User {
	private String name;
	private int userID;
	protected String userName;
	private String pass;
	private String DoB;
	String school;
	Date lastLogin;
	String relationship;
	
	CopyOnWriteArrayList<String> friendList=new CopyOnWriteArrayList<String>();
	CopyOnWriteArrayList<String> blockedList=new CopyOnWriteArrayList<String>();
	CopyOnWriteArrayList<Post> posts=new CopyOnWriteArrayList<Post>();

	
	
	public User(int userID,String name,  String userName, String pass,String DoB,String school,String relationship) {
		this.userID = userID;
		this.name = name;
		this.userName = userName;
		this.pass = pass;
		this.DoB=DoB;
		this.school = school;
		this.relationship = relationship;
		
	}
	//----Getters and Setters-------

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getUserID() {
		return userID;
	}

	
	public String getUserName() {
		return userName;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getDoB() {
		return DoB;
	}


	public void setDoB(String doB) {
		DoB = doB;
	}


	public String getSchool() {
		return school;
	}


	public void setSchool(String school) {
		this.school = school;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	

	//-------------------------------


	
}
