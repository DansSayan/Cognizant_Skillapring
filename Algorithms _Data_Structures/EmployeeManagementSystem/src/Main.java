public class Main {
    public static void main(String[] args) {
        EmpManagement directory = new EmpManagement(5); 

        directory.addEmployee(new Employee("E01", "John", "Manager", 75000));
        directory.addEmployee(new Employee("E02", "Sarah", "Developer", 65000));
        directory.addEmployee(new Employee("E03", "Mike", "Designer", 55000));
        directory.traverseEmployees();

        System.out.println("--- Testing Search ---");
        Employee found = directory.searchEmployee("E02");
        System.out.println("Search Result: " + (found != null ? found : "Not Found"));

        System.out.println("\n--- Testing Deletion ---");
        directory.deleteEmployee("E02"); 
        directory.traverseEmployees(); 
    }
}
