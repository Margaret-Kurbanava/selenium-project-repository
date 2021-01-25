package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

import static pages.CountriesPage.isSorted;

public class GeoZonesPage {

    private WebDriver driver;

    public GeoZonesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private String geozonesPage = "http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones";

    @FindBy(css = ".row a:not([title=\"Edit\"])")
    List<WebElement> countries;

    @FindBy(css = "select[name*='zone_code']")
    List<WebElement> zones;


    public void opengeozonesPage(){
        driver.get(geozonesPage);

    }

    public boolean checkZonesSorting(){

        boolean isSorted = false;

        for (int i = 0; i < countries.size(); i++) {
            countries.get(i).click();

            List <String> zonesSelected = zones.stream().map(e -> e.getText()).collect(Collectors.toList());

            isSorted= isSorted(zonesSelected);
               driver.navigate().back();
        }


        return isSorted;
    }




}
