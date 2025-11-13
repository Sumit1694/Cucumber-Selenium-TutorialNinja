package utilities;

import java.util.HashMap;
import java.util.Map;

public class MockDatabase {
    private Map<String, String[]> users = new HashMap<>();

    public void saveUser(String firstName, String lastName, String email, String telephone, String password, String confPassword) {
        users.put(email, new String[]{firstName, lastName, email, telephone, password, confPassword});
    }

    public boolean isUserPresent(String email) {
        return users.containsKey(email);
    }

    public String[] getUserDetails(String email) {
        return users.get(email);
    }
}
