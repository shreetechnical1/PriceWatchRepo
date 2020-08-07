package keywordDrivenFrameworkTests;

import keywordDrivenFramework.KeywordEngine;
import org.junit.Test;

public class KeywordDriven_Test extends KeywordEngine {

    @Test
    public void loginWithValidCredentials(){
        startExecution("login");

    }
}
