import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

public class BasePage extends BaseTest {

    final static Logger logger = (Logger) LogManager.getLogger(BasePage.class);

    @Step("<wait> saniye bekle")
    public void waitForseconds(int wait) throws InterruptedException {
        Thread.sleep(1000 * wait);
    }


    @Step("id <id> li elemente tıkla")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();
        logger.info(id + "elementine tıklandı");
    }

    @Step("xPath <Xpath> li elemente tıkla")
    public void clickXpath(String Xpath) {
        appiumDriver.findElement(By.xpath("Xpath"));
        logger.info(Xpath + "elementine tıklandı");
    }

    @Step("<id> İd'li elemente <text> değerini yaz")
    public void sendKeysid(String id, String text) {
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        logger.info(id + "elementini bul ve " + text + " değerini yaz");

    }

    @Step("Rastgele bir ürün seç")
    public void selectRondamproduct() {
        Random rdn = new Random();
        List<MobileElement> pd = appiumDriver.findElements(By.xpath("//*[@class='android.widget.ImageView']"));
        logger.info("pd" + pd);
        MobileElement element = pd.get(rdn.nextInt(pd.size()));
        logger.info("element" + element);
        element.click();
    }

    @Step("<key> id'si olan element gorunuyor mu")
    public void isDisplayed(String key) {
        String text = appiumDriver.findElement(By.id(key)).getText();
        boolean display = appiumDriver.findElement(By.id(key)).isDisplayed();
    }

    @Step("Ekranı <times> defa asagı kaydır ve <wait> saniye bekle")
    public void scroll(int times, int wait) throws InterruptedException {
        TouchAction scroll = new TouchAction(appiumDriver)
                .press(PointOption.point(232, 507))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(PointOption.point(232, 1300))
                .release()
                .perform();
        Thread.sleep(1000 * wait);
    }
}

