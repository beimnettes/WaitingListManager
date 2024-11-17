import java.util.*;

public class WaitingListManager {
    private Queue<String> waitingQueue;
    private Set<String> waitingSet;

    // Constructor
    public WaitingListManager() {
        this.waitingQueue = new LinkedList<>();
        this.waitingSet = new HashSet<>();
    }

    // Add a person to the waiting list
    public void addPerson(String name) {
        if (waitingSet.contains(name)) {
            System.out.println(name + " is already in the waiting list.");
        } else {
            waitingQueue.add(name);
            waitingSet.add(name);
            System.out.println(name + " has been added to the waiting list.");
        }
    }

    // Serve a person from the waiting list
    public String servePerson() {
        if (waitingQueue.isEmpty()) {
            return "The waiting list is empty.";
        } else {
            String served = waitingQueue.poll();
            waitingSet.remove(served);
            return "Serving: " + served;
        }
    }

    // Check if a person is in the waiting list
    public boolean isPersonInList(String name) {
        return waitingSet.contains(name);
    }

    // Get the size of the waiting list
    public int waitingListSize() {
        return waitingQueue.size();
    }

    // Display the waiting list
    public void displayWaitingList() {
        if (waitingQueue.isEmpty()) {
            System.out.println("The waiting list is empty.");
        } else {
            System.out.println("Waiting List: " + waitingQueue);
        }
    }

    // Main method with a text-based user interface
    public static void main(String[] args) {
        WaitingListManager manager = new WaitingListManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWaiting List Manager");
            System.out.println("1. Add Person");
            System.out.println("2. Serve Person");
            System.out.println("3. Check if Person is in List");
            System.out.println("4. Display Waiting List");
            System.out.println("5. Waiting List Size");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name to add: ");
                    String nameToAdd = scanner.nextLine();
                    manager.addPerson(nameToAdd);
                    break;
                case 2:
                    System.out.println(manager.servePerson());
                    break;
                case 3:
                    System.out.print("Enter name to check: ");
                    String nameToCheck = scanner.nextLine();
                    System.out.println(nameToCheck + (manager.isPersonInList(nameToCheck) ? " is in the waiting list." : " is not in the waiting list."));
                    break;
                case 4:
                    manager.displayWaitingList();
                    break;
                case 5:
                    System.out.println("Waiting list size: " + manager.waitingListSize());
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
