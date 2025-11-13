package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PasswordManager {

    private static final String FILE_PATH = "src/test/global.properties";
    private static Properties props = new Properties();

    // Load from file
    public static void loadProperties() {
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load password.properties", e);
        }
    }

    // Getters
    public static String getEmail() {
        return props.getProperty("email");
    }

    public static String getOldPassword() {
        return props.getProperty("oldPassword");
    }

    // Update oldPassword and save to file
    public static void updatePassword(String newPassword) {
        props.setProperty("oldPassword", newPassword);
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
            props.store(fos, "Updated latest password");
        } catch (IOException e) {
            throw new RuntimeException("Failed to update password.properties", e);
        }
    }
}
