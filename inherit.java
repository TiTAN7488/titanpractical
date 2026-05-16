import java.util.Scanner;

// Superclass
class Person
{
    String name;
    int age;

    void getPersonDetails(Scanner sc)
    {
        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Age: ");
        age = sc.nextInt();

        sc.nextLine(); // Clear buffer
    }

    void displayPersonDetails()
    {
        System.out.println("\n--- Person Details ---");

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Subclass
class Employee extends Person
{
    int empId;
    String designation;
    String department;
    double salary;

    // Monthly salary

    void getEmployeeDetails(Scanner sc)
    {
        System.out.print("Enter Employee ID: ");
        empId = sc.nextInt();

        sc.nextLine(); // Clear buffer

        System.out.print("Enter Designation: ");
        designation = sc.nextLine();

        System.out.print("Enter Department: ");
        department = sc.nextLine();

        System.out.print("Enter Monthly Salary: ");
        salary = sc.nextDouble();
    }

    void displayEmployeeDetails()
    {
        System.out.println("\n--- Employee Details ---");

        System.out.println("Employee ID: " + empId);
        System.out.println("Designation: " + designation);
        System.out.println("Department: " + department);

        System.out.println("Monthly Salary: " + salary);

        System.out.println(
                "Annual Salary: " +
                calculateAnnualSalary()
        );
    }

    double calculateAnnualSalary()
    {
        return salary * 12;
    }
}

// Main class
public class inherit
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Employee e = new Employee();

        // Input
        e.getPersonDetails(sc);
        e.getEmployeeDetails(sc);

        // Output
        e.displayPersonDetails();
        e.displayEmployeeDetails();

        sc.close();
    }
}