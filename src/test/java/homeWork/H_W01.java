package homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class H_W01 {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    //    https://www.google.com/ adresine gidin


//    cookies uyarisini kabul ederek kapatin
//    Sayfa basliginin “Google” ifadesi icerdigini test edin

    @Test
    public void titleGet() {
        driver.get("https://www.google.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }


    //    Arama cubuguna “Nutella” yazip aratin
//    Bulunan sonuc sayisini yazdirin
    @Test
    public void aramaKutusu() {
        driver.get("https://www.google.com/");
        WebElement aramakutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramakutusu.sendKeys("Nutella", Keys.ENTER);
        String[] sonuc = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println(sonuc[1]);

        String sonucc = sonuc[1].replaceAll("\\D", "");

        if (Integer.parseInt(sonucc) > 100000000) {
            System.out.println("Sonuc sayisi 100000000 fazla");
        } else {
            System.out.println("Sonuc sayisi 100000000 fazla değil");
        }


//    sonuc sayisinin 10 milyon’dan fazla oldugunu test edin


//    Sayfayi kapatin
        driver.close();


    }
}