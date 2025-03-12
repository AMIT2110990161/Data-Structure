package LinkedList;

import java.util.Scanner;

class Book {
    String title, author, genre;
    int bookID;
    boolean isAvailable;
    Book next, prev;

    public Book(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManager {
    private Book head, tail;

    public void addAtBeginning(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addAtEnd(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void removeById(int bookID) {
        Book temp = head;
        while (temp != null && temp.bookID != bookID) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp == head) head = head.next;
        if (temp == tail) tail = tail.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    public Book searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public Book searchByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void updateAvailability(int bookID, boolean isAvailable) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookID == bookID) {
                temp.isAvailable = isAvailable;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayBooksForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.bookID + ", Title: " + temp.title + ", Author: " + temp.author + ", Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    public void displayBooksReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println("ID: " + temp.bookID + ", Title: " + temp.title + ", Author: " + temp.author + ", Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    public int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManager manager = new LibraryManager();

        while (true) {
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Remove Book by ID");
            System.out.println("4. Search Book by Title");
            System.out.println("5. Search Book by Author");
            System.out.println("6. Update Book Availability");
            System.out.println("7. Display Books Forward");
            System.out.println("8. Display Books Reverse");
            System.out.println("9. Count Total Books");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 10) break;

            switch (choice) {
                case 1:
                case 2:
                    System.out.print("Enter Book Title: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    int bookID = scanner.nextInt();
                    System.out.print("Is Available (true/false): ");
                    boolean isAvailable = scanner.nextBoolean();
                    if (choice == 1) manager.addAtBeginning(title, author, genre, bookID, isAvailable);
                    else manager.addAtEnd(title, author, genre, bookID, isAvailable);
                    break;
                case 3:
                    System.out.print("Enter Book ID to Remove: ");
                    bookID = scanner.nextInt();
                    manager.removeById(bookID);
                    break;
                case 4:
                    System.out.print("Enter Book Title to Search: ");
                    scanner.nextLine();
                    title = scanner.nextLine();
                    Book book = manager.searchByTitle(title);
                    System.out.println(book != null ? "Found: " + book.author : "Book not found");
                    break;
                case 5:
                    System.out.print("Enter Author to Search: ");
                    scanner.nextLine();
                    author = scanner.nextLine();
                    book = manager.searchByAuthor(author);
                    System.out.println(book != null ? "Found: " + book.title : "Book not found");
                    break;
                case 6:
                    System.out.print("Enter Book ID to Update Availability: ");
                    bookID = scanner.nextInt();
                    System.out.print("Is Available (true/false): ");
                    isAvailable = scanner.nextBoolean();
                    manager.updateAvailability(bookID, isAvailable);
                    break;
                case 7:
                    manager.displayBooksForward();
                    break;
                case 8:
                    manager.displayBooksReverse();
                    break;
                case 9:
                    System.out.println("Total Books: " + manager.countBooks());
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}
