
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.HasTouchScreen;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keyboard;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TouchScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverCommandProcessor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.vaadin.testbench.By;
import com.vaadin.testbench.TestBench;
import com.vaadin.testbench.TestBenchTestCase;

public class SimplePlusTest extends TestBenchTestCase {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = TestBench.createDriver(new FirefoxDriver());
		baseUrl = "http://localhost:8080/";
	}

	@Test
	public void testSimplePlus() throws Exception {
		driver.get(concatUrl(baseUrl, "/?restartApplication"));
		testBenchElement(driver.findElement(By.id("txtNr1"))).click(73,10);
		driver.findElement(By.id("txtNr1")).clear();
		driver.findElement(By.id("txtNr1")).sendKeys("12");
		testBenchElement(driver.findElement(By.id("txtNr2"))).click(28,13);
		driver.findElement(By.id("txtNr2")).clear();
		driver.findElement(By.id("txtNr2")).sendKeys("13");
		driver.findElement(By.xpath("//span/span")).click();
		try {
			assertEquals("25", driver.findElement(By.id("txtResult")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
