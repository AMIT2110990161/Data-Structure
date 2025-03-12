package LinkedList;

import java.util.Scanner;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManager {
    private Item head;

    public void addAtBeginning(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addAtPosition(int position, String name, int id, int quantity, double price) {
        if (position <= 0) {
            addAtBeginning(name, id, quantity, price);
            return;
        }
        Item newItem = new Item(name, id, quantity, price);
        Item temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            addAtEnd(name, id, quantity, price);
        } else {
            newItem.next = temp.next;
            temp.next = newItem;
        }
    }

    public void removeById(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void updateQuantity(int id, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    public Item searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public Item searchByName(String name) {
        Item temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public double calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.price * temp.quantity;
            temp = temp.next;
        }
        return totalValue;
    }

    public void displayInventory() {
        Item temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();

        while (true) {
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Item Quantity");
            System.out.println("6. Search Item by ID");
            System.out.println("7. Search Item by Name");
            System.out.println("8. Calculate Total Inventory Value");
            System.out.println("9. Display Inventory");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 10) break;

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Item Name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    if (choice == 1) manager.addAtBeginning(name, id, quantity, price);
                    else if (choice == 2) manager.addAtEnd(name, id, quantity, price);
                    else {
                        System.out.print("Enter Position: ");
                        int position = scanner.nextInt();
                        manager.addAtPosition(position, name, id, quantity, price);
                    }
                    break;
                case 4:
                    System.out.print("Enter Item ID to Remove: ");
                    id = scanner.nextInt();
                    manager.removeById(id);
                    break;
                case 5:
                    System.out.print("Enter Item ID to Update Quantity: ");
                    id = scanner.nextInt();
                    System.out.print("Enter New Quantity: ");
                    quantity = scanner.nextInt();
                    manager.updateQuantity(id, quantity);
                    break;
                case 6:
                    System.out.print("Enter Item ID to Search: ");
                    id = scanner.nextInt();
                    Item item = manager.searchById(id);
                    System.out.println(item != null ? "Found: " + item.name : "Item not found");
                    break;
                case 7:
                    System.out.print("Enter Item Name to Search: ");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    item = manager.searchByName(name);
                    System.out.println(item != null ? "Found: " + item.id : "Item not found");
                    break;
                case 8:
                    System.out.println("Total Inventory Value: " + manager.calculateTotalValue());
                    break;
                case 9:
                    manager.displayInventory();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}
