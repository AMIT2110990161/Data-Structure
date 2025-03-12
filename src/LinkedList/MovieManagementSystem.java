package LinkedList;

import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieManager {
    private Movie head;
    private Movie tail;

    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 0) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            addAtEnd(title, director, year, rating);
        } else {
            newMovie.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newMovie;
            } else {
                tail = newMovie;
            }
            newMovie.prev = temp;
            temp.next = newMovie;
        }
    }

    public void deleteByTitle(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp == head) head = head.next;
        if (temp == tail) tail = tail.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    public Movie searchByDirector(String director) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public Movie searchByRating(double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.rating == rating) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieManager manager = new MovieManager();

        while (true) {
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Delete Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Display Movies Forward");
            System.out.println("9. Display Movies Reverse");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 10) break;

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Title: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    System.out.print("Enter Director: ");
                    String director = scanner.nextLine();
                    System.out.print("Enter Year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating = scanner.nextDouble();
                    if (choice == 1) manager.addAtBeginning(title, director, year, rating);
                    else if (choice == 2) manager.addAtEnd(title, director, year, rating);
                    else {
                        System.out.print("Enter Position: ");
                        int position = scanner.nextInt();
                        manager.addAtPosition(position, title, director, year, rating);
                    }
                    break;
                case 4:
                    System.out.print("Enter Movie Title to Delete: ");
                    scanner.nextLine();
                    title = scanner.nextLine();
                    manager.deleteByTitle(title);
                    break;
                case 5:
                    System.out.print("Enter Director to Search: ");
                    scanner.nextLine();
                    director = scanner.nextLine();
                    Movie movie = manager.searchByDirector(director);
                    System.out.println(movie != null ? "Found: " + movie.title : "Movie not found");
                    break;
                case 6:
                    System.out.print("Enter Rating to Search: ");
                    rating = scanner.nextDouble();
                    movie = manager.searchByRating(rating);
                    System.out.println(movie != null ? "Found: " + movie.title : "Movie not found");
                    break;
                case 7:
                    System.out.print("Enter Title to Update Rating: ");
                    scanner.nextLine();
                    title = scanner.nextLine();
                    System.out.print("Enter New Rating: ");
                    rating = scanner.nextDouble();
                    manager.updateRating(title, rating);
                    break;
                case 8:
                    manager.displayForward();
                    break;
                case 9:
                    manager.displayReverse();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}
