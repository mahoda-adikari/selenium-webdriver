package day39;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws URISyntaxException, IOException {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		System.out.println("Total no. of links: "+ linksList.size());
		int brokenLinksCount = 0;
		int nonBrokenLinksCount = 0;
		
		for(WebElement link:linksList) {
			String hrefValue = link.getAttribute("href");
			
			if(hrefValue.isEmpty() || hrefValue == null) {
				System.out.println("href attribute is Null or Empty, failed to check!");
				continue;
			}
			
			try {
				URI linkURI = new URI(hrefValue);
				URL linkURL = linkURI.toURL();
				HttpURLConnection linkConn = (HttpURLConnection) linkURL.openConnection();
				linkConn.connect();
				if(linkConn.getResponseCode() >= 400) {
					System.out.println(hrefValue+ " ===> Broken Link");
					brokenLinksCount++;
				} else {
					System.out.println(hrefValue+ " ===> Not a Broken Link");
					nonBrokenLinksCount++;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Number of Broken Links: "+ brokenLinksCount);
		System.out.println("Number of Non-Broken Links: "+ nonBrokenLinksCount);
	}

}
