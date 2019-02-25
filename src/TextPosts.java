/**
 * @author Burak
 * @version 1.2
 * 
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;


public class TextPosts extends Post {
	
	CopyOnWriteArrayList<String> tagged=new CopyOnWriteArrayList<String>();
	
	public TextPosts(UUID postID, Date postDate, String text, double longitude, double latitude, CopyOnWriteArrayList<String> tagged)  {
		super(postID, postDate, text, latitude, longitude);
		this.tagged=tagged;
	}


	public CopyOnWriteArrayList<String> getTagged() {
		return tagged;
	}


	public void setTagged(CopyOnWriteArrayList<String> tagged) {
		this.tagged = tagged;
	}


	public String toString(){
		
		if(tagged.size()==0){
			return "";
		}
		else{
			String tags="";
			for(int i=0;i<tagged.size();i++){				
				tags += tagged.get(i)+", ";
			}
			return tags.substring(0, tags.length()-2);
					
		}
		
	}


	

}
