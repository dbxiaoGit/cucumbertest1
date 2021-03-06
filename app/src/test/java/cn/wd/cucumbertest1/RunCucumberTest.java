package cn.wd.cucumbertest1;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = { "html:target/results.html", "message:target/results.ndjson" },
        features = {"src/test/resources/features"},
        glue = {"steps"}
        )
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }

}