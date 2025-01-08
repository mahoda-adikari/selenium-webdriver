package day41;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+ "\\testdata\\config.properties");	

		Properties prFile = new Properties();
		prFile.load(fi);
		
		String url = prFile.getProperty("appurl");
		System.out.println(url);
		
		Set<String> keySetString = prFile.stringPropertyNames();
		System.out.println(keySetString);
		
		Set<Object> keySetObject = prFile.keySet();
		System.out.println(keySetObject);
		
		Collection<Object> valueSetString = prFile.values();
		System.out.println(valueSetString);
		
		fi.close();

	}

}
