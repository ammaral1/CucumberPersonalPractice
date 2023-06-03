package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;

public class AddEmployee extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {

      //  WebElement pimTab= driver.findElement(By.id("menu_pim_viewPimModule"));
        doClick(addEmployeePage.pimTab);

    }
    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {

      //  WebElement addEmployeeBtn= driver.findElement(By.id("menu_pim_addEmployee"));
        doClick(addEmployeePage.addEmployeeBtn);
    }
    @When("user enters firstname and middlename and lastname")
    public void user_enters_firsname_and_middlename_and_lastname() {

       // WebElement firstnameTestBox= driver.findElement(By.id("firstName"));
        sendText(addEmployeePage.firstnameTestBox, ConfigReader.getPropertyValue("firstname"));

      //  driver.findElement(By.id("middleName")).sendKeys(ConfigReader.getPropertyValue("middlename"));
      //  WebElement middlenameTextBox=driver.findElement(By.id("middleName"));
        sendText(addEmployeePage.middlenameTextBox, ConfigReader.getPropertyValue("middlename"));

      //  driver.findElement(By.id("lastName")).sendKeys(ConfigReader.getPropertyValue("lastname"));
      //  WebElement lastnameTextBox=driver.findElement(By.id("lastName"));
        sendText(addEmployeePage.lastnameTextBox, ConfigReader.getPropertyValue("lastname"));
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {

      // WebElement saveBtn= driver.findElement(By.id("btnSave"));
       doClick(addEmployeePage.saveBtn);
    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String firstname, String middlename, String lastname) {
      //  WebElement firstnameTextBox= driver.findElement(By.id("firstName"));
        sendText(addEmployeePage.firstnameTestBox, firstname);

       // WebElement middlenameTextBox=driver.findElement(By.id("middleName"));
        sendText(addEmployeePage.middlenameTextBox,middlename );

       // WebElement lastnameTextBox=driver.findElement(By.id("lastName"));
        sendText(addEmployeePage.lastnameTextBox, lastname );

    }

}
