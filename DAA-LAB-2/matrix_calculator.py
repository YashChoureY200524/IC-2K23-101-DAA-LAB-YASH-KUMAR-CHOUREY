# Menu-driven calculator for matrix addition, multiplication, transpose, and determinant (2x2/3x3).

def read_matrix(name):
    rows = int(input(f"{name} rows: "))
    cols = int(input(f"{name} columns: "))
    if rows <= 0 or cols <= 0:
        raise ValueError("Dimensions must be positive.")
    matrix = []
    for r in range(rows):
        values = list(map(int, input(f"{name} row {r+1} ({cols} values): ").split()))
        if len(values) != cols:
            raise ValueError(f"Enter exactly {cols} values.")
        matrix.append(values)
    return matrix

def add_matrices(a, b):
    if len(a) != len(b) or len(a[0]) != len(b[0]):
        raise ValueError("Addition requires equal dimensions.")
    return [[a[r][c] + b[r][c] for c in range(len(a[0]))] for r in range(len(a))]

def multiply_matrices(a, b):
    if len(a[0]) != len(b):
        raise ValueError("Multiplication requires columns of A = rows of B.")
    result = [[0 for _ in range(len(b[0]))] for _ in range(len(a))]
    for i in range(len(a)):
        for j in range(len(b[0])):
            for k in range(len(b)):
                result[i][j] += a[i][k] * b[k][j]
    return result

def transpose(matrix):
    return [list(row) for row in zip(*matrix)]

def determinant(matrix):
    n = len(matrix)
    if any(len(row) != n for row in matrix):
        raise ValueError("Determinant requires a square matrix.")
    if n == 1:
        return matrix[0][0]
    if n == 2:
        return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0]
    if n == 3:
        a,b,c = matrix[0]
        d,e,f = matrix[1]
        g,h,i = matrix[2]
        return a*(e*i-f*h) - b*(d*i-f*g) + c*(d*h-e*g)
    raise ValueError("Determinant is implemented for 1x1, 2x2, and 3x3 matrices.")

def display(matrix):
    for row in matrix:
        print(row)

def main():
    while True:
        print("\nMATRIX CALCULATOR")
        print("1.Add  2.Multiply  3.Transpose  4.Determinant  5.Exit")
        choice = input("Choice: ").strip()
        try:
            if choice == "1":
                a, b = read_matrix("A"), read_matrix("B")
                print("A + B:"); display(add_matrices(a, b))
            elif choice == "2":
                a, b = read_matrix("A"), read_matrix("B")
                print("A × B:"); display(multiply_matrices(a, b))
            elif choice == "3":
                a = read_matrix("A")
                print("Transpose:"); display(transpose(a))
            elif choice == "4":
                a = read_matrix("A")
                print("Determinant:", determinant(a))
            elif choice == "5":
                print("Goodbye.")
                break
            else:
                print("Invalid choice.")
        except (ValueError, IndexError) as error:
            print("Error:", error)

if __name__ == "__main__":
    main()
