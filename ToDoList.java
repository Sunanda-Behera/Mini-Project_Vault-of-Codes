import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }
    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid task index!");
        }
    }
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
    public void markTaskComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            String task = tasks.get(index);
            tasks.set(index, "[Completed] " + task);
            System.out.println("Task marked as complete: " + task);
        } else {
            System.out.println("Invalid task index!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();

        while (true) {
            System.out.println("\n==== ToDo List Menu ====");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Mark Task as Complete");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String taskToAdd = scanner.nextLine();
                    toDoList.addTask(taskToAdd);
                    break;
                case 2:
                    System.out.print("Enter index of task to delete: ");
                    int indexToDelete = scanner.nextInt() - 1;
                    toDoList.deleteTask(indexToDelete);
                    break;
                case 3:
                    toDoList.displayTasks();
                    break;
                case 4:
                    System.out.print("Enter index of task to mark as complete: ");
                    int indexToMark = scanner.nextInt() - 1;
                    toDoList.markTaskComplete(indexToMark);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }
    }
}