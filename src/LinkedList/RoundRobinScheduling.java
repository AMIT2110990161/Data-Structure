package LinkedList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Process {
    int processID, burstTime;
    Process next;

    public Process(int processID, int burstTime) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head, tail;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.head = null;
        this.tail = null;
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int processID, int burstTime) {
        Process newProcess = new Process(processID, burstTime);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    public void executeProcesses() {
        if (head == null) {
            System.out.println("No processes to execute.");
            return;
        }
        Process current = head;
        Queue<Integer> waitingTimes = new LinkedList<>();
        int totalTime = 0;
        int completedProcesses = 0;
        int totalProcesses = 0;

        Process temp = head;
        do {
            totalProcesses++;
            temp = temp.next;
        } while (temp != head);

        while (completedProcesses < totalProcesses) {
            if (current.burstTime > 0) {
                int execTime = Math.min(current.burstTime, timeQuantum);
                System.out.println("Executing Process ID: " + current.processID + " for " + execTime + " units.");
                current.burstTime -= execTime;
                totalTime += execTime;

                if (current.burstTime == 0) {
                    completedProcesses++;
                    waitingTimes.add(totalTime);
                }
            }
            current = current.next;
        }

        double avgWaitingTime = waitingTimes.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average Waiting Time: " + avgWaitingTime);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes available.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processID + ", Burst Time: " + temp.burstTime);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Time Quantum: ");
        int timeQuantum = scanner.nextInt();
        RoundRobinScheduler scheduler = new RoundRobinScheduler(timeQuantum);

        while (true) {
            System.out.println("1. Add Process");
            System.out.println("2. Execute Processes");
            System.out.println("3. Display Processes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 4) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID: ");
                    int processID = scanner.nextInt();
                    System.out.print("Enter Burst Time: ");
                    int burstTime = scanner.nextInt();
                    scheduler.addProcess(processID, burstTime);
                    break;
                case 2:
                    scheduler.executeProcesses();
                    break;
                case 3:
                    scheduler.displayProcesses();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}
