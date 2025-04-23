import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class NotificationTest {
    WebDriver driver1, driver2;
    WebDriverWait wait1, wait2;
    Actions action1, action2;
    Robot robot;

    @BeforeClass
    public void setUp() throws AWTException, InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\jorda\\OneDrive - Florida Gulf Coast University\\School Years\\Junior Year\\Spring 2025\\Software Testing\\drivers\\geckodriver.exe");

        // Driver 1 -----------------------
        driver1 = new FirefoxDriver();
        wait1 = new WebDriverWait(driver1, Duration.ofSeconds(10));
        action1 = new Actions(driver1);

        // Get website
        driver1.get("https://web.whatsapp.com/");

        // Driver 2 -----------------------
        driver2 = new FirefoxDriver();
        wait2 = new WebDriverWait(driver2, Duration.ofSeconds(10));
        action2 = new Actions(driver2);
        robot = new Robot();

        // Get website
        driver2.get("https://web.whatsapp.com/");

        // Wait for manual login driver 1 :(
        WebDriverWait wait1 = new WebDriverWait(driver1, Duration.ofSeconds(60));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
        Thread.sleep(2000);


        // Wait for manual login driver 2 :(
        WebDriverWait wait2 = new WebDriverWait(driver2, Duration.ofSeconds(60));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void testMuteNotifications() throws InterruptedException {
        // Click search
        WebElement inputField = driver1.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div[2]/div/div/div"));
        Thread.sleep(2000);

        // Type in Trystan
        action1.moveToElement(inputField).click().sendKeys("Trystan Robertson").perform();
        Thread.sleep(2000);

        // Select chat
        driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[2]")).click();
        Thread.sleep(2000);

        // Select settings
        driver1.findElement(By.xpath("//*[@id=\"main\"]/header/div[1]")).click();
        Thread.sleep(2000);

        // Select mute
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[5]/span/div/span/div/div/section/div[5]/div[1]")).click();
        Thread.sleep(2000);

        // Select 1 week
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div[1]/div[2]/label[2]")).click();
        Thread.sleep(2000);

        // Select mute
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div[2]/div/button[2]")).click();
        Thread.sleep(2000);

        // Mute group chat
        // Select group chat
        WebElement chat = driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[4]"));
        Thread.sleep(2000);

        // Select down arrow
        action1.moveToElement(chat).perform();
        Thread.sleep(2000);

        driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[4]/div/div/div/div[2]/div[2]/div[2]/span[2]/span/button")).click();
        Thread.sleep(2000);

        // Select mute notifications
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/li[2]")).click();
        Thread.sleep(2000);

        // Select always
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div[1]/div[2]/label[3]")).click();
        Thread.sleep(2000);

        // Select mute
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div[2]/div/button[2]")).click();
        Thread.sleep(2000);

        // Select other group chat
        driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[5]")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void testNotificationReceivedWhenMuted() throws InterruptedException {
        // Select search  bar
        WebElement inputField = driver2.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div[2]/div/div/div[1]"));
        Thread.sleep(2000);

        // Type in Jordan
        action2.moveToElement(inputField).click().sendKeys("Jordan Robertson").perform();
        Thread.sleep(2000);

        // Select chat
        driver2.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[2]")).click();
        Thread.sleep(2000);

        // Select message box
        WebElement messageBox = driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]"));
        Thread.sleep(2000);

        // Type a message
        action2.moveToElement(messageBox).click().sendKeys("Hi buddy").perform();
        Thread.sleep(2000);

        // Send message
        driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[2]/button")).click();
        Thread.sleep(2000);

        // Check if notification is silenced
        // Assert that the actual title matches the expected title
        Assert.assertEquals(driver1.getTitle(), "WhatsApp", "Notification is not muted!");

        // Switch tabs
        // Store the original window handle
        String originalHandle = driver1.getWindowHandle();

        // Open a new window and switch to it
        WebDriver newWindow = driver1.switchTo().newWindow(WindowType.TAB);
        newWindow.get("https://www.google.com");
        Thread.sleep(2000); // Pause for demonstration purposes

        // Perform any actions in the new window here
        // Type in Jordan
        action2.moveToElement(inputField).click().sendKeys("Jordan Robertson").perform();
        Thread.sleep(2000);

        // Select group chat
        driver2.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[4]")).click();
        Thread.sleep(2000);

        // Find message box
        messageBox = driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]"));
        Thread.sleep(2000);

        // Type a message
        action2.moveToElement(messageBox).click().sendKeys("Hi buddies").perform();
        Thread.sleep(2000);

        // Send message
        driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[2]/button")).click();
        Thread.sleep(2000);

        // Send new message
        // Type a message
        action2.moveToElement(messageBox).click().sendKeys("Hi @Jordan Robertson").perform();
        Thread.sleep(2000);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(2000);

        // Send message
        driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[2]/button")).click();
        Thread.sleep(2000);

        // Close the new window
        newWindow.close();
        Thread.sleep(2000);

        // Switch back to the original window
        driver1.switchTo().window(originalHandle);
        Thread.sleep(2000);

        // Check if notification is silenced
        // Assert that the actual title matches the expected title
        Assert.assertEquals(driver1.getTitle(), "WhatsApp", "Notification is not muted!");
        Thread.sleep(2000);

        // Read notifications
        driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[4]")).click();
        Thread.sleep(2000);

        driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[2]")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void testUnmuteNotifications() throws InterruptedException {
        // Select chat
        WebElement chat = driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[2]"));
        Thread.sleep(2000);

        // Select down arrow
        action1.moveToElement(chat).perform();
        Thread.sleep(2000);

        driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/span[3]/span/button")).click();
        Thread.sleep(2000);

        // Select unmute
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/li[2]")).click();
        Thread.sleep(2000);

        // Select group chat
        driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[4]")).click();
        Thread.sleep(2000);

        // Select settings
        driver1.findElement(By.xpath("//*[@id=\"main\"]/header/div[1]")).click();
        Thread.sleep(2000);

        // Unmute
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[5]/span/div/span/div/div/div/section/div[5]/div[1]")).click();
        Thread.sleep(2000);

        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div[2]/div/button[2]")).click();
        Thread.sleep(2000);

        // Click other group chat
        driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[5]")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void testNotificationReceivedWhenUnmuted() throws InterruptedException {
            // Test notification received from different tab (background notification + notification badge count)
            WebElement inputField = driver2.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div[2]/div/div/div[1]"));
            Thread.sleep(2000);

            // Type in Jordan
            action2.moveToElement(inputField).click().sendKeys("Jordan Robertson").perform();
            Thread.sleep(2000);

            // Select chat
            driver2.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[2]")).click();
            Thread.sleep(2000);

            // Select message box
            WebElement messageBox = driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]"));
            Thread.sleep(2000);

            // Type a message
            action2.moveToElement(messageBox).click().sendKeys("Hi buddy").perform();
            Thread.sleep(2000);

            // Send message
            driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[2]/button")).click();
            Thread.sleep(2000);

            // Check if notification is silenced
            // Assert that the actual title matches the expected title
            Assert.assertEquals(driver1.getTitle(), "(1) WhatsApp", "Notification is muted!");

            // Switch tabs
            // Store the original window handle
            String originalHandle = driver1.getWindowHandle();

            // Open a new window and switch to it
            WebDriver newWindow = driver1.switchTo().newWindow(WindowType.TAB);
            newWindow.get("https://www.google.com");
            Thread.sleep(2000); // Pause for demonstration purposes

            // Perform any actions in the new window here
            // Type in Jordan
            action2.moveToElement(inputField).click().sendKeys("Jordan Robertson").perform();
            Thread.sleep(2000);

            // Select group chat
            driver2.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[4]")).click();
            Thread.sleep(2000);

            // Find message box
            messageBox = driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]"));
            Thread.sleep(2000);

            // Type a message
            action2.moveToElement(messageBox).click().sendKeys("Hi buddies").perform();
            Thread.sleep(2000);

            // Send message
            driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[2]/button")).click();
            Thread.sleep(2000);

            // Send new message
            // Type a message
            action2.moveToElement(messageBox).click().sendKeys("Hi @Jordan Robertson").perform();
            Thread.sleep(2000);

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(2000);

            // Send message
            driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[2]/button")).click();
            Thread.sleep(2000);

            // Close the new window
            newWindow.close();
            Thread.sleep(2000);

            // Switch back to the original window
            driver1.switchTo().window(originalHandle);
            Thread.sleep(2000);

            // Check if notification is silenced
            // Assert that the actual title matches the expected title
            Assert.assertEquals(driver1.getTitle(), "(2) WhatsApp", "Notification is muted!");
            Thread.sleep(2000);
