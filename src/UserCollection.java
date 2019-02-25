/**
 * @author Burak
 * @version 1.2
 * 
 */
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserCollection {


	static CopyOnWriteArrayList<User> userList=new CopyOnWriteArrayList<User>();
	static CopyOnWriteArrayList<String> tagList=new CopyOnWriteArrayList<String>();
	static String taggedList;
	public static User signinUser;
	public UserCollection() {
		
	}

	public static void addUser(int userID,String name,  String userName, String pass,String DoB,String school,String relationship){
		User u=new User(userID, name, userName, pass, DoB, school,relationship);
		userList.add(u);
		
		
	}
	
	
	
	
	public static void ADDFRIEND(String firstPerson, String secondPerson){
	
		int fExit=0;
		int sExit=0;
		int added=0;
		for(User user:userList){
			if(firstPerson.equals(user.getUserName())){
				fExit=1;
				for(User otherUser:userList){
					if(secondPerson.equals(otherUser.getUserName())){
						sExit=1;
						if(!user.friendList.contains(secondPerson)){
							added=1;
							user.friendList.add(secondPerson);
							otherUser.friendList.add(firstPerson);
							System.out.println(secondPerson+" has been successfully added to your friend list.");
						
						}
					}		
				}
			}
			
		}
		
		if(added==0){
			System.out.println("This user is already in your friend list!");
		}
		else if(fExit==0){
			System.out.println(firstPerson+" There is no user");
		}
		else if(sExit==0){
			System.out.println(secondPerson+" There is no user");
		}
		
	}
	
	
	
	public static void BLOCKFRIEND(String firstPerson, String secondPerson){
		
		int fExit=0;
		int sExit=0;
		int added=0;
		for(User user:userList){
			if(firstPerson.equals(user.getUserName())){
				fExit=1;
				for(User otherUser:userList){
					if(secondPerson.equals(otherUser.getUserName())){
						sExit=1;
						if(!user.blockedList.contains(secondPerson)){
							added=1;
							user.friendList.remove(secondPerson);
							user.blockedList.add(secondPerson);
							otherUser.friendList.remove(firstPerson);
							otherUser.blockedList.add(firstPerson);
							System.out.println(secondPerson+" has been successfully added to your block list.");
						
						}
					}		
				}
			}
			
		}
		
		if(added==0){
			System.out.println("This user is already in your block list!");
		}
		else if(fExit==0){
			System.out.println(firstPerson+" There is no user");
		}
		else if(sExit==0){
			System.out.println(secondPerson+" There is no user");
		}
		
	
		
	}
	
	
	
	public static void ADDPOSTTEXT(String userName, String text,double longitude, double latitude,String taggedUsers) throws ParseException{
		
		Location loc = new Location(longitude,latitude);
		CopyOnWriteArrayList<String> taggedList=new CopyOnWriteArrayList<String>();
		
		int userExit=0;
		for(User user:userList){
				if(user.getUserName().equals(userName)){
					userExit=1;
					if(taggedUsers.length()>0){
						String[] tags = taggedUsers.split(":");
						for(int i=0;i<tags.length;i++){
							int tagExit=0;
							for(User alls : userList){
								if(alls.getUserName().equals(tags[i])){
									for(String friends:user.friendList){
										if(alls.getUserName().equals(friends)){
											tagExit=1;
											taggedList.add(alls.getName());
										}
									}
									
									
								}
							}
							if(tagExit==0){
								for(User users:userList){
									if(tags[i].equals(users.getUserName())){
										System.out.println(users.getName()+" is not your friend, and will not be tagged!");
									}
								}
								
							}
							
						}	
						
					}
					Date postDate = new Date();
					
					
					UUID postID = UUID.randomUUID();
					TextPosts tPost = new TextPosts(postID, postDate, text,loc.getLongitude(), loc.getLatitude(),taggedList);
					user.posts.add(tPost);
					System.out.println("The post has been successfully added.");
					
				}
			
			
		}
		if(userExit==0){
			System.out.println("There is no user: "+userName);
		}
		
		
	}
	
	public static void ADDPOSTIMAGE(String userName, String text,double longitude, double latitude,String taggedUsers,String imageName, int[] resolution){
			
			System.out.println("-----------------------");
			System.out.println("Command: ADDPOST-IMAGE\t"+text+"\t"+longitude+"\t"+latitude+"\t"+taggedUsers+"\t"+imageName+"\t"+resolution);
			
			Location loc = new Location(longitude,latitude);
			CopyOnWriteArrayList<String> taggedList=new CopyOnWriteArrayList<String>();
			int userExit=0;
			for(User user:userList){
				if(user.getUserName().equals(userName)){
					userExit=1;
					if(taggedUsers.length()>0){
						String[] tags = taggedUsers.split(":");
						for(int i=0;i<tags.length;i++){
							int tagExit=0;
							for(User alls : userList){
								if(alls.getUserName().equals(tags[i])){
									for(String friends:user.friendList){
										if(alls.getUserName().equals(friends)){
											tagExit=1;
											taggedList.add(alls.getName());
										}
									}
									
									
								}
							}
							if(tagExit==0){
								for(User users:userList){
									if(tags[i].equals(users.getUserName())){
										System.out.println(users.getName()+" is not your friend, and will not be tagged!");
									}
								}
								
							}
							
						}	
						
					}
						Date postDate = new Date();
						UUID postID = UUID.randomUUID();
						ImagePosts tPost = new ImagePosts(postID, postDate, text,loc.getLongitude(), loc.getLatitude(),taggedList,imageName,resolution);
						user.posts.add(tPost);
						System.out.println("The post has been successfully added.");
						
					}
				}
			
				
			if(userExit==0){
				System.out.println("There is no user: "+userName);
			}
	
			
			
			
		}
	

	
	
	public static void ADDPOSTVIDEO(String userName, String text,double longitude, double latitude,String taggedUsers,String videoName, double vidDur){
		
		int durExit=0;
		Location loc = new Location(longitude,latitude);
		CopyOnWriteArrayList<String> taggedList=new CopyOnWriteArrayList<String>();
		int userExit=0;
		for(User user:userList){
			if(user.getUserName().equals(userName)){
				userExit=1;
				if(taggedUsers.length()>0){
					String[] tags = taggedUsers.split(":");
					for(int i=0;i<tags.length;i++){
						int tagExit=0;
						for(User alls : userList){
							if(alls.getUserName().equals(tags[i])){
								for(String friends:user.friendList){
									if(alls.getUserName().equals(friends)){
										tagExit=1;
										taggedList.add(alls.getName());
									}
								}
								
								
							}
						}
						if(tagExit==0){
							for(User users:userList){
								if(tags[i].equals(users.getUserName())){
									System.out.println(users.getName()+" is not your friend, and will not be tagged!");
								}
							}
							
						}
						
					}	
					
				}
			
			
						Date postDate = new Date();
						UUID postID = UUID.randomUUID();
						VideoPosts tPost = new VideoPosts(postID, postDate, text,loc.getLongitude(), loc.getLatitude(),taggedList,videoName,vidDur);
						user.posts.add(tPost);
						System.out.println("The post has been successfully added.");
						}
							
						
					}
					
					
				

			

		if(durExit==0){
			System.out.println("Error: Your video exceeds maximum allowed duration of 10 minutes.");
		}
		else if(userExit==0){
			System.out.println("There is no user: "+userName);
		}
		
		
	}
	
	
	
	
	
	

}
