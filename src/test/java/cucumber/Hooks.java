package cucumber;

import framework.AppiumDriverManager;
import framework.BaseClass;
import org.junit.After;
import org.junit.Before;

public class Hooks {


    @Before
    public void setUp() {
        BaseClass.driver = AppiumDriverManager.getDriver();
    }

    @After
    public void tearDown() {
        AppiumDriverManager.quitDriver();
    }


}
