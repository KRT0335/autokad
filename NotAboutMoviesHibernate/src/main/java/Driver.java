import com.revature.model.Playlist;
import com.revature.model.Account;
import com.revature.service.PlaylistService;
import com.revature.service.UserService;

public class Driver {

	public static void main(String[] args) {
		
		UserService us = new UserService();
		PlaylistService ps = new PlaylistService();
		
		Playlist pl1 = new Playlist(1, "Favorite", "Unravel");
		Account user1 = new Account(1, "Debbus Horrendus", "username1", "password", pl1);
		
		ps.insertPlaylist(pl1);
		us.insertUser(user1);
		System.out.println(us.getAllUsers());
		
		
	}
}
