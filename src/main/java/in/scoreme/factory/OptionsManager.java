package in.scoreme.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();

		if (Boolean.parseBoolean(prop.getProperty("remote"))) {
			co.setCapability("browserName", "chrome");
			// selenoid
			co.setBrowserVersion(prop.getProperty("browserversion").trim());
			Map<String, Object> selenoidOptions = new HashMap<>();
			selenoidOptions.put("screenResolution", "1920x1080");
			selenoidOptions.put("enableVNC", true);
			// selenoidOptions.put("name", prop.getProperty("testname"));
			co.setCapability("selenoid:options", selenoidOptions);

		}

		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {

			System.out.println("running chrome in headless mode ");
			co.addArguments("--headless");

		}

		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			System.out.println("running chrome in incognito mode ");
			co.addArguments("--incognito");

		}
		return co;

	}

	public FirefoxOptions getFirefoxOptions() {

		fo = new FirefoxOptions();

		if (Boolean.parseBoolean(prop.getProperty("remote"))) {
			fo.setCapability("browserName", "firefox");
			//selenoid
			fo.setBrowserVersion(prop.getProperty("browserversion").trim());
			Map<String, Object> selenoidOptions = new HashMap<>();
			selenoidOptions.put("screenResolution", "1280x1024x24");
			selenoidOptions.put("enableVNC", true);
			// selenoidOptions.put("name", prop.getProperty("testname"));
			fo.setCapability("selenoid:options", selenoidOptions);
			
		}

		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			System.out.println("running firefox in headless mode ");
			fo.addArguments("--headless");
		}

		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {

			System.out.println("running firefox in incognito mode ");
			fo.addArguments("--incognito");

		}
		return fo;

	}

	public EdgeOptions getEdgeOptions() {

		eo = new EdgeOptions();

		if (Boolean.parseBoolean(prop.getProperty("remote"))) {
			eo.setCapability("browserName", "edge");
		}

		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			System.out.println("running edge in headless mode ");
			eo.addArguments("--headless");

		}
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {

			System.out.println("running edge in inprivate mode ");
			eo.addArguments("--inprivate");

		}
		return eo;

	}

}
