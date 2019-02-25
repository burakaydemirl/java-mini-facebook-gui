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

public class ImagePosts extends TextPosts {

	String imageName;
	int[] resolution;
	
	public ImagePosts(UUID postID, Date postDate, String text, double longitude, double latitude,
			CopyOnWriteArrayList<String> tagged, String imageName, int[] resolution) {
		super(postID, postDate, text, latitude, longitude, tagged);
		this.imageName=imageName;
		this.resolution=resolution;
	}

	public String getImageName() {
		return imageName;
	}


	public int[] getResolution() {
		return resolution;
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
