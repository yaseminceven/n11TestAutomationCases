package pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://www.n11.com/kampanyalar")
public class N11CampaignsMainPage extends PageObject{

    //category button targets
    public static Target MODA_BUTTON = Target.the("Moda category").locatedBy(".campPromTab > li:nth-child(2)");
    public static Target ELEKTRONIK_BUTTON = Target.the("Elektronik category").locatedBy(".campPromTab > li:nth-child(3)");
    public static Target EVYASAM_BUTTON = Target.the("Ev-yasam category").locatedBy(".campPromTab > li:nth-child(4)");
    public static Target ANNEBEBEK_BUTTON = Target.the("Anne-bebek category").locatedBy(".campPromTab > li:nth-child(5)");
    public static Target KOZMETIK_BUTTON = Target.the("Kozmetik category").locatedBy(".campPromTab > li:nth-child(6)");
    public static Target MUCEVHER_BUTTON = Target.the("Mucevher category").locatedBy(".campPromTab > li:nth-child(7)");
    public static Target SPOR_BUTTON = Target.the("Spor category").locatedBy(".campPromTab > li:nth-child(8)");
    public static Target KITAP_BUTTON = Target.the("Kitap-muzik-film-oyun category").locatedBy(".campPromTab > li:nth-child(9)");
    public static Target PETN11_BUTTON = Target.the("Pet N11 category").locatedBy(".campPromTab > li:nth-child(10)");
    public static Target OTOMOTIV_BUTTON = Target.the("Otomotiv-Motosiklet category").locatedBy(".campPromTab > li:nth-child(11)");
    public static Target LOCATION_BUTTON = Target.the("Location pop-up close").locatedBy("#myLocation-close-info");
}
