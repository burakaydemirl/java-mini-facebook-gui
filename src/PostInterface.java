/**
 * @author Burak
 * @version 1.2
 * 
 */
import java.util.Date;
import java.util.UUID;

public interface PostInterface {
	
	public void setText(String text);
	public String getText();
	public UUID getPostID();
	public Date getPostDate();
	
	
	
}
