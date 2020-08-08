package keywordDrivenFrameworkTests;

import keywordDrivenFramework.KeywordEngine;
import org.junit.Test;

public class KeywordDriven_Test {

    KeywordEngine keywordEngine = new KeywordEngine();

    @Test
    public void startTestExecution() throws InterruptedException {
        keywordEngine.startExecution("suite", "login");

    }

}
