


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A101EndToEnd {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAMSUNG\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.a101.com.tr/");

        // giyim-kadın iç giyim - dizaltı çorap bölümüne gidiş

        driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")).click();
        driver.findElement(By.cssSelector("a[title='GİYİM & AKSESUAR']")).click();
        driver.findElement(By.xpath("(//a[@title='Kadın İç Giyim'])[2]")).click();
        driver.findElement(By.xpath("//input[@id='attributes_integration_colourSİYAH']/parent::li")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//a[@title='Dizaltı Çorap'])[2]")).click();
        WebElement icSiyah = driver.findElement(By.xpath("//h3[contains(text(),'50 Denye Pantolon Çorabı Siyah')]"));
        icSiyah.click();
        String color = driver.findElement(By.xpath("//div[@class='selected-variant-text']")).getText();
        System.out.println(color);

        // ürünün siyah olduğunu assert etmek

        if (driver.findElement(By.xpath("//div[@class='selected-variant-text']")).getText().contains("SİYAH")) {
            System.out.println(" ürün siyahtır ");
            Assert.assertTrue(true);

        } else {
            Assert.fail();
        }

        // sepete ekle

        driver.findElement(By.cssSelector("button[class='add-to-basket button green block with-icon js-add-basket']")).click();

        Thread.sleep(3000);

        //sepeti görüntüle

        driver.findElement(By.cssSelector(".go-to-shop")).click();

        //sepeti onayla

        driver.findElement(By.xpath("//a[@class='button green checkout-button block js-checkout-button']")).click();

        //üye olmadan devam et

        driver.findElement(By.cssSelector("a[class='auth__form__proceed js-proceed-to-checkout-btn']")).click();

        Thread.sleep(3000);

        //mail tanımla

        driver.findElement(By.xpath("//input[@type='text'][@name='user_email']")).sendKeys("temurvolkan@yahoo.com");
        driver.findElement(By.xpath("//button[@type='submit'][@class='button block green']")).click();
        Thread.sleep(3000);

        //adres ekranına gidip adres oluştur

        driver.findElement(By.xpath("//em[@class='icon-plus']")).click();
        driver.findElement(By.cssSelector("input[placeholder='Ev adresim, iş adresim vb.']")).sendKeys("Ev Adresim");
        driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("Khgdtrsjhim");
        driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys("Bkjhgxgsıgk");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("input[name='phone_number']")).click();
        driver.findElement(By.cssSelector("input[name='phone_number']")).sendKeys("5554701570");

        Select cityAndTown = new Select(driver.findElement(By.cssSelector("select[name='city']")));
        cityAndTown.selectByVisibleText("İSTANBUL");

        Thread.sleep(3000);
        Select town = new Select(driver.findElement(By.cssSelector("select[name='township']")));
        town.selectByVisibleText("AVCILAR");

        Thread.sleep(3000);
        Select district = new Select(driver.findElement(By.cssSelector("select[name='district']")));
        district.selectByVisibleText("GÜMÜŞPALA MAH");

        driver.findElement(By.xpath("//textarea[@class='js-address-textarea']")).sendKeys("GÜMÜŞPALA MAH, CEMİL SOK , NO.49/5");

        driver.findElement(By.xpath("//button[@type='button'][@class='button green js-set-country js-prevent-emoji']")).click();
        Thread.sleep(3000);

        //girdiğin adres bilgilerini kaydet ve devam et

        driver.findElement(By.cssSelector("button[class='button block green js-proceed-button']")).click();
        Thread.sleep(3000);

        WebElement buttonTamamla = driver.findElement(By.xpath("//button[@class='button block green continue-button']/span[@class='order-complete']"));

        //ödeme sayfasına gelindiğini teyit et

        if (buttonTamamla.getText().contains("Tamamla")) {
            System.out.println(" ödeme sayfasına ulaşılmıştır");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

        //siparişi tamamla butonuna tıkla

        driver.findElement(By.xpath("//button[@class='button block green continue-button']/span[@class='order-complete']")).click();


    }

}


