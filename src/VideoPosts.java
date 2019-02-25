import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class VideoPosts extends TextPosts {
	
	String videoName;
	double vidDur;
	
	public VideoPosts(UUID postID, Date postDate, String text, double longitude, double latitude,
			CopyOnWriteArrayList<String> tagged, String videoName, double vidDur) {
		super(postID, postDate, text, latitude, longitude, tagged);
		this.videoName=videoName;
		this.vidDur=vidDur;
		
	}

	public String getVideoName() {
		return videoName;
	}

	public double getVidDur() {
		return vidDur;
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
