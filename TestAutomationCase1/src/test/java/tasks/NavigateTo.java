package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import pages.N11CampaignsMainPage;

//class to open the main page
public class NavigateTo {
    public static Performable openN11CampaignPage(){
        return Task.where("{0} opens the n11 campaigns page",
                Open.browserOn().the(N11CampaignsMainPage.class));
    }
}
