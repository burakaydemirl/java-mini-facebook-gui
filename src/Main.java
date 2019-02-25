/**
 * @author Burak
 * @version 1.2
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		
		
		int userID=0;
		//Read user.txt
		try {
					
			Scanner read_file = new Scanner(new File(args[0]));
			while(read_file.hasNextLine()){
			String line = read_file.nextLine();
			String[] part = line.split("\t");
				
			userID++;
			UserCollection.addUser(userID, part[0], part[1], part[2], part[3], part[4], part[5]);
		
	
			}
		read_file.close();
		} catch (FileNotFoundException ex) {
			System.out.println("No File Found!");
			return;
					
					
			}
		
		//Read command.txt
		
		try {
			
			Scanner read_file = new Scanner(new File(args[1]));
			while(read_file.hasNextLine()){
			String line = read_file.nextLine();
			String[] part2 = line.split("\t");
			

			
			if(new String("ADDFRIEND").equals(part2[0])){
				UserCollection.ADDFRIEND(part2[1], part2[2]);;
			}
			
			
			else if(new String("BLOCKFRIEND").equals(part2[0])){
				UserCollection.BLOCKFRIEND(part2[1],part2[2]);
			}
			
			
			else if(new String("ADDPOST-TEXT").equals(part2[0])){
				UserCollection.ADDPOSTTEXT(part2[1], part2[2], Double.parseDouble(part2[3]), Double.parseDouble(part2[4]), part2[5]);
			}
			
			else if(new String("ADDPOST-IMAGE").equals(part2[0])){
				String[] parts= part2[7].split("<x>");
				int[] resolution = new int[2];
				resolution[0]=Integer.parseInt(parts[0]);
				resolution[1]=Integer.parseInt(parts[1]);
				UserCollection.ADDPOSTIMAGE(part2[1], part2[2], Double.parseDouble(part2[3]), Double.parseDouble(part2[4]),
						part2[5], part2[6], resolution);
			}
			
			else if(new String("ADDPOST-VIDEO").equals(part2[0])){
				UserCollection.ADDPOSTVIDEO(part2[1], part2[2], Double.parseDouble(part2[3]), Double.parseDouble(part2[4]), part2[5],
						part2[6], Double.parseDouble(part2[7]));
			}
			
	
			
			
			
			
		
	
			}
		read_file.close();
		} catch (FileNotFoundException ex) {
			System.out.println("No File Found!");
			return;
					
					
			}
		
		
		
		
		
		
		
		
		
		
		LoginPage login = new LoginPage();
		
		}
	
	
	}
