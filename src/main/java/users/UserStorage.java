package users;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserStorage {
    
    private static UserStorage userStorage = null;
    private Map<String, String> users;
    private static final int MIN_NUMBER_OF_SYMBOL = 3;
    
    private UserStorage() {
        users = new ConcurrentHashMap<String, String>();
    }
    
    public static UserStorage get() {
        if (userStorage == null) {
            synchronized (UserStorage.class) {
                if (userStorage == null) {
                    userStorage = new UserStorage();
                }
            }
        }
        return userStorage;
    }
    
    public boolean isContain(String login) {
        return users.containsKey(login);
    }
    
    public boolean validation(String login, String password) {
        return users.containsKey(login) && users.get(login).equals(password);
    }
    
    public boolean add(String login, String password) {
        boolean success = false;
        if (isValid(login) && isValid(password)) {
            users.put(login, password);
            success = true;
        }
        return success;
    }
    
    private boolean isValid(String field) {
        return field != null && field.length() >= MIN_NUMBER_OF_SYMBOL;
    }
}
