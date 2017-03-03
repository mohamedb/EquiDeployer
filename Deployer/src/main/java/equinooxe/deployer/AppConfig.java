
package equinooxe.deployer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class AppConfig {
	private static final Properties PROPERTIES = new Properties();
	private static InputStream input = null;
	
	static {
		String sysPropFilePath = "app.properties";

		try {
			input = new FileInputStream(sysPropFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try (InputStream is = input) {
			PROPERTIES.load(is);
		} catch (IOException e) {
			throw new RuntimeException("Failed to read configuration file.", e);
		}
	}

	public static String getPropValue(String property) {
		final String value = PROPERTIES.getProperty(property);
		if (StringUtils.isBlank(value)) {
			try {
				throw new NoSuchPropertyException(property);
			} catch (NoSuchPropertyException e) {
				e.printStackTrace();
			}
		}
		return value;
	}
	
	
}
