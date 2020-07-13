package bIntro;

public class ImdbMovieSearch extends ParentTest{

	public static void main (String[] args) {
		setUp();
		testMovieSearch("It", "Richard Thomas", "1990");
		tearDown();		
	}
}

