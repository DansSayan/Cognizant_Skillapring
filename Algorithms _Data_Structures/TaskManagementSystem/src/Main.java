public class Main {
    public static void main(String[] args) {
        TaskManager trackingSystem = new TaskManager();

        trackingSystem.addTask(new Task("T1", "Setup DB Router", "Pending"));
        trackingSystem.addTask(new Task("T2", "Code API Endpoints", "In Progress"));
        trackingSystem.addTask(new Task("T3", "Write Unit Tests", "Pending"));
        trackingSystem.traverseTasks();

        System.out.println("Searching:-");
        Task target = trackingSystem.searchTask("T2");
        System.out.println("Found: " + (target != null ? target : "Not Found"));

        System.out.println("\nDeletion:-");
        trackingSystem.deleteTask("T2");
        trackingSystem.traverseTasks();
    }
}
