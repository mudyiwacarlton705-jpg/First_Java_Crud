import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String[]> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextId = 1;

    static void create() {
        System.out.print("Student name: ");
        String name = sc.nextLine();
        System.out.print("Course: ");
        String course = sc.nextLine();
        students.add(new String[]{"" + nextId++, name, course});
        System.out.println("Student created successfully!");
    }

    static void read() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        }
        for (String[] s : students) {
            System.out.println("ID: " + s[0] + " | Name: "
                + s[1] + " | Course: " + s[2]);
        }
    }

    static void update() {
        read();
        System.out.print("Enter student ID to update: ");
        String id = sc.nextLine();
        for (String[] s : students) {
            if (s[0].equals(id)) {
                System.out.print("New name: ");
                s[1] = sc.nextLine();
                System.out.print("New course: ");
                s[2] = sc.nextLine();
                System.out.println("Student updated!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void delete() {
        read();
        System.out.print("Enter student ID to delete: ");
        String id = sc.nextLine();
        boolean removed = students.removeIf(s -> s[0].equals(id));
        System.out.println(removed ? "Student deleted!" : "Student not found.");
    }

    public static void main(String[] args) {
        System.out.println("First Java CRUD - Student Management");
        while (true) {
            System.out.println("\n1. Create  2. Read  3. Update  4. Delete  5. Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1": create(); break;
                case "2": read(); break;
                case "3": update(); break;
                case "4": delete(); break;
                case "5":
                    System.out.println("Application stopped.");
                    return;
                default:
                    System.out.println("Choose 1, 2, 3, 4 or 5.");
            }
        }
    }
}
