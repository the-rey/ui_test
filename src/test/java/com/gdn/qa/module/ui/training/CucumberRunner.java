package com.gdn.qa.module.ui.training;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/"
        , format = {"json:target/destination/cucumber.json"}
        //,tags = {"@KitadelUserFeature","KitadelTradingFeature"})
        ,tags = {"not @TrainingFeature"})
public class CucumberRunner {
}
