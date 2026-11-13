# Performs row insertion/deletion, value search, and 90-degree clockwise rotation on a 2D list.

def validate_rectangular(matrix):
    if matrix and any(len(row) != len(matrix[0]) for row in matrix):
        raise ValueError("All rows must have the same number of columns.")

def insert_row(matrix, position, row):
    validate_rectangular(matrix)
    if position < 0 or position > len(matrix):
        raise IndexError(f"Position must be between 0 and {len(matrix)}.")
    expected_cols = len(matrix[0]) if matrix else len(row)
    if len(row) != expected_cols:
        raise ValueError(f"New row must contain exactly {expected_cols} values.")
    matrix.insert(position, row[:])

def delete_row(matrix, position):
    if position < 0 or position >= len(matrix):
        raise IndexError(f"Position must be between 0 and {len(matrix)-1}.")
    return matrix.pop(position)

def search_2d(matrix, target):
    for r, row in enumerate(matrix):
        for c, value in enumerate(row):
            if value == target:
                return (r, c)
    return None

def rotate_clockwise(matrix):
    validate_rectangular(matrix)
    if not matrix:
        return []
    return [list(row) for row in zip(*matrix[::-1])]

def display(matrix):
    if not matrix:
        print("[]")
    else:
        for row in matrix:
            print(row)

def main():
    rows = int(input("Number of rows: "))
    cols = int(input("Number of columns: "))
    if rows < 0 or cols < 0:
        print("Dimensions cannot be negative.")
        return
    matrix = []
    for r in range(rows):
        while True:
            values = input(f"Row {r} ({cols} integers): ").split()
            if len(values) == cols:
                try:
                    matrix.append([int(x) for x in values])
                    break
                except ValueError:
                    print("Enter integers only.")
            else:
                print(f"Enter exactly {cols} values.")
    while True:
        print("\nCurrent matrix:")
        display(matrix)
        print("1.Insert row  2.Delete row  3.Search value  4.Rotate 90° clockwise  5.Exit")
        choice = input("Choice: ").strip()
        try:
            if choice == "1":
                position = int(input("Insert position (0 to row count): "))
                row = list(map(int, input(f"Enter {len(matrix[0]) if matrix else 'required'} row values: ").split()))
                insert_row(matrix, position, row)
                print("Updated matrix:")
                display(matrix)
            elif choice == "2":
                position = int(input("Row index to delete: "))
                print("Deleted row:", delete_row(matrix, position))
                display(matrix)
            elif choice == "3":
                target = int(input("Value to search: "))
                result = search_2d(matrix, target)
                print(f"Found at row {result[0]}, column {result[1]}." if result else "Value not found.")
            elif choice == "4":
                matrix = rotate_clockwise(matrix)
                print("Rotated matrix:")
                display(matrix)
            elif choice == "5":
                break
            else:
                print("Invalid choice.")
        except (ValueError, IndexError) as error:
            print("Error:", error)

if __name__ == "__main__":
    main()
