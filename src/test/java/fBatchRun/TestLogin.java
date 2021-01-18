package fBatchRun;

public class TestLogin extends TestCase {

    public void run() {
        setup("https://vamonos-finance.herokuapp.com");
        
        clickLoginLink();
        inputCredentials("pedro", "pedro");
        clickLoginButton();
        exitTest();
    }
}
