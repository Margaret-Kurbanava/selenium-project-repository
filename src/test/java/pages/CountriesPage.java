package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Iterables.isEmpty;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class CountriesPage {

    private WebDriver driver;

    public CountriesPage(WebDriver driver) {
        this.driver = driver;
    }


    private By countryLink = By.cssSelector("form[name='countries_form'] a:not([title=\"Edit\"])");
    // or "table.dataTable a:not([title="Edit"])"

    private By zone = By.cssSelector("#table-zones input[name*='name']");

    private String CountriesPage = "http://localhost/litecart/admin/?app=countries&doc=countries";


    public void openCountriesPage() {
        driver.get(CountriesPage);
    }


    //Get Countries List
    public List<String> getCountries() {
        List<WebElement> countries = driver.findElements(countryLink);
        return countries.stream().map(e -> e.getText()).collect(Collectors.toList());
    }


    //This class checks sorting
    public static boolean isSorted(List<String> listOfStrings) {
        if (isEmpty(listOfStrings) || listOfStrings.size() == 1) {
            return true;
        }

        Iterator<String> iter = listOfStrings.iterator();
        String current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.compareTo(current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    //checkSorting
    public boolean checkSorting() {
        List<String> countriesList = getCountries();
        return isSorted(countriesList);
    }

    // collect all zones and verify if the list is sorted
    public void checkZones(){

        List<WebElement> countriesLinks = driver.findElements(countryLink);
        for (int i = 0; i < countriesLinks.size(); i++) {

            countriesLinks.get(i).click();

            List<WebElement> zones = driver.findElements(zone);


if (zones.size()>1) {
    List<String> zonesList = zones.stream().map(e -> e.getAttribute("value")).collect(Collectors.toList());

    System.out.println(isSorted(zonesList));

}



            driver.navigate().back();
            countriesLinks = driver.findElements(countryLink);

        }




















    }


}

















