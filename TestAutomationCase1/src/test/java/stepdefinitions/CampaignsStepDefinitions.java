package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import pages.CampaignPage;
import pages.N11CampaignsMainPage;
import tasks.CheckNumOfCampaigns;
import tasks.ClickCategory;
import tasks.NavigateTo;
import tasks.WriteURLsExcel;

import java.io.IOException;

import static net.thucydides.core.annotations.ClearCookiesPolicy.BeforeEachTest;

public class CampaignsStepDefinitions {
    Actor actor = Actor.named("yasemin");                       //defining actor to perform tasks

    @Managed(clearCookies=BeforeEachTest)                       //managing driver
    WebDriver webDriver;

    @Given("user opens the page")
    public void userOpensThePage() {
        actor.can(BrowseTheWeb.with(webDriver));                 //giving actor the ability to browse the page
        actor.wasAbleTo(NavigateTo.openN11CampaignPage());       //actor opens the n11 campaigns page
    }

    @When("user clicks on {string}")
    public void userClicksOnACategory(String category) {
        actor.attemptsTo(Click.on(N11CampaignsMainPage.LOCATION_BUTTON));      //actor closes the location info pop-up
        actor.attemptsTo(ClickCategory.click(category));                       //actor clicks on the campaigns boxes
    }

    @Then("user sees the {string} campaigns list")
    public void userObtainsCampaignsList(String category) throws IOException {
        actor.attemptsTo(WriteURLsExcel.writeToExcel(category));              //actor writes the campaign list to excel

        actor.attemptsTo(
                Ensure.that(CampaignPage.getLinksList(category).size()).isEqualTo(CheckNumOfCampaigns.check(category))   //actor checks if the correct num of campaigns are obtained
        );

        actor.attemptsTo(
                Ensure.that(webDriver.getCurrentUrl()).isEqualTo("https://www.n11.com/kampanyalar#"+category)
        );
        webDriver.quit();
    }
}
