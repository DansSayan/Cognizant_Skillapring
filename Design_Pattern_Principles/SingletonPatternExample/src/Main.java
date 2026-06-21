public class Main {
    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();
        log1.log("This is the first logger instance");
        log2.log("This is the second logger instance");
        
        System.out.println("\nVerifying Singleton Implementation:");
        System.out.println("log1 == log2: " + (log1 == log2));
        
        if (log1 == log2) 
            System.out.println("Only one instance of Logger exists throughout the application.");
        else
            System.out.println("Multiple instances of Logger exist");
    }
}
