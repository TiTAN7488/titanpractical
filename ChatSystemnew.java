import java.util.Scanner;

class ChatUser extends Thread
{
    private String userName;
    private int messageCount;

    private boolean paused = false;
    private boolean stopped = false;

    ChatUser(String name, int count, int priority)
    {
        this.userName = name;
        this.messageCount = count;

        setPriority(priority);
    }

    public void run()
    {
        try
        {
            for (int i = 1; i <= messageCount; i++)
            {
                if (stopped)
                {
                    System.out.println(userName + " stopped.");
                    break;
                }

                synchronized (this)
                {
                    while (paused)
                    {
                        wait();
                    }
                }

                System.out.println(
                        userName +
                        " sends message " +
                        i
                );

                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println(userName + " interrupted.");
        }
    }

    public void pauseThread()
    {
        paused = true;
    }

    public synchronized void resumeThread()
    {
        paused = false;

        notify();
    }

    public void stopThread()
    {
        stopped = true;
    }
}

public class ChatSystemnew
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        ChatUser user1 = null;
        ChatUser user2 = null;

        while (true)
        {
            try
            {
                System.out.println("\n===== CHAT MENU =====");

                System.out.println("1. Start Chat");
                System.out.println("2. Pause Chat");
                System.out.println("3. Resume Chat");
                System.out.println("4. Stop Chat");
                System.out.println("5. Check Thread Status");
                System.out.println("6. Exit");

                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice)
                {
                    case 1:

                        System.out.print(
                                "Enter number of messages: "
                        );

                        int count = sc.nextInt();

                        user1 = new ChatUser(
                                "User1",
                                count,
                                Thread.MAX_PRIORITY
                        );

                        user2 = new ChatUser(
                                "User2",
                                count,
                                Thread.MIN_PRIORITY
                        );

                        user1.start();
                        user2.start();

                        System.out.println("Chat started...");

                        break;

                    case 2:

                        if (user1 != null && user2 != null)
                        {
                            user1.pauseThread();
                            user2.pauseThread();

                            System.out.println("Chat paused.");
                        }
                        else
                        {
                            System.out.println(
                                    "Start chat first!"
                            );
                        }

                        break;

                    case 3:

                        if (user1 != null && user2 != null)
                        {
                            user1.resumeThread();
                            user2.resumeThread();

                            System.out.println("Chat resumed.");
                        }
                        else
                        {
                            System.out.println(
                                    "Start chat first!"
                            );
                        }

                        break;

                    case 4:

                        if (user1 != null && user2 != null)
                        {
                            user1.stopThread();
                            user2.stopThread();

                            // Wait for threads to finish
                            user1.join();
                            user2.join();

                            System.out.println(
                                    "Chat stopped completely."
                            );
                        }
                        else
                        {
                            System.out.println(
                                    "Start chat first!"
                            );
                        }

                        break;

                    case 5:

                        if (user1 != null && user2 != null)
                        {
                            System.out.println(
                                    "User1 Alive: " +
                                    user1.isAlive()
                            );

                            System.out.println(
                                    "User2 Alive: " +
                                    user2.isAlive()
                            );
                        }
                        else
                        {
                            System.out.println(
                                    "Threads not created yet."
                            );
                        }

                        break;

                    case 6:

                        System.out.println("Exiting...");

                        System.exit(0);

                    default:

                        System.out.println(
                                "Invalid choice!"
                        );
                }
            }
            catch (Exception e)
            {
                System.out.println(
                        "Invalid input! Enter numbers only."
                );

                sc.nextLine();
            }
        }
    }
}