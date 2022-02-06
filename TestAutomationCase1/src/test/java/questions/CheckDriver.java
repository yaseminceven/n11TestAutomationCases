package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.isInitialised;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.initialize;

//class to check whether the driver is initialised
public class CheckDriver implements Question {
    @Override
    public Object answeredBy(Actor actor) {

        boolean checkDriver = isInitialised();
        if (checkDriver) {
        } else {
            initialize();
        }
        return null;
    }

    public static CheckDriver checkDriver(){
        return new CheckDriver();
    }
}
