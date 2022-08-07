import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String PROJECT_HOME = System.getProperty("user.dir");
        System.out.println(PROJECT_HOME);
//        System.setProperty("webdriver.chrome.driver", PROJECT_HOME + File.separator + "Drivers" + File.separator + "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        /*WebDriverManager.firefoxdriver().setup();
         */
        System.out.println(System.getProperty("webdriver.chrome.driver"));
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/elements");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@class='card-body']/h5")).click();
        driver.findElement(By.linkText("Facebook - log in or sign up")).click();
        driver.findElement(By.partialLinkText("Facebook - log in")).click();
        driver.findElement(By.tagName("h3")).click();
        driver.findElement(By.xpath("//*[@class='menu-list']/li")).click();
        driver.findElement(By.id("userName")).sendKeys("ABCDEFGHIJKL");
        driver.findElement(By.name("iflsig")).click();
        Thread.sleep(10000);
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.close();//Will only close the tab
        driver.quit();//Will close the complete window or browser
       /* WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();*/
    }
}
