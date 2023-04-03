import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Search {

    private AppiumDriver driver;

    @BeforeEach
    public void before() throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("platformVersion","13.0");
        caps.setCapability("deviceName","samsung");
        caps.setCapability("udid","R5CR90MHNYW");
        caps.setCapability("app","/Users/mert.bacak/Desktop/apk/imdb.apk");
        caps.setCapability("newCommandTimeout","600");
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

    }

    @AfterEach
    public void after(){
        if (driver !=null)
        {
            driver.quit();
        }
    }

    @Test
    public void movieTitleCheck(){
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='Search']/android.view.ViewGroup/android.widget.TextView")).click();
       WebElement search= driver.findElement(By.id("com.imdb.mobile:id/search_src_text"));
       search.click();
       search.sendKeys("hobbit");
      driver.findElement(By.xpath("//android.widget.TextView[@text='2014']")).click();
      String movieTitle=driver.findElement(By.id("com.imdb.mobile:id/title")).getText();
      movieTitle.contains("Hobbit: Beş Ordunun Savaşı");
    }
    @Test
    public void filterTopMoviesAndImdbRating() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='Search']/android.view.ViewGroup/android.widget.TextView")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Top 250 movies']")).click();
        Thread.sleep(3000);
        List<String> list1 = new ArrayList<>();
        list1.add(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")).getText());
        list1.add(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")).getText());
        list1.add(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")).getText());
        driver.findElement(By.id("com.imdb.mobile:id/refine_button")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Sıralama:']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='IMDb puanı']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Sıralama:']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Puanlama sayısı']")).click();
        driver.findElement(By.className("com.imdb.mobile.view.AsyncImageView")).click();
        List<String> list2 = new ArrayList<>();
        list2.add(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")).getText());
        list2.add(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")).getText());
        list2.add(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")).getText());
        for (String movie:list1){
            for (String movie2:list2)
                if (movie.contains(movie2)){
                    System.out.println("2 listede yer alan filmimizin adı:"+movie);
                }
        }


    }
}
