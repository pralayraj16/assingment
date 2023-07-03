package session.utils;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class PropertiesUtils {
	private static Properties dataprop = null;
	public static Properties getProperties() {
		dataprop = new Properties();
		try {
			dataprop.load(new FileReader(new File(System.getProperty("user.dir"))+"/properties/data.properties"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dataprop;
	}
	
	public static String getPropValue(String key) {
		if(dataprop == null) {
			getProperties();
		}
		return dataprop.getProperty(key);
	}
	
}
