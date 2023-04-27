package com.eurotech.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports.html",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/Features",
        glue="com/eurotech/step_definitions",
        dryRun =false,
        tags = "@smoke"

//        tags = "@student"
//        tags = "@smoke"
//        tags = "@login"
//        tags = "@Eurotech1 and @teacher"
//        tags = "@Eurotech1 or @teacher"
//        tags = "@login and not @wip"
//        tags = "@login and not @wip and not @developer"

)

public class CukesRunner {

}
