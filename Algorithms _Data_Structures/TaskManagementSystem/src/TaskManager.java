public class TaskManager {
    private static class Node {
        Task data;
        Node next;
        Node(Task data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null; 
    public void addTask(Task task) {
        Node newNode = new Node(task);
        
        if (head == null) head = newNode; 
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next; 
            }
            current.next = newNode;
        }
        System.out.println("Added Task: " + task.getTaskId());
    }

    public Task searchTask(String id) {
        Node current = head;
        while (current != null) {
            if (current.data.getTaskId().equals(id)) {
                return current.data; 
            }
            current = current.next; 
        }
        return null; 
    }

    public void traverseTasks() {
        System.out.println("\n--- Current Task List ---");
        if (head == null) {
            System.out.println("[No tasks scheduled]");
        } else {
            Node current = head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
        System.out.println();
    }

    public void deleteTask(String id) {
        if (head == null) {
            System.out.println("Error: List is empty.");
            return;
        }
        if (head.data.getTaskId().equals(id)) {
            head = head.next;
            System.out.println("Successfully deleted Task ID: " + id);
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.getTaskId().equals(id)) {

                current.next = current.next.next; 
                System.out.println("Successfully deleted Task ID: " + id);
                return;
            }
            current = current.next;
        }
        System.out.println("Error: Task ID " + id + " not found.");
    }
}
