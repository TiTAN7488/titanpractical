import java.util.Scanner;

public class pract1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        boolean continueCalc = true;

        System.out.println("=== Welcome to Simple Java Calculator ===");

        while (continueCalc)
        {
            try
            {
                // Taking first number
                System.out.print("\nEnter first number: ");
                double num1 = sc.nextDouble();

                // Taking operator
                System.out.print("Enter operator (+, -, *, /): ");
                char operator = sc.next().charAt(0);

                // Taking second number
                System.out.print("Enter second number: ");
                double num2 = sc.nextDouble();

                double result;

                // Conditional logic for calculation
                if (operator == '+')
                {
                    result = num1 + num2;
                }
                else if (operator == '-')
                {
                    result = num1 - num2;
                }
                else if (operator == '*')
                {
                    result = num1 * num2;
                }
                else if (operator == '/')
                {
                    // Handling division by zero
                    if (num2 == 0)
                    {
                        System.out.println("Error: Cannot divide by zero!");
                        continue;
                    }

                    result = num1 / num2;
                }
                else
                {
                    System.out.println("Invalid operator! Please use +, -, *, or /");
                    continue;
                }

                // Display result
                System.out.println("Result: " + result);
            }
            catch (Exception e)
            {
                // Handling invalid input
                System.out.println("Invalid input! Please enter numbers only.");
                sc.nextLine(); // clear buffer
            }

            // Asking user if they want to continue
            System.out.print("\nDo you want to continue? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes"))
            {
                continueCalc = false;
            }
        }

        System.out.println("\nThank you for using the calculator!");

        sc.close();
    }
}