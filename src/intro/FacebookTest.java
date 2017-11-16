package intro;

import org.openqa.selenium.By;

public class FacebookTest extends ParentTest{

	public static void main(String[] args) {
		setUp();
		testFriendSearch("Curso Selenium Victor");
		tearDown();

	}

	private static void testFriendSearch(String friendName) {
		loginToFacebook("clase.selenium.victor@gmail.com", "Test1234");
		searchFriend(friendName);
		addFriend(friendName);
		
	}

	private static void addFriend(String friendName) {
		inputText(By.id(""), friendName);
		clickElement(By.id(""));
		
	}

	private static void searchFriend(String friendName) {
		// TODO Auto-generated method stub
		
	}

	private static void loginToFacebook(String email, String password) {
		// TODO Auto-generated method stub
		
	}

}
