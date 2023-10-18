import java.util.*;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee[] employees = new Employee[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter Employee Information for Employee " + (i + 1));
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Date of Birth (yyyy-MM-dd): ");
            Date dateOfBirth = null;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateOfBirth = dateFormat.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            }

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Joining Date (yyyy-MM-dd): ");
            Date joiningDate = null;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                joiningDate = dateFormat.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                System.exit(1);
            }

            System.out.print("Employee Type (1 for Officer, 2 for Staff): ");
            int employeeType = scanner.nextInt();
            scanner.nextLine();

            Employee employee = null;
            if (employeeType == 1) {
                employee = new Officer(id, name, dateOfBirth, email, joiningDate);
            } else if (employeeType == 2) {
                employee = new Staff(id, name, dateOfBirth, email, joiningDate);
            } else {
                System.out.println("Invalid employee type. Use 1 for Officer or 2 for Staff.");
                System.exit(1);
            }
            employees[i] = employee;
        }

        for (Employee employee : employees) {
            System.out.println("\nEmployee Details:");
            System.out.println(employee);

            Leave leave = employee.calculateLeave();
            System.out.println("\nLeave Information:");
            System.out.println("Vacation Leave: " + leave.getVacationLeave());
            System.out.println("Sick Leave: " + leave.getSickLeave());
        }
    }
}
