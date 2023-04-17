import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("Features")
// uncomment line below to pass arguments and run it as a JUnit test
// @IncludeTags("")
// @ExcludeTags("")
public class AppiumTestRunner {

}
