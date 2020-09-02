package br.com.senac.features;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, glue = "br.com.senac.features", features = "./src/features")
public class HomeTests {
    
}