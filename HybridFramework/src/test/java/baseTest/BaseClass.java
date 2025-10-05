package baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {
	
	//public  static WebDriver driver;
	public Logger logger;
	public FileInputStream in;
	public Properties pro;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    public void setup(String browser) throws IOException, URISyntaxException {
    	logger = LogManager.getLogger(this.getClass());
    	in = new FileInputStream(""
    			+ "/Users/mohitaggrawal/Documents/java/HybridFramework/src/test/resources/config.properties");
    	pro = new Properties();
    	pro.load(in);
    	
    	/*DesiredCapabilities cap = new DesiredCapabilities();
    	cap.setPlatform(Platform.LINUX);
    	cap.setBrowserName("chrome");
    	
       // set the hub URL
    	
    	driver = new RemoteWebDriver(new URI(pro.getProperty("hub")).toURL() , cap);
    	*/
    	
    	
    	
    	if(browser.toLowerCase().equals("chrome")) {
    	driver.set(new ChromeDriver());}
    	else {
    		driver.set(new SafariDriver());
    	} 
    	driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.get().get(pro.getProperty("url"));
    }
    
    @AfterClass(alwaysRun = true)
    public void tearDown() throws InterruptedException {
      Thread.sleep(2000);
    	driver.get().quit();
    	driver.remove();
    }
    
    public static String captureScreenShot(String name) throws IOException {
    	
    	String tStamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
    	String file_path = System.getProperty("user.dir")+ "/test-output/screenShots" + name + "_" + tStamp + ".png";
    	File des = new File(file_path);
    	// return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    	 File source = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.FILE);
    	 Files.copy(source.toPath(), des.toPath());
    	return file_path;
    }

}
