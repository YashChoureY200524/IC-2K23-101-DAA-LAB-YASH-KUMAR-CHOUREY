
import java.util.ArrayList;
import java.util.Scanner;

// Performs row insertion/deletion, value search,
// and 90-degree clockwise rotation on a 2D list.

public class Main {

    static void validateRectangular(ArrayList<ArrayList<Integer>> matrix) {
        if (!matrix.isEmpty()) {
            int cols = matrix.get(0).size();

            for (ArrayList<Integer> row : matrix) {
                if (row.size() != cols) {
                    throw new IllegalArgumentException(
                        "All rows must have the same number of columns."
                    );
                }
            }
        }
    }

    static void insertRow(ArrayList<ArrayList<Integer>> matrix,
                          int position, ArrayList<Integer> row) {
        validateRectangular(matrix);

        if (position < 0 || position > matrix.size()) {
            throw new IndexOutOfBoundsException(
                "Position must be between 0 and " + matrix.size() + "."
            );
        }

        int expectedCols = matrix.isEmpty()
                ? row.size()
                : matrix.get(0).size();

        if (row.size() != expectedCols) {
            throw new IllegalArgumentException(
                "New row must contain exactly " + expectedCols + " values."
            );
        }

        matrix.add(position, new ArrayList<>(row));
    }

    static ArrayList<Integer> deleteRow(
            ArrayList<ArrayList<Integer>> matrix, int position) {

        if (position < 0 || position >= matrix.size()) {
            throw new IndexOutOfBoundsException(
                "Position must be between 0 and " + (matrix.size() - 1) + "."
            );
        }

        return matrix.remove(position);
    }

    static int[] search2D(ArrayList<ArrayList<Integer>> matrix, int target) {
        for (int r = 0; r < matrix.size(); r++) {
            for (int c = 0; c < matrix.get(r).size(); c++) {
                if (matrix.get(r).get(c) == target) {
                    return new int[]{r, c};
                }
            }
        }
        return null;
    }

    static ArrayList<ArrayList<Integer>> rotateClockwise(
            ArrayList<ArrayList<Integer>> matrix) {

        validateRectangular(matrix);

        if (matrix.isEmpty()) {
            return new ArrayList<>();
        }

        int rows = matrix.size();
        int cols = matrix.get(0).size();

        ArrayList<ArrayList<Integer>> rotated = new ArrayList<>();

        for (int c = 0; c < cols; c++) {
            ArrayList<Integer> newRow = new ArrayList<>();

            for (int r = rows - 1; r >= 0; r--) {
                newRow.add(matrix.get(r).get(c));
            }

            rotated.add(newRow);
        }

        return rotated;
    }

    static void display(ArrayList<ArrayList<Integer>> matrix) {
        if (matrix.isEmpty()) {
            System.out.println("[]");
        } else {
            for (ArrayList<Integer> row : matrix) {
                System.out.println(row);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        System.out.print("Number of rows: ");
        int rows = Integer.parseInt(sc.nextLine());

        System.out.print("Number of columns: ");
        int cols = Integer.parseInt(sc.nextLine());

        if (rows < 0 || cols < 0) {
            System.out.println("Dimensions cannot be negative.");
            sc.close();
            return;
        }

        for (int r = 0; r < rows; r++) {
            while (true) {
                System.out.print("Row " + r + " (" + cols + " integers): ");
                String[] values = sc.nextLine().trim().split("\\s+");

                try {
                    if (cols == 0 && values.length == 1
                            && values[0].isEmpty()) {
                        matrix.add(new ArrayList<>());
                        break;
                    }

                    if (values.length != cols) {
                        System.out.println("Enter exactly " + cols + " values.");
                        continue;
                    }

                    ArrayList<Integer> row = new ArrayList<>();

                    for (String value : values) {
                        row.add(Integer.parseInt(value));
                    }

                    matrix.add(row);
                    break;

                } catch (NumberFormatException e) {
                    System.out.println("Enter integers only.");
                }
            }
        }

        while (true) {
            System.out.println("\nCurrent matrix:");
            display(matrix);

            System.out.println(
                "1.Insert row  2.Delete row  3.Search value " +
                " 4.Rotate 90 degrees clockwise  5.Exit"
            );

            System.out.print("Choice: ");
            String choice = sc.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Insert position (0 to row count): ");
                        int position = Integer.parseInt(sc.nextLine());

                        int expectedCols = matrix.isEmpty()
                                ? cols
                                : matrix.get(0).size();

                        System.out.print("Enter " + expectedCols + " row values: ");
                        String input = sc.nextLine().trim();

                        ArrayList<Integer> row = new ArrayList<>();

                        if (!input.isEmpty()) {
                            for (String value : input.split("\\s+")) {
                                row.add(Integer.parseInt(value));
                            }
                        }

                        insertRow(matrix, position, row);

                        System.out.println("Updated matrix:");
                        display(matrix);
                        break;

                    case "2":
                        System.out.print("Row index to delete: ");
                        position = Integer.parseInt(sc.nextLine());

                        System.out.println("Deleted row: " + deleteRow(matrix, position));
                        display(matrix);
                        break;

                    case "3":
                        System.out.print("Value to search: ");
                        int target = Integer.parseInt(sc.nextLine());

                        int[] result = search2D(matrix, target);

                        if (result != null) {
                            System.out.println(
                                "Found at row " + result[0] +
                                ", column " + result[1] + "."
                            );
                        } else {
                            System.out.println("Value not found.");
                        }
                        break;

                    case "4":
                        matrix = rotateClockwise(matrix);

                        System.out.println("Rotated matrix:");
                        display(matrix);
                        break;

                    case "5":
                        System.out.println("Exiting.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException | IndexOutOfBoundsException
                     | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
