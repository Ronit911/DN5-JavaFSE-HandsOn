public class Logger {
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
    }

    // Public method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}
