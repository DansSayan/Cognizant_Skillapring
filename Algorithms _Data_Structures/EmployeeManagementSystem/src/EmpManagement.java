public class EmpManagement {
    private Employee[] employees;
    private int count; 

    public EmpManagement(int capacity) {
        this.employees = new Employee[capacity];
        this.count = 0;
    }


    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count] = emp;
            count++;
            System.out.println("Added: " + emp.getEmployeeId());
        } else {
            System.out.println("Error: Array is full! Cannot add " + emp.getEmployeeId());
        }
    }

    public Employee searchEmployee(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        System.out.println("\nCurrent Employee Directory:-");
        if (count == 0) {
            System.out.println("No records available");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(employees[i]);
            }
        }
        System.out.println("----------------------------------");
    }

    public void deleteEmployee(String id) {
        int indexToDelete = -1;

        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Error: Employee ID " + id + " not found.");
            return;
        }

        for (int i = indexToDelete; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null; 
        count--;
        System.out.println("Successfully deleted Employee ID: " + id);
    } 
}
