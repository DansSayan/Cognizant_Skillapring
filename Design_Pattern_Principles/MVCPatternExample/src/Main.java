// Step 5: Test the MVC Implementation
public class Main {
    public static void main(String[] args) {
        Student studentModel = getStudent();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(studentModel, view);

        System.out.println("Initial State:");
        controller.updateView();

        controller.setStudentGrade("A+");
        System.out.println("Updated State:");
        controller.updateView();
    }

    private static Student getStudent() {
        Student student = new Student();
        student.setName("Sayan Sikder");
        student.setId("RA2311026010442");
        student.setGrade("A");
        return student;
    }
}