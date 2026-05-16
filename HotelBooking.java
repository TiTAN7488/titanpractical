import java.util.Scanner;

public class Hotelbooking
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Taking number of floors
        System.out.print("Enter number of floors: ");
        int floors = sc.nextInt();

        // Jagged array (different rooms per floor)
        int[][] hotel = new int[floors][];

        // Input rooms for each floor
        for (int i = 0; i < floors; i++)
        {
            System.out.print(
                    "Enter number of rooms on floor " +
                    (i + 1) +
                    ": "
            );

            int rooms = sc.nextInt();

            hotel[i] = new int[rooms];
        }

        int choice;

        do
        {
            System.out.println("\n===== HOTEL BOOKING SYSTEM =====");

            System.out.println("1. View Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:

                    // Display room status
                    System.out.println("\nRoom Status:");

                    for (int i = 0; i < hotel.length; i++)
                    {
                        System.out.println("Floor " + (i + 1) + ":");

                        for (int j = 0; j < hotel[i].length; j++)
                        {
                            if (hotel[i][j] == 0)
                            {
                                System.out.print(
                                        "Room " + (j + 1) +
                                        " (Available)  "
                                );
                            }
                            else
                            {
                                System.out.print(
                                        "Room " + (j + 1) +
                                        " (Booked)  "
                                );
                            }
                        }

                        System.out.println();
                    }

                    break;

                case 2:

                    // Booking a room
                    System.out.print(
                            "Enter floor number (1-" +
                            floors +
                            "): "
                    );

                    int floor = sc.nextInt();

                    if (floor >= 1 && floor <= floors)
                    {
                        System.out.print(
                                "Enter room number (1-" +
                                hotel[floor - 1].length +
                                "): "
                        );

                        int room = sc.nextInt();

                        if (room >= 1 &&
                            room <= hotel[floor - 1].length)
                        {
                            if (hotel[floor - 1][room - 1] == 0)
                            {
                                hotel[floor - 1][room - 1] = 1;

                                System.out.println(
                                        "Room booked successfully!"
                                );
                            }
                            else
                            {
                                System.out.println(
                                        "Room already booked!"
                                );
                            }
                        }
                        else
                        {
                            System.out.println(
                                    "Invalid room number!"
                            );
                        }
                    }
                    else
                    {
                        System.out.println(
                                "Invalid floor number!"
                        );
                    }

                    break;

                case 3:

                    System.out.println(
                            "Exiting system. Thank you!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice! Try again."
                    );
            }

        } while (choice != 3);

        sc.close();
    }
}