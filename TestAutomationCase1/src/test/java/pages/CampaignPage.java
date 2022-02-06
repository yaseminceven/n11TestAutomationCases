package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import questions.CheckDriver;

import java.util.ArrayList;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class CampaignPage {
    private static final List<String> linksList = new ArrayList<>();        //list to store links
    private static List<WebElement> elementsList;                 //list to store elements (for small images elements)

    //method to get campaign links
    public static List<String> getLinksList(String category) {
        CheckDriver.checkDriver();

        List<String> resultList = null;
        switch (category) {
            case "giyim-ayakkabi":
                resultList = setLinksList(3);
                break;
            case "elektronik":
                resultList = setLinksList(4);
                break;
            case "ev-yasam":
                resultList = setLinksList(5);
                break;
            case "anne-bebek":
                resultList = setLinksList(6);
                break;
            case "kozmetik-kisisel-bakim":
                resultList = setLinksList(7);
                break;
            case "mucevher-saat":
                resultList = setLinksList(8);
                break;
            case "spor-outdoor":
                resultList = setLinksList(9);
                break;
            case "kitap-muzik-film-oyun":
                resultList = setLinksList(10);
                break;
            case "tatil-eglence":
                resultList = setPetN11Links(11);
                break;
            case "otomotiv-motosiklet":
                resultList = setLinksList(12);
                break;
            default:
                break;
        }
        return resultList;
    }

    //method to obtains links in a list
    public static List<String> setLinksList(int i){
        WebElement BIGIMG_LINK;                                 //first campaign

        elementsList = getDriver().findElements(By.cssSelector("section.group:nth-child("+i+") > ul > li > a"));
        BIGIMG_LINK = getDriver().findElement(By.cssSelector("section.group:nth-child("+i+") > a"));

        linksList.clear();
        linksList.add(BIGIMG_LINK.getAttribute("href"));
        for (WebElement element:elementsList) {
            linksList.add(element.getAttribute("href"));
        }
        return linksList;
    }

    //method to obtains links in a list for pet n11 (tatil-eglence) category
    public static List<String> setPetN11Links(int i){
        WebElement BIGIMG_LINK;                                 //first campaign

        BIGIMG_LINK = getDriver().findElement(By.cssSelector("section.group:nth-child("+i+") > a"));

        linksList.clear();
        linksList.add(BIGIMG_LINK.getAttribute("href"));

        return linksList;
    }

}
