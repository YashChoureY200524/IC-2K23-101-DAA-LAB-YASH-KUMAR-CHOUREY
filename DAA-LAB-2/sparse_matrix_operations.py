# Converts matrices to/from sparse triples and adds sparse matrices without densifying inputs.

def validate_matrix(matrix):
    if matrix and any(len(row) != len(matrix[0]) for row in matrix):
        raise ValueError("Matrix must be rectangular.")

def to_sparse(matrix):
    validate_matrix(matrix)
    rows = len(matrix)
    cols = len(matrix[0]) if rows else 0
    triples = [(rows, cols, sum(value != 0 for row in matrix for value in row))]
    for r, row in enumerate(matrix):
        for c, value in enumerate(row):
            if value != 0:
                triples.append((r, c, value))
    return triples

def from_sparse(triples):
    if not triples:
        return []
    rows, cols, count = triples[0]
    if rows < 0 or cols < 0:
        raise ValueError("Dimensions cannot be negative.")
    matrix = [[0 for _ in range(cols)] for _ in range(rows)]
    for r, c, value in triples[1:]:
        if not (0 <= r < rows and 0 <= c < cols):
            raise IndexError("Sparse entry has an invalid coordinate.")
        matrix[r][c] = value
    return matrix

def add_sparse(a, b):
    if not a or not b:
        raise ValueError("Sparse matrices must include a dimension header.")
    if a[0][:2] != b[0][:2]:
        raise ValueError("Matrix dimensions must match for addition.")
    rows, cols = a[0][0], a[0][1]
    values = {}
    for r, c, value in a[1:] + b[1:]:
        values[(r, c)] = values.get((r, c), 0) + value
    entries = [(r, c, value) for (r, c), value in sorted(values.items()) if value != 0]
    return [(rows, cols, len(entries))] + entries

def print_matrix(matrix):
    for row in matrix:
        print(row)

def print_sparse(triples):
    print("(rows, columns, non-zero count) / (row, column, value)")
    for item in triples:
        print(item)

def read_matrix(label):
    rows = int(input(f"{label}: rows = "))
    cols = int(input(f"{label}: columns = "))
    if rows < 0 or cols < 0:
        raise ValueError("Dimensions cannot be negative.")
    matrix = []
    for r in range(rows):
        values = list(map(int, input(f"Row {r} ({cols} integers): ").split()))
        if len(values) != cols:
            raise ValueError(f"Row must contain exactly {cols} values.")
        matrix.append(values)
    return matrix

def main():
    try:
        first = read_matrix("Matrix A")
        second = read_matrix("Matrix B")
        sparse_a, sparse_b = to_sparse(first), to_sparse(second)
        print("\nSparse A:"); print_sparse(sparse_a)
        print("Reconstructed A:"); print_matrix(from_sparse(sparse_a))
        print("\nSparse B:"); print_sparse(sparse_b)
        print("Reconstructed B:"); print_matrix(from_sparse(sparse_b))
        result = add_sparse(sparse_a, sparse_b)
        print("\nSparse A + B:"); print_sparse(result)
        print("Reconstructed A + B:"); print_matrix(from_sparse(result))
    except (ValueError, IndexError) as error:
        print("Error:", error)

if __name__ == "__main__":
    main()
