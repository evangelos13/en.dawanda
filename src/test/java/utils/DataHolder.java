package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Test data provider (a singleton container for properties).
 */
public class DataHolder {

	private static DataHolder dataHolder;
	private static final String PROPERTY_FILE_PATH = "src/test/resources/config.property";
	private static Properties properties;

	private DataHolder() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(new File(PROPERTY_FILE_PATH)));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static DataHolder getDataHolder() {
		if (dataHolder == null) {
			dataHolder = new DataHolder();
		}
		return dataHolder;
	}

	/**
	 * Searches for the property with the specified key in config.property
	 * file. The method returns {@code null} if the property is not found.
	 *
	 * @param propertyKey
	 *            the property key.
	 * @return the value in this property list with the specified key value.
	 */
	public static String getProperty(String propertyKey) {
		getDataHolder();
		return properties.getProperty(propertyKey);
	}

}
