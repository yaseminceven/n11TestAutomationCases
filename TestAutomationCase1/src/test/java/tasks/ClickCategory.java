package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import pages.N11CampaignsMainPage;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

//class to click on each category
public class ClickCategory implements Task {
    private final String category;

    public ClickCategory(String category) {
        this.category = category;
    }

    @Step("{0} clicks on #category")
    @Override
    public <T extends Actor> void performAs(T actor) {                      //actor clicks on the target category
        actor.attemptsTo(
                WaitUntil.the(getCategoryButton(category),isClickable()).forNoMoreThan(60).seconds(),
                Click.on(getCategoryButton(category))
        );
    }

    //method to get each category button
    private static Target getCategoryButton(String category){                //get category button targets
        Target result = null;
        switch (category){
            case "giyim-ayakkabi":
                result = N11CampaignsMainPage.MODA_BUTTON;
                break;
            case "elektronik":
                result = N11CampaignsMainPage.ELEKTRONIK_BUTTON;
                break;
            case "ev-yasam":
                result = N11CampaignsMainPage.EVYASAM_BUTTON;
                break;
            case "anne-bebek":
                result = N11CampaignsMainPage.ANNEBEBEK_BUTTON;
                break;
            case "kozmetik-kisisel-bakim":
                result = N11CampaignsMainPage.KOZMETIK_BUTTON;
                break;
            case "mucevher-saat":
                result = N11CampaignsMainPage.MUCEVHER_BUTTON;
                break;
            case "spor-outdoor":
                result = N11CampaignsMainPage.SPOR_BUTTON;
                break;
            case "kitap-muzik-film-oyun":
                result = N11CampaignsMainPage.KITAP_BUTTON;
                break;
            case "tatil-eglence":
                result = N11CampaignsMainPage.PETN11_BUTTON;
                break;
            case "otomotiv-motosiklet":
                result = N11CampaignsMainPage.OTOMOTIV_BUTTON;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + category);
        }
        return result;
    }

    public static ClickCategory click(String category){
        return instrumented(ClickCategory.class,category);
    }

}
