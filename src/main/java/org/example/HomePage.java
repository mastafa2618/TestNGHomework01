// A package in java is used to group related classes
package org.example;
// importing a package in selenium
import org.openqa.selenium.By;
// importing a package in selenium WebDriver
import org.openqa.selenium.WebDriver;
// importing a package in selenium of ChromeDriver
import org.openqa.selenium.chrome.ChromeDriver;
// importing a package After method
import org.testng.annotations.AfterMethod;
// importing a package Before method
import org.testng.annotations.BeforeMethod;
// importing a package of test
import org.testng.annotations.Test;
// it allows for dates and text formatting

import java.text.SimpleDateFormat;

public class HomePage {
    // method simulated a muse click  on an element


    protected static WebDriver driver;  //

    public void clickOnElement(By by){driver.findElement(by).click();}
    // verifying message, error, asserting WebElements and many more.
    // findElement command is used to uniquely identify a web element within the page
    public String getTextFromElement(By by){ return driver.findElement(by).getText();
    }
    // to input content in editable text fields or password field in a webpage.
    public void typeText(By by,String text){driver.findElement(by).sendKeys(text); }




    @BeforeMethod  // Executes before each test method
    public void OpenBrowser()
    {
        System.setProperty("webdriver.chrome.driver","src/test/java/drivers/chromedriver.exe");
        // setProperty command is used for sets the property of the system which is indicated by a key
        driver = new ChromeDriver();
        // to complete test scripts with Google Chrome
        driver.manage().window().maximize();  // To maximize the browser
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        // printing output for timeStamp
        System.out.println(timeStamp);
        // .get() method is used to open Url and it will wait till whole page gets loaded
        driver.get("https://demo.nopcommerce.com/");

    }
    @AfterMethod // Executes after each test method
    public void closeBrowser()
    {
        driver.quit();
    }


