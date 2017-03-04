
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
	public static final String SOURCES_FOLDER;
	public static final String DEST_FOLDER;
	public static final String WEBSITE_FOLDER;
	
	public static final String DB_BACKUP_FOLDER;
	
	public static final String MYSQL_HOSTNAME;
	public static final String MYSQL_USER;
	public static final String MYSQL_PASSWORD;
	public static final String MYSQL_DBNAME;
	
	public static final String GIT_REPO_URL;

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
		SOURCES_FOLDER = AppConfig.getPropValue("folder.sources");
		DEST_FOLDER = AppConfig.getPropValue("folder.dest");
		WEBSITE_FOLDER = AppConfig.getPropValue("folder.website");
		DB_BACKUP_FOLDER = AppConfig.getPropValue("folder.db.backup");
		
		 MYSQL_HOSTNAME = AppConfig.getPropValue("mysql.hostname"); 
		 MYSQL_USER     = AppConfig.getPropValue("mysql.user"); 
		 MYSQL_PASSWORD = AppConfig.getPropValue("mysql.password"); 
		 MYSQL_DBNAME= AppConfig.getPropValue("mysql.dbname"); 
		 
		 GIT_REPO_URL= AppConfig.getPropValue("git.repositoryUrl");
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
