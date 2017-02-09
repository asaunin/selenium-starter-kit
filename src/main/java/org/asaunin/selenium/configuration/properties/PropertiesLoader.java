package org.asaunin.selenium.configuration.properties;

import org.asaunin.selenium.configuration.Configuration;
import org.asaunin.selenium.exceptions.ConfigurationException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Class for loading base tests properties. It gets properties - system or from file (by specified names) and sets it to fields of TestConfig object
 */
public class PropertiesLoader {

    /**
     * Sets TestConfig object fields values to specified properties values
     *
     * @param config {@link Configuration} object
     */
    public static void populate(Configuration config) {
        Properties properties = null;
        PropertyFile propertyFileAnnotation = config.getClass().getAnnotation(PropertyFile.class);
        if (propertyFileAnnotation != null) {
            String propertyFileName = propertyFileAnnotation.value();
            if (propertyFileName == null) {
                throw new ConfigurationException("Property file name cannot be empty. Class name : " + config.getClass().getName());
            } else {
                properties = new Properties();
                try {
                    InputStream stream = PropertiesLoader.class.getClassLoader().getResourceAsStream(propertyFileName);
                    if(stream != null) {
                        properties.load(stream);
                    } else {
                        throw new ConfigurationException("Unable to read property file with name '" + propertyFileName + "' - file not found");
                    }
                } catch (IOException e) {
                    throw new ConfigurationException("Error while reading property file with name '" + propertyFileName + "' : " + e.getMessage(), e);
                }
            }
        } else {
            properties = System.getProperties();
        }
        Field[] fields = config.getClass().getDeclaredFields();
        for (Field field : fields) {
            Property propertyAnnotation = field.getAnnotation(Property.class);
            if (propertyAnnotation != null) {
                String propertyName = propertyAnnotation.value();
                if (propertyName == null) {
                    throw new ConfigurationException("Property value cannot be empty. Field name : " + field.getName());
                }
                String propertyValue = properties.getProperty(propertyName);
                if (propertyValue != null) {
                    try {
                        field.setAccessible(true);
                        field.set(config, propertyValue);
                    } catch (IllegalAccessException e) {
                        throw new ConfigurationException("Field cannot be set...", e);
                    }
                }
            }
        }
    }

}