    @Test  // This is a test method
    public void register() {
        // set the path of the driver for the chrome driver
        String timeStamp = new SimpleDateFormat("yyyyMMmmss").format(new java.util.Date());

        // printing output for timeStamp
        System.out.println(timeStamp);

        // method simulates a mouse click on ico-register
        clickOnElement(By.className("ico-register"));

        // method simulates a mouse click on gender-male
        // By.id for (gender-male) locate a particular web element using the value of its id attributes
        clickOnElement(By.id("gender-male"));

        // to input a editable text fields for (FirstName) in a webpage
        // By.id for (FirstName) locate a particular web element using the value of its id attributes
        typeText(By.id("FirstName"),"Mastafa");

        // to input an editable text fields for (LastName) in a webpage
        // By.id for (LastName) locate a particular web element using the value of its id attributes
        typeText(By.id("LastName"),"Monoar");
        // to input an editable text fields for (DateOfBirth) in a webpage
        /*.xpath function for(DateOfBirth) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        typeText(By.xpath("//select[@name=\"DateOfBirthDay\"]"),"2");
        // to input an editable text fields for (MonthOfBirth) in a webpage
        /*.xpath function for(MonthOfBirth) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        typeText(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),"May");
        // to input an editable text fields for (YearOfBirth) in a webpage
        /*.xpath function for(YearOfBirth) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        typeText(By.xpath("//select[@name=\"DateOfBirthYear\"]"),"1985");
        // printing output for timeStamp
        typeText(By.id("Email"),"mast18"+timeStamp+"@gmail.com");
        // to input an editable text fields for (Company Name) in a webpage
        // By.id for (Company) locate a particular web element using the value of its id attributes
        typeText(By.id("Company"),"Mdex Ltd");
        // By.id for (Newsletter) locate a particular web element using the value of its id attributes
        // method simulates a mouse click on Newsletter.
        clickOnElement(By.id("Newsletter"));
        // By.id for (Password) locate a particular web element using the value of its id attributes
        // to input an editable text fields for (Password) in a webpage.
        typeText(By.id("Password"),"M12456");
        // By.id for (ConfirmPassword) locate a particular web element using the value of its id attributes
        // to input an editable text fields for (ConfirmPassword) in a webpage.
        typeText(By.id("ConfirmPassword"),"M12456");
        // method simulates a mouse click on (register-button).
        clickOnElement(By.id("register-button"));

        // verifying message, error, asserting WebElements and many more.
        String regMsg = getTextFromElement(By.className("result"));
        System.out.println();
        // printing output in for regMsg
        System.out.println(regMsg);

    }

    @Test // test method
    public void EmailAFriend(){
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        // printing output for timeStamp
        System.out.println(timeStamp);

        /*.xpath function for(apple-macbook-pro-13-inch) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        // method simulates a mouse click on (apple-macbook-pro-13-inch)
        driver.findElement(By.xpath("//h2[@class=\"product-title\"]/a[@href=\"/apple-macbook-pro-13-inch\"]")).click();

        /*.xpath function for(email-a-friend) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        // method simulates a mouse click on email-a-friend
        driver.findElement(By.xpath("//div[@class=\"email-a-friend\"]/button")).click();

        // By.id for (FriendEmail) locate a particular web element using the value of its id attributes
        // to input an editable text fields for (friendEmail) in a webpage.
        driver.findElement(By.id("FriendEmail")).sendKeys("mast122"+timeStamp+"@gmail.com");

        // By.id for (YourEmail) locate a particular web element using the value of its id attributes
        // to input an editable text fields for (YourEmail) in a webpage.
        driver.findElement(By.id("YourEmailAddress")).sendKeys("mast12"+timeStamp+"@gmail.com");

        // By.name for (PersonalMessage) locate a particular web element using the value of its name attributes
        // to input an editable text fields for (PersonalMessage) in a webpage
        driver.findElement(By.name("PersonalMessage")).sendKeys("Great Feature");

        // By.name for (send-email) locate a particular web element using the value of its name attributes
        // method simulates a mouse click on send-email
        driver.findElement(By.name("send-email")).click();

        // verifying message, error, asserting WebElements and many more.
        String regMsg = driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul/li")).getText();
        System.out.println(); // for space
        System.out.println(regMsg); // print message in console
    }

    @Test
    public void HomePageCategories()
    {
        // verifying message, error, asserting WebElements and many more.
         /*.xpath function for(computers) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        String regMsg = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/computers\"]")).getText();
        System.out.println();
        System.out.println(regMsg); // to print message in console

        // verifying message, error, asserting WebElements and many more.
         /*.xpath function for(electronics) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        String regMsg2 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/a")).getText();
        System.out.println(); // for space in console
        System.out.println(regMsg2);  // to print message in console

        // verifying message, error, asserting WebElements and many more.
         /*.xpath function for(apparel) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        String regMsg3 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[3]/a")).getText();
        System.out.println(); // for space in console
        System.out.println(regMsg3); // to print message in console

        // verifying message, error, asserting WebElements and many more.
         /*.xpath function for(digital-download) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        String regMsg4 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[4]/a")).getText();
        System.out.println(); // for space in console
        System.out.println(regMsg4); // to print message in console

        // verifying message, error, asserting WebElements and many more.
         /*.xpath function for(books) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        String regMsg5 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[5]/a")).getText();
        System.out.println(); // for space in console
        System.out.println(regMsg5); // to print message in console

        // verifying message, error, asserting WebElements and many more.
         /*.xpath function for(jewelry) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        String regMsg6 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[6]/a")).getText();
        System.out.println(); // for space in console
        System.out.println(regMsg6); // to print message in console

        // verifying message, error, asserting WebElements and many more.
         /*.xpath function for(Gift Cards) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        String regMsg7 = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/gift-cards\"]")).getText();
        System.out.println(); // for space in console
        System.out.println(regMsg7); // to print message in console

    }
    @Test
    public void NewsComments()
    {
        // By.name for (red-more) locate a particular web element using the value of its names attributes
        // method simulates a mouse click on read-more
        driver.findElement(By.className("read-more")).click();

        // By.id for (AddNewComment_CommentTitle) locate a particular web element using the value of its id attributes
        // to input an editable text fields for in a webpage
        driver.findElement(By.id("AddNewComment_CommentTitle")).sendKeys("Mac Released");

        // By.id for (AddNewComment_CommentTitle) locate a particular web element using the value of its id attributes
        // to input an editable text fields for in a webpage
        driver.findElement(By.id("AddNewComment_CommentText")).sendKeys("Great Feature!");

        // verifying message, error, asserting WebElements and many more.
         /*.xpath function for(result) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        String regMsg = driver.findElement(By.xpath("//div[@class=\"buttons\"]/button")).getText();
        System.out.println(); // for space in console
        System.out.println(regMsg); // to print message in console
    }
    @Test

    public void Products()
    {
        /*.xpath function for(computers) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        // method simulates a mouse click on an element
        driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]/a[@href=\"/computers\"]")).click();

        /*.xpath function for(Show products in category Desktops) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        // method simulates a mouse click on an element
        driver.findElement(By.xpath("//h2[@class=\"title\"]/a[@title=\"Show products in category Desktops\"]")).click();

        /*.xpath function for(build-your-own-computer) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        // method simulates a mouse click on an element
        String regMsg = driver.findElement(By.xpath("//h2[@class=\"product-title\"]/a[@href=\"/build-your-own-computer\"]")).getText();

        /*.xpath function for(digital-storm-vanquish-3-custom-performance-pc) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        // method simulates a mouse click on an element
        String regMs1 = driver.findElement(By.xpath("//h2[@class=\"product-title\"]//a[@href=\"/digital-storm-vanquish-3-custom-performance-pc\"]")).getText();

        /*.xpath function for(lenovo-ideacentre-600-all-in-one-pc) is a built-in function of selenium webdriver which is used to locate elements
        based on text of a web element.*/
        // method simulates a mouse click on an element
        String regMsg2 = driver.findElement(By.xpath("//h2[@class=\"product-title\"]//a[@href=\"/lenovo-ideacentre-600-all-in-one-pc\"]")).getText();
        System.out.println(); // for space in console
        // to print message in console
        System.out.println(regMsg);
        System.out.println(regMs1);
        System.out.println(regMsg2);
    }


}

