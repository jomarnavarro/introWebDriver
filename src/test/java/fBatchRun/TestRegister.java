package fBatchRun;

public class TestRegister extends TestCase {

    public void run() {
        setup("http://vamonos-finance.herokuapp.com");
        
        clickRegisterLink();
        
        inputRegistrationInfo("peter", "pete");
        
        clickRegisterButton();
        
        clickLoginLink();
        
        inputPrefixCredentials("peter", "pete");
        
        clickLoginButton();
        
        validateHomePage();
        
        exitTest(); 
    }


}
