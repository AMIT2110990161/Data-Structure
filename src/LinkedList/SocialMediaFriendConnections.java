package LinkedList;

import java.util.Scanner;

class User {
    int userID;
    String name;
    int age;
    int[] friendIDs;
    User next;

    public User(int userID, String name, int age, int[] friendIDs) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = friendIDs;
        this.next = null;
    }
}

class SocialMedia {
    private User head;

    public SocialMedia() {
        this.head = null;
    }

    public void addUser(int userID, String name, int age, int[] friendIDs) {
        User newUser = new User(userID, name, age, friendIDs);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    public void removeUser(int userID) {
        if (head == null) return;
        if (head.userID == userID) {
            head = head.next;
            return;
        }
        User temp = head;
        while (temp.next != null && temp.next.userID != userID) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void displayUsers() {
        User temp = head;
        while (temp != null) {
            System.out.print("User ID: " + temp.userID + ", Name: " + temp.name + ", Age: " + temp.age + ", Friends: ");
            for (int id : temp.friendIDs) {
                System.out.print(id + " ");
            }
            System.out.println();
            temp = temp.next;
        }
    }

    public void findMutualFriends(int userID1, int userID2) {
        User user1 = findUser(userID1);
        User user2 = findUser(userID2);
        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.print("Mutual Friends: ");
        for (int id1 : user1.friendIDs) {
            for (int id2 : user2.friendIDs) {
                if (id1 == id2) {
                    System.out.print(id1 + " ");
                }
            }
        }
        System.out.println();
    }

    private User findUser(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID) return temp;
            temp = temp.next;
        }
        return null;
    }
}

public class SocialMediaFriendConnections {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocialMedia sm = new SocialMedia();

        while (true) {
            System.out.println("1. Add User");
            System.out.println("2. Remove User");
            System.out.println("3. Display Users");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 5) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int userID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter number of friends: ");
                    int numFriends = scanner.nextInt();
                    int[] friendIDs = new int[numFriends];
                    System.out.print("Enter Friend IDs: ");
                    for (int i = 0; i < numFriends; i++) {
                        friendIDs[i] = scanner.nextInt();
                    }
                    sm.addUser(userID, name, age, friendIDs);
                    break;
                case 2:
                    System.out.print("Enter User ID to remove: ");
                    int removeID = scanner.nextInt();
                    sm.removeUser(removeID);
                    break;
                case 3:
                    sm.displayUsers();
                    break;
                case 4:
                    System.out.print("Enter first User ID: ");
                    int userID1 = scanner.nextInt();
                    System.out.print("Enter second User ID: ");
                    int userID2 = scanner.nextInt();
                    sm.findMutualFriends(userID1, userID2);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}
