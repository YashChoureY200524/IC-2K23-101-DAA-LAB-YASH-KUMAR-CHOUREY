
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    // Linear Search
    static int linearSearch(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    static int binarySearch(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        while (true) {
            System.out.println("\nSEARCHING MENU");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value to search: ");
                    int target = sc.nextInt();

                    int result = linearSearch(arr, target);

                    if (result != -1) {
                        System.out.println("Element found at index " + result);
                    } else {
                        System.out.println("Element not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter value to search: ");
                    target = sc.nextInt();

                    // Binary search requires sorted array
                    int sortedArr[] = arr.clone();
                    Arrays.sort(sortedArr);

                    System.out.println("Sorted array: " +
                                       Arrays.toString(sortedArr));

                    result = binarySearch(sortedArr, target);

                    if (result != -1) {
                        System.out.println("Element found at index " + result);
                    } else {
                        System.out.println("Element not found.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
