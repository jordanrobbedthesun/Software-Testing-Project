import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class CommunityTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    Robot robot;


    @BeforeClass public void setUp() throws AWTException {
        System.setProperty("webdriver.gecko.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
        robot = new Robot();
    }

    @Test(priority = 1) public void createCommunity() throws InterruptedException {

        driver.get("https://web.whatsapp.com/");

        // Opens Whatsapp
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
        Thread.sleep(2000);

        // Press Community
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/header/div/div/div/div/span/div/div[1]/div[4]/button")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div/div/div/div[1]/div/div")).click();
        Thread.sleep(2000);
        
        // Creating the community
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div/div[2]/div")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[3]/div/div[2]/div[3]/div/div/p")).sendKeys("T");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[3]/div/div[2]/div[3]/div/div/p")).sendKeys("e");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[3]/div/div[2]/div[3]/div/div/p")).sendKeys("s");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[3]/div/div[2]/div[3]/div/div/p")).sendKeys("t");
        Thread.sleep(2000);

        // Adds Emoji
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div[1]/div/div[3]/div/div[2]/span/div/button/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[5]/div/div[1]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/span[1]")).click();
        Thread.sleep(2000);

        // Adding Profile Picture
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div[1]/div/div[2]/div/button[1]")).click();
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys("C:\\Users\\redsl\\IdeaProjects\\test\\arduino.png");
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[2]/span/div/div")).click();
        Thread.sleep(2000);

        // Creates Community
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div[2]/span/div")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 2) public void sendingMessages() throws InterruptedException {

        // Presses Announcements
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[1]/div/div")).click();
        Thread.sleep(2000);

        // Types Message
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]/p")).sendKeys("C");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]/p")).sendKeys("S");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]/p")).sendKeys("S");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]/p")).sendKeys("E");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]/p")).sendKeys("C");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]/p")).sendKeys(" ");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]/p")).sendKeys("R");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]/p")).sendKeys("U");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]/p")).sendKeys("L");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]/p")).sendKeys("E");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]/p")).sendKeys("S");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]/p")).sendKeys("!");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]/p")).sendKeys("!");
        Thread.sleep(2000);

        // Adding Emoji
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[2]/div[1]/div[1]/button/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/span/div/ul/div[1]/div[2]/div/div/div/div/div/div[6]/div/div/div/span[11]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/span/div/ul/div[1]/div[2]/div/div/div/div/div/div[6]/div/div/div/span[11]")).click();
        Thread.sleep(2000);

        // Entering
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]/p")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        // Creates Event
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[1]/div/button/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[5]/div/ul/div/div/div[7]/li/div")).click();

        // Event Name
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div[3]/div/div/p")).sendKeys("C");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div[3]/div/div/p")).sendKeys("l");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div[3]/div/div/p")).sendKeys("u");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div[3]/div/div/p")).sendKeys("b");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div[3]/div/div/p")).sendKeys(" ");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div[3]/div/div/p")).sendKeys("M");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div[3]/div/div/p")).sendKeys("e");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div[3]/div/div/p")).sendKeys("e");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div[3]/div/div/p")).sendKeys("t");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div[3]/div/div/p")).sendKeys("i");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div[3]/div/div/p")).sendKeys("n");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div[3]/div/div/p")).sendKeys("g");
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/span/div/button/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[5]/div/div[1]/div/div[2]/div/div/div/div/div/div[4]/div/div/div/span[6]")).click();
        Thread.sleep(2000);

        // Event Description
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[2]/div[1]/div[3]/div/div/p")).sendKeys("E");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[2]/div[1]/div[3]/div/div/p")).sendKeys("V");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[2]/div[1]/div[3]/div/div/p")).sendKeys("E");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[2]/div[1]/div[3]/div/div/p")).sendKeys("R");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[2]/div[1]/div[3]/div/div/p")).sendKeys("Y");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[2]/div[1]/div[3]/div/div/p")).sendKeys(" ");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[2]/div[1]/div[3]/div/div/p")).sendKeys("T");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[2]/div[1]/div[3]/div/div/p")).sendKeys("H");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[2]/div[1]/div[3]/div/div/p")).sendKeys("U");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[2]/div[1]/div[3]/div/div/p")).sendKeys("R");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[2]/div[1]/div[3]/div/div/p")).sendKeys("S");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[2]/div[1]/div[3]/div/div/p")).sendKeys("D");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[2]/div[1]/div[3]/div/div/p")).sendKeys("A");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div[2]/div[1]/div[3]/div/div/p")).sendKeys("Y");
        Thread.sleep(2000);

        // Location
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/section[3]/div/div/div[1]/p")).sendKeys("H");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/section[3]/div/div/div[1]/p")).sendKeys("o");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/section[3]/div/div/div[1]/p")).sendKeys("l");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/section[3]/div/div/div[1]/p")).sendKeys("m");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/section[3]/div/div/div[1]/p")).sendKeys("e");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/section[3]/div/div/div[1]/p")).sendKeys("s");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/section[3]/div/div/div[1]/p")).sendKeys(" ");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/section[3]/div/div/div[1]/p")).sendKeys("4");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/section[3]/div/div/div[1]/p")).sendKeys("3");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/section[3]/div/div/div[1]/p")).sendKeys("3");
        Thread.sleep(2000);

        // Send Event
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[2]/div")).click();
        Thread.sleep(2000);

        // View Event
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/div[3]/div/div[2]/div[3]/div[4]/div/div/div[1]/div[1]/div[1]/button/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/header/div/div[1]/div/span")).click();
        Thread.sleep(2000);

        // Creates Poll
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[1]/div/button/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[5]/div/ul/div/div/div[5]/li/div")).click();
        Thread.sleep(2000);

        // Poll Question
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[3]/div/div/p")).sendKeys("C");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[3]/div/div/p")).sendKeys("S");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[3]/div/div/p")).sendKeys("S");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[3]/div/div/p")).sendKeys("E");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[3]/div/div/p")).sendKeys("C");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[3]/div/div/p")).sendKeys(" ");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[3]/div/div/p")).sendKeys("_");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[3]/div/div/p")).sendKeys("_");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[3]/div/div/p")).sendKeys("_");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[3]/div/div/p")).sendKeys("_");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[3]/div/div/p")).sendKeys("!");
        Thread.sleep(2000);

        // Adding Options
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[3]/div/div/p")).sendKeys("R");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[3]/div/div/p")).sendKeys("u");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[3]/div/div/p")).sendKeys("l");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[3]/div/div/p")).sendKeys("e");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[3]/div/div/p")).sendKeys("s");
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/p")).sendKeys("S");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/p")).sendKeys("u");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/p")).sendKeys("c");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/p")).sendKeys("k");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/p")).sendKeys("s");
        Thread.sleep(2000);

        // Send Poll
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[2]/div")).click();
        Thread.sleep(2000);

        // Select Poll
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/div[3]/div/div[2]/div[3]/div[5]/div/div/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div/div[1]/div")).click();
        Thread.sleep(2000);

        // View Votes
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/div[3]/div/div[2]/div[3]/div[5]/div/div/div[1]/div[1]/div[1]/div[2]/div[4]/button/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/header/div/div[1]/div/span")).click();
        Thread.sleep(2000);

        // Gives Contact
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/footer/div[1]/div/span/div/div[1]/div/button/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[5]/div/ul/div/div/div[4]/li/div")).click();
        Thread.sleep(2000);

        // Type Contact
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/span/div/div/div/div/div/div/div[1]/div/div[2]/div/div/div/p")).sendKeys("J");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/span/div/div/div/div/div/div/div[1]/div/div[2]/div/div/div/p")).sendKeys("o");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/span/div/div/div/div/div/div/div[1]/div/div[2]/div/div/div/p")).sendKeys("r");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/span/div/div/div/div/div/div/div[1]/div/div[2]/div/div/div/p")).sendKeys("d");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/span/div/div/div/div/div/div/div[1]/div/div[2]/div/div/div/p")).sendKeys("a");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/span/div/div/div/div/div/div/div[1]/div/div[2]/div/div/div/p")).sendKeys("n");
        Thread.sleep(2000);

        // Select Contact
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/span/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div")).click();
        Thread.sleep(2000);

        // Send Contact
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/span/div/div/div/div/div/div/span/div/div/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/span/div/div/div/div/div/div/div[2]/div/div")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 3) public void addingAndKickingMembers() throws InterruptedException {
    }

    @Test(priority = 4) public void editingCommunity() throws InterruptedException {
    }

    @Test(priority = 5) public void exitCommunity() throws InterruptedException {
    }

    @AfterClass public void tearDown() {
        driver.quit();
    }

}
