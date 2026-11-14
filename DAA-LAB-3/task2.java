
import java.util.*;

public class Task2 {
    public static void main(String[] args) {

        String[] tasks = {
            "Task1", "Task2", "Task3", "Task4", "Task5"
        };

        // 1. Stack (LIFO)
        Stack<String> stack = new Stack<>();

        for (String task : tasks) {
            stack.push(task);
        }

        System.out.println("Stack Completion Order (LIFO):");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        // 2. Queue (FIFO)
        Queue<String> queue = new LinkedList<>();

        for (String task : tasks) {
            queue.add(task);
        }

        System.out.println("\nQueue Completion Order (FIFO):");

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        // 3. Printer uses Queue
        Queue<String> printer = new LinkedList<>();

        for (String task : tasks) {
            printer.add(task);
        }

        System.out.println("\nPrinter Job Order:");

        while (!printer.isEmpty()) {
            System.out.println("Printing: " + printer.poll());
        }
    }
}
