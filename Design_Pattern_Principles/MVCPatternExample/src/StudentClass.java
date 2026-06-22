class Student {
    private String id;
    private String name;
    private String grade;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}

class StudentView {
    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        System.out.println("Name : " + studentName);
        System.out.println("ID   : " + studentId);
        System.out.println("Grade: " + studentGrade);
        System.out.println();
    }
}