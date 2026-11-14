
import java.util.ArrayList;
import java.util.Scanner;

// Performs insertion, deletion, linear search,
// and left/right rotation on a 1D list.

public class Main {

    static void insertValue(ArrayList<Integer> arr, int index, int value) {
        if (index < 0 || index > arr.size()) {
            throw new IndexOutOfBoundsException(
                "Index must be between 0 and " + arr.size() + "."
            );
        }
        arr.add(index, value);
    }

    static int deleteValue(ArrayList<Integer> arr, int index) {
        if (index < 0 || index >= arr.size()) {
            throw new IndexOutOfBoundsException(
                "Index must be between 0 and " + (arr.size() - 1) + "."
            );
        }
        return arr.remove(index);
    }

    static int linearSearch(ArrayList<Integer> arr, int target) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == target) {
                return i;
            }
        }
        return -1;
    }

    static void rotateLeft(ArrayList<Integer> arr, int k) {
        if (arr.isEmpty()) return;

        k %= arr.size();

        for (int i = 0; i < k; i++) {
            int first = arr.remove(0);
            arr.add(first);
        }
    }

    static void rotateRight(ArrayList<Integer> arr, int k) {
        if (arr.isEmpty()) return;

        k %= arr.size();

        for (int i = 0; i < k; i++) {
            int last = arr.remove(arr.size() - 1);
            arr.add(0, last);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        System.out.print("Enter array elements separated by spaces (blank for empty): ");
        String input = sc.nextLine().trim();

        if (!input.isEmpty()) {
            for (String s : input.split("\\s+")) {
                arr.add(Integer.parseInt(s));
            }
        }

        while (true) {
            System.out.println("\nArray: " + arr);
            System.out.println("1.Insert  2.Delete  3.Linear search  4.Rotate left  5.Rotate right  6.Exit");
            System.out.print("Choice: ");
            String choice = sc.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Index (0 to len): ");
                        int index = Integer.parseInt(sc.nextLine());

                        System.out.print("Value: ");
                        int value = Integer.parseInt(sc.nextLine());

                        insertValue(arr, index, value);
                        System.out.println("Updated array: " + arr);
                        break;

                    case "2":
                        System.out.print("Index to delete: ");
                        index = Integer.parseInt(sc.nextLine());

                        int removed = deleteValue(arr, index);
                        System.out.println("Removed " + removed + ". Array: " + arr);
                        break;

                    case "3":
                        System.out.print("Value to search: ");
                        int target = Integer.parseInt(sc.nextLine());

                        index = linearSearch(arr, target);

                        if (index != -1) {
                            System.out.println("Found at index " + index + ".");
                        } else {
                            System.out.println("Value not found.");
                        }
                        break;

                    case "4":
                    case "5":
                        System.out.print("Rotate by k positions: ");
                        int k = Integer.parseInt(sc.nextLine());

                        if (k < 0) {
                            System.out.println("k must be non-negative.");
                            continue;
                        }

                        if (choice.equals("4")) {
                            rotateLeft(arr, k);
                        } else {
                            rotateRight(arr, k);
                        }

                        System.out.println("Updated array: " + arr);
                        break;

                    case "6":
                        System.out.println("Exiting.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
