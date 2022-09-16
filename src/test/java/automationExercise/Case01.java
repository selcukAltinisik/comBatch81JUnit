package automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Case01 {


    public class Odev02_Exercise01 {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click on 'Signup / Login' button
        //5. Verify 'New User Signup!' is visible
        //6. Enter name and email address
        //7. Click 'Signup' button
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        //9. Fill details: Title, Name, Email, Password, Date of birth
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        //14. Verify that 'ACCOUNT CREATED!' is visible
        //15. Click 'Continue' button
        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

        WebDriver driver;

        @Before
        public void before() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }

        @Test
        public void method01() {
            //2. Navigate to url 'http://automationexercise.com'
            driver.get("http://automationexercise.com");

            //3. Verify that home page is visible successfully
            driver.getTitle();

            //4. Click on 'Signup / Login' button
            driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

            //5. Verify 'New User Signup!' is visible
            WebElement newUserSignUp = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
            if (newUserSignUp.isDisplayed()) {
                System.out.println("New User Signup! is visible - PASSED");
            } else System.out.println("New User Signup! is not visible - FAILED");

            //6. Enter name and email address
            driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Fatih Kurkcu");
            driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("fkurkcu@st.swps.edu.pl");

            //7. Click 'Signup' button
            driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

            //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
            WebElement enterAccounInformation = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
            if (enterAccounInformation.isDisplayed()) {
                System.out.println("Enter Account Information is visible - PASSED");
            } else System.out.println("Enter Account Information is not visible - FAILED");

            //9. Fill details: Title, Name, Email, Password, Date of birth

            driver.findElement(By.id("id_gender1")).click();
            driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Fth-2010.");
            driver.findElement(By.xpath("//select[@data-qa='days']")).sendKeys("15");
            driver.findElement(By.xpath("//select[@data-qa='months']")).sendKeys("June");
            driver.findElement(By.xpath("//select[@data-qa='years']")).sendKeys("1994");

        /*

        //10. Select checkbox 'Sign up for our newsletter!'
        WebElement newsletter = driver.findElement(By.xpath("//*[@id='newsletter']"));
        newsletter.click();

        //11. Select checkbox 'Receive special offers from our partners!'
        WebElement checkbox = driver.findElement(By.xpath("//*[@id='uniform-optin']"));
        checkbox.click();
        */

            //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

            WebElement name = driver.findElement(By.xpath("//*[@id='first_name']"));
            name.sendKeys("Fatih");
            WebElement lastname = driver.findElement(By.xpath("//*[@id='last_name']"));
            lastname.sendKeys("Kurkcu");
            WebElement company = driver.findElement(By.xpath("//*[@id='company']"));
            company.sendKeys("Company");
            WebElement address = driver.findElement(By.xpath("//*[@id='address1']"));
            address.sendKeys("Ataturk Cad.02-212.Company");
            WebElement address2 = driver.findElement(By.xpath("//*[@id='address2']"));
            address2.sendKeys("Cumhuriyet Cad.02-213.Company");
            WebElement country = driver.findElement(By.xpath("//*[@id='country']"));
            country.sendKeys("Canada");
            WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
            state.sendKeys("Center");
            WebElement city = driver.findElement(By.xpath("//*[@id='city']"));
            city.sendKeys("Ohio");
            WebElement zipcode = driver.findElement(By.xpath("//*[@id='zipcode']"));
            zipcode.sendKeys("02-212");
            WebElement mobilenum = driver.findElement(By.xpath("//*[@id='mobile_number']"));
            mobilenum.sendKeys("555555555");

            //13. Click 'Create Account button'
            driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

            //14. Verify that 'ACCOUNT CREATED!' is visible
            driver.findElement(By.xpath("//*[@data-qa='account-created']")).isDisplayed();

            //15. Click 'Continue' button
            driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();

            //16. Verify that 'Logged in as username' is visible
            driver.findElement(By.xpath("//*[@class='fa fa-user']")).isDisplayed();

            //17. Click 'Delete Account' button
            driver.findElement(By.xpath("//*[@class='fa fa-trash-o']")).click();

            //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
            driver.findElement(By.xpath("//*[@class='text-center']")).isDisplayed();
            //Are you sure you want to delete this Delete Account?
            driver.findElement(By.xpath("(//*[@class='button-form'])[1]")).click(); //delete button


        }

    }
}
