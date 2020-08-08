package keywordDrivenFrameworkTests;

import keywordDrivenFramework.KeywordEngine;
import org.junit.Test;

public class KeywordDriven_Test {

    KeywordEngine keywordEngine;

    @Test
    public void loginWithValidCredentials(){
        keywordEngine = new KeywordEngine();
        keywordEngine.startExecution("login");

    }
}
