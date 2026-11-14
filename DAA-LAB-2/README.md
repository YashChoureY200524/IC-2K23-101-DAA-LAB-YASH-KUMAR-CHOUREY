# 2D Array Operations in Java

## Project Description

This project is a menu-driven Java program that performs basic operations on a 2D matrix using `ArrayList`. It allows users to insert rows, delete rows, search for elements, and rotate the matrix 90 degrees clockwise.

The program also validates matrix dimensions and handles invalid inputs using exception handling.

##  Features

1. **Insert Row:** Insert a new row at any valid position in the matrix.
2. **Delete Row:** Delete a row using its index.
3. **Search Value:** Search for a specific element and display its row and column position.
4. **Rotate Matrix:** Rotate the entire matrix 90 degrees clockwise.
5. **Display Matrix:** Display the current matrix after every operation.
6. **Input Validation:** Check row sizes, matrix dimensions, and invalid indexes.

## Technologies Used

- Programming Language: Java
- Data Structure: 2D ArrayList
- Input Handling: Scanner
- Exception Handling: try-catch
- IDE: VS Code / IntelliJ IDEA / Eclipse

##  Project Structure

```text
2D-Array-Operations/
│
├── Main.java
└── README.md
```

##  How to Run the Program

**Step 1:** Install Java JDK on your computer.

**Step 2:** Save the source code as `Main.java`.

**Step 3:** Open the terminal in the project folder.

**Step 4:** Compile the program:

```bash
javac Main.java
```

**Step 5:** Run the program:

```bash
java Main
```

## Sample Input

```text
Number of rows: 2
Number of columns: 3
Row 0 (3 integers): 1 2 3
Row 1 (3 integers): 4 5 6
```

## Sample Output

```text
Current matrix:
[1, 2, 3]
[4, 5, 6]

1.Insert row
2.Delete row
3.Search value
4.Rotate 90 degrees clockwise
5.Exit

Choice: 4

Rotated matrix:
[4, 1]
[5, 2]
[6, 3]
```

## Operations Explained

| Operation | Description |
|---|---|
| Insert Row | Adds a new row at a specified index. |
| Delete Row | Removes a row from the matrix. |
| Search | Finds an element and returns its position. |
| Rotate | Rotates the matrix 90° clockwise. |
| Display | Prints all matrix elements. |

##  Time Complexity

Let `R` represent the number of rows and `C` represent the number of columns.

| Operation | Time Complexity |
|---|---|
| Insert Row | O(R + C) |
| Delete Row | O(R + C) |
| Search Value | O(R × C) |
| Rotate Matrix | O(R × C) |
| Display Matrix | O(R × C) |

##  Learning Outcomes

- Understanding 2D data structures.
- Working with nested ArrayLists in Java.
- Implementing insertion and deletion operations.
- Understanding linear search in a matrix.
- Learning matrix rotation techniques.
- Applying exception handling and input validation.

## Author

Created as a Java Data Structures and Algorithms practice project.

## 📜 License

This project is open-source and available for educational and learning purposes.
