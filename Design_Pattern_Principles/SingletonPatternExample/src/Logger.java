public class Logger {
    private static Logger self;
    private Logger() {
        System.out.println("Logger instance created");
    }
    public static Logger getInstance() {
        if (self == null) self = new Logger();
        return self;
    }
    public void log(String message) {
        System.out.println("[log] : " + message);
    }
}
