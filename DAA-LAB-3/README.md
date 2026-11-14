# Linear Search and Binary Search in Java

## Project Description

This project implements two searching algorithms using Java: Linear Search and Binary Search.

It is a menu-driven program that allows users to enter an array, select a searching algorithm, and find the position of a target element.

## Features

1. **Linear Search:** Searches for an element by checking each array element one by one.
2. **Binary Search:** Searches for an element by repeatedly dividing the sorted array into two halves.
3. **Menu-Driven Program:** Allows users to select their preferred searching method.
4. **Array Sorting:** Automatically sorts a copy of the array before performing binary search.
5. **Result Display:** Displays the index if the element is found; otherwise, displays "Element not found."

##  Technologies Used

- Programming Language: Java
- Data Structure: Array
- Searching Algorithms: Linear Search and Binary Search
- Input Handling: Scanner
- Sorting: Arrays.sort()
- IDE: VS Code / IntelliJ IDEA / Eclipse

## 📂 Project Structure

```text
Searching-Algorithms/
│
├── Main.java
└── README.md
```

## ⚙️ How to Run the Program

**Step 1:** Install Java JDK.

**Step 2:** Save the source code as `Main.java`.

**Step 3:** Open the terminal in the project folder.

**Step 4:** Compile the program:

```bash
javac Main.java
```

**Step 5:** Execute the program:

```bash
java Main
```

## 💻 Sample Input

```text
Enter number of elements: 5
Enter array elements:
10 20 30 40 50
```

## 📤 Sample Output

```text
SEARCHING MENU
1. Linear Search
2. Binary Search
3. Exit

Enter choice: 1
Enter value to search: 30
Element found at index 2
```

### Binary Search Example

```text
Enter choice: 2
Enter value to search: 40

Sorted array: [10, 20, 30, 40, 50]
Element found at index 3
```

## 📖 Algorithm Explanation

### 1. Linear Search

- Start from the first element.
- Compare each element with the target value.
- If a match is found, return its index.
- If no match is found, return -1.

### 2. Binary Search

- First, sort the array.
- Initialize `low` and `high` pointers.
- Calculate the middle index.
- Compare the middle element with the target.
- If the target is greater, search the right half.
- If the target is smaller, search the left half.
- Repeat until the element is found or the search space becomes empty.

## ⏱️ Time Complexity

| Case | Linear Search | Binary Search |
|---|---|---|
| Best Case | O(1) | O(1) |
| Average Case | O(n) | O(log n) |
| Worst Case | O(n) | O(log n) |

**Space Complexity:**

- Linear Search: O(1)
- Binary Search: O(1) auxiliary space (iterative implementation).

Note: The complete binary search operation in this program also includes sorting, which takes O(n log n) time.

## 🎯 Learning Outcomes

- Understand searching algorithms.
- Implement Linear Search in Java.
- Implement Binary Search using an iterative approach.
- Understand the importance of sorted arrays.
- Compare algorithm efficiency using time complexity.
- Practice arrays, methods, loops, and switch-case statements.

## 👨‍💻 Author

Created as a Data Structures and Algorithms (DSA) practice project.

## 📜 License

This project is open-source and intended for educational and learning purposes.
