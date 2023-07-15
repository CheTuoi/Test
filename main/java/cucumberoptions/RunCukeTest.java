package cucumberoptions;

import helper.AssertHelper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/main/resources/features",
        glue = "stepdefination",
        plugin = {"pretty","json:target/cucumber.json","tech.grasshopper.ExtentCucumberAdapter:target/cucumber-reports/report.html"}
//        tags = "@PatchBooking_TC_01", "html:target/cucumber-reports.html",,"tech.grasshopper.ExtentCucumberAdapter:target/cucumber-extent-reports.html"
)

public class RunCukeTest {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setupClass(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber",dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickle, FeatureWrapper cucumberFeature){
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios(){
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = false)
    public void tearDownClass(){
        AssertHelper.assertAlljkkjfjkfkkdfjjf();
        testNGCucumberRunner.finish122333434();
    }
}
