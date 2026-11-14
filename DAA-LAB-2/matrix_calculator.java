
import java.util.ArrayList;
import java.util.Scanner;

// Menu-driven calculator for matrix addition,
// multiplication, transpose, and determinant.

public class Main {

    static Scanner sc = new Scanner(System.in);

    // Read matrix
    static ArrayList<ArrayList<Integer>> readMatrix(String name) {
        System.out.print(name + " rows: ");
        int rows = Integer.parseInt(sc.nextLine());

        System.out.print(name + " columns: ");
        int cols = Integer.parseInt(sc.nextLine());

        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException(
                "Dimensions must be positive."
            );
        }

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            System.out.print(name + " row " + (r + 1) +
                             " (" + cols + " values): ");

            String[] values = sc.nextLine().trim().split("\\s+");

            if (values.length != cols) {
                throw new IllegalArgumentException(
                    "Enter exactly " + cols + " values."
                );
            }

            ArrayList<Integer> row = new ArrayList<>();

            for (String value : values) {
                row.add(Integer.parseInt(value));
            }

            matrix.add(row);
        }

        return matrix;
    }

    // Matrix Addition
    static ArrayList<ArrayList<Integer>> addMatrices(
            ArrayList<ArrayList<Integer>> a,
            ArrayList<ArrayList<Integer>> b) {

        if (a.size() != b.size() ||
            a.get(0).size() != b.get(0).size()) {
            throw new IllegalArgumentException(
                "Addition requires equal dimensions."
            );
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int r = 0; r < a.size(); r++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int c = 0; c < a.get(0).size(); c++) {
                row.add(a.get(r).get(c) + b.get(r).get(c));
            }

            result.add(row);
        }

        return result;
    }

    // Matrix Multiplication
    static ArrayList<ArrayList<Integer>> multiplyMatrices(
            ArrayList<ArrayList<Integer>> a,
            ArrayList<ArrayList<Integer>> b) {

        if (a.get(0).size() != b.size()) {
            throw new IllegalArgumentException(
                "Multiplication requires columns of A = rows of B."
            );
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < b.get(0).size(); j++) {
                int sum = 0;

                for (int k = 0; k < b.size(); k++) {
                    sum += a.get(i).get(k) * b.get(k).get(j);
                }

                row.add(sum);
            }

            result.add(row);
        }

        return result;
    }

    // Matrix Transpose
    static ArrayList<ArrayList<Integer>> transpose(
            ArrayList<ArrayList<Integer>> matrix) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int c = 0; c < matrix.get(0).size(); c++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int r = 0; r < matrix.size(); r++) {
                row.add(matrix.get(r).get(c));
            }

            result.add(row);
        }

        return result;
    }

    // Determinant
    static int determinant(ArrayList<ArrayList<Integer>> matrix) {

        int n = matrix.size();

        for (ArrayList<Integer> row : matrix) {
            if (row.size() != n) {
                throw new IllegalArgumentException(
                    "Determinant requires a square matrix."
                );
            }
        }

        if (n == 1) {
            return matrix.get(0).get(0);
        }

        if (n == 2) {
            return matrix.get(0).get(0) * matrix.get(1).get(1)
                 - matrix.get(0).get(1) * matrix.get(1).get(0);
        }

        if (n == 3) {
            int a = matrix.get(0).get(0);
            int b = matrix.get(0).get(1);
            int c = matrix.get(0).get(2);

            int d = matrix.get(1).get(0);
            int e = matrix.get(1).get(1);
            int f = matrix.get(1).get(2);

            int g = matrix.get(2).get(0);
            int h = matrix.get(2).get(1);
            int i = matrix.get(2).get(2);

            return a * (e * i - f * h)
                 - b * (d * i - f * g)
                 + c * (d * h - e * g);
        }

        throw new IllegalArgumentException(
            "Determinant is implemented for 1x1, 2x2, and 3x3 matrices."
        );
    }

    // Display Matrix
    static void display(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix) {
            System.out.println(row);
        }
    }

    // Main Method
    public static void main(String[] args) {

        while (true) {
            System.out.println("\nMATRIX CALCULATOR");
            System.out.println("1.Add");
            System.out.println("2.Multiply");
            System.out.println("3.Transpose");
            System.out.println("4.Determinant");
            System.out.println("5.Exit");

            System.out.print("Choice: ");
            String choice = sc.nextLine().trim();

            try {
                switch (choice) {

                    case "1":
                        ArrayList<ArrayList<Integer>> a =
                            readMatrix("A");

                        ArrayList<ArrayList<Integer>> b =
                            readMatrix("B");

                        System.out.println("A + B:");
                        display(addMatrices(a, b));
                        break;

                    case "2":
                        a = readMatrix("A");
                        b = readMatrix("B");

                        System.out.println("A x B:");
                        display(multiplyMatrices(a, b));
                        break;

                    case "3":
                        a = readMatrix("A");

                        System.out.println("Transpose:");
                        display(transpose(a));
                        break;

                    case "4":
                        a = readMatrix("A");

                        System.out.println(
                            "Determinant: " + determinant(a)
                        );
                        break;

                    case "5":
                        System.out.println("Goodbye.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (IllegalArgumentException |
                     IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