//
            // Read notifications
            driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[4]")).click();
            Thread.sleep(2000);

            driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[2]")).click();
            Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void testDifferentChatNotifications() throws InterruptedException {
        // Select profile
        driver1.findElement(By.xpath("//*[@id=\"main\"]/header/div[1]")).click();
        Thread.sleep(2000);

        // Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver1;
        js.executeScript("window.scrollBy(0, 1000);");


        // Block user
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[5]/span/div/span/div/div/section/div[9]/div[1]")).click();
        Thread.sleep(2000);

        // Confirm
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div[2]/div/button[2]")).click();
        Thread.sleep(2000);

        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[5]/span/div/span/div/header/div/div[1]/div")).click();
        Thread.sleep(2000);

        // Message from blocked user
        WebElement inputField = driver2.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div[2]/div/div/div[1]"));
        Thread.sleep(2000);

        // Type in Jordan
        action2.moveToElement(inputField).click().sendKeys("Jordan Robertson").perform();
        Thread.sleep(2000);

        // Select chat
        driver2.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[2]")).click();
        Thread.sleep(2000);

        // Select message box
        WebElement messageBox = driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]"));
        Thread.sleep(2000);

        // Type a message
        action2.moveToElement(messageBox).click().sendKeys("I am blocked").perform();
        Thread.sleep(2000);

        // Send message
        driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[2]/button")).click();
        Thread.sleep(2000);

        // Send message in group chat
        // Message from blocked user
        inputField = driver2.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div[2]/div/div/div[1]"));
        Thread.sleep(2000);

        // Type in Jordan
        action2.moveToElement(inputField).click().sendKeys("Jordan Robertson").perform();
        Thread.sleep(2000);

        // Select chat
        driver2.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[4]")).click();
        Thread.sleep(2000);

        // Select message box
        messageBox = driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]"));
        Thread.sleep(2000);

        // Type a message
        action2.moveToElement(messageBox).click().sendKeys("I am still blocked").perform();
        Thread.sleep(2000);

        // Send message
        driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[2]/button")).click();
        Thread.sleep(2000);

        // Check group chat
        driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[4]")).click();
        Thread.sleep(2000);

        // Switch back to blocked user
        driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[2]")).click();
        Thread.sleep(2000);

        // Unblock
        driver1.findElement(By.xpath("//*[@id=\"main\"]/footer/div/div/div[2]/button")).click();
        Thread.sleep(2000);

        // Confirm
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div[2]/div/button[2]")).click();
        Thread.sleep(2000);

        // Message from unblocked user
        inputField = driver2.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div[2]/div/div/div[1]"));
        Thread.sleep(2000);

        // Type in Jordan
        action2.moveToElement(inputField).click().sendKeys("Jordan Robertson").perform();
        Thread.sleep(2000);

        // Select chat
        driver2.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[2]")).click();
        Thread.sleep(2000);

        // Select message box
        messageBox = driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]"));
        Thread.sleep(2000);

        // Type a message
        action2.moveToElement(messageBox).click().sendKeys("I am unblocked").perform();
        Thread.sleep(2000);

        // Send message
        driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[2]/button")).click();
        Thread.sleep(2000);

        // Delete chat
        driver1.findElement(By.xpath("//*[@id=\"main\"]/header/div[1]")).click();
        Thread.sleep(2000);

        // Scroll
        js = (JavascriptExecutor) driver1;
        js.executeScript("window.scrollBy(0, 1000);");

        // Select delete chat
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[5]/span/div/span/div/div/section/div[10]/div")).click();
        Thread.sleep(2000);

        // Confirm
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div[2]/div/button[2]")).click();
        Thread.sleep(2000);

        // Send message from deleted user
        inputField = driver2.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div[2]/div/div/div[1]"));
        Thread.sleep(2000);

        // Type in Jordan
        action2.moveToElement(inputField).click().sendKeys("Jordan Robertson").perform();
        Thread.sleep(2000);

        // Select chat
        driver2.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[2]")).click();
        Thread.sleep(2000);

        // Select message box
        messageBox = driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]"));
        Thread.sleep(2000);

        // Type a message
        action2.moveToElement(messageBox).click().sendKeys("Dont delete me :(").perform();
        Thread.sleep(2000);

        // Send message
        driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[2]/button")).click();
        Thread.sleep(2000);

        // Refresh chats
        driver1.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div[2]/span/button")).click();
        Thread.sleep(2000);

        // Search bar
        inputField = driver1.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div[2]/div/div/div[1]"));
        Thread.sleep(2000);

        // Type in Trystan
        action1.moveToElement(inputField).click().sendKeys("Trystan Robertson").perform();
        Thread.sleep(2000);

        // Log out
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[1]/button")).click();
        Thread.sleep(2000);

        // Log out button
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div/div[2]/div/div/div/button[8]/div")).click();
        Thread.sleep(2000);

        // Confirm
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div[2]/div/button[2]")).click();
        Thread.sleep(2000);


        // Log in
        wait1 = new WebDriverWait(driver1, Duration.ofSeconds(120));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
        Thread.sleep(2000);

        // Search bar
        inputField = driver1.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div[2]/div/div/div[1]"));
        Thread.sleep(2000);

        // Type in Trystan
        action1.moveToElement(inputField).click().sendKeys("Trystan Robertson").perform();
        Thread.sleep(2000);

        // Click chats
        driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[2]")).click();
        Thread.sleep(2000);

        driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[4]")).click();
        Thread.sleep(2000);

        // Unread chat
        // Select chat
        WebElement chat = driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[2]"));
        Thread.sleep(2000);

        // Select down arrow
        action1.moveToElement(chat).perform();
        Thread.sleep(2000);

        driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/span[3]/span/button")).click();
        Thread.sleep(2000);

        // Mark as unread
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/li[4]")).click();
        Thread.sleep(2000);

        // Click into chat
        driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[2]")).click();
        Thread.sleep(2000);

        // Archive chats
        // Select chat
        chat = driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[2]"));
        Thread.sleep(2000);

        // Select down arrow
        action1.moveToElement(chat).perform();
        Thread.sleep(2000);

        driver1.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/span[3]/button")).click();
        Thread.sleep(2000);

        // Archive chat
        driver1.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/li[1]")).click();
        Thread.sleep(2000);

        // Send message
        action2.moveToElement(messageBox).click().sendKeys("I am archived").perform();
        Thread.sleep(2000);

        // Send message
        driver2.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[2]/button")).click();
        Thread.sleep(2000);

        // Type message
        messageBox = driver1.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]"));
        action1.moveToElement(messageBox).click().sendKeys("Done").perform();
        Thread.sleep(2000);

        // Send message
        driver1.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[2]/button")).click();
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        driver1.quit();
        driver2.quit();
    }

}


