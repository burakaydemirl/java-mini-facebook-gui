/**
 * @author Burak
 * @version 1.2
 * 
 */
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Post implements PostInterface {
	
	CopyOnWriteArrayList<String> taggedList=new CopyOnWriteArrayList<String>();
	private UUID postID;
	private String text;
	private Date postDate;
	private double longitude;
	private double latitude;
	
	

	public Post(UUID postID, Date postDate, String text, double longitude, double latitude){
		this.postID=postID;
		this.text=text;
		this.latitude=latitude;
		this.longitude=longitude;
		this.postDate=postDate;
		
	}
	
	@Override
	public UUID getPostID() {
		return postID;
	}

	@Override
	public String getText() {
		return text;
	}
	@Override
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public Date getPostDate() {
		return postDate;
	}
	
	public double getLongitude() {
		return longitude;
	}


	public double getLatitude() {
		return latitude;
	}




	
}
