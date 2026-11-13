# Performs insertion, deletion, linear search, and left/right rotation on a 1D list.

def insert_value(arr, index, value):
    if index < 0 or index > len(arr):
        raise IndexError(f"Index must be between 0 and {len(arr)}.")
    arr.insert(index, value)

def delete_value(arr, index):
    if index < 0 or index >= len(arr):
        raise IndexError(f"Index must be between 0 and {len(arr)-1}.")
    return arr.pop(index)

def linear_search(arr, target):
    for index, value in enumerate(arr):
        if value == target:
            return index
    return -1

def rotate_left(arr, k):
    if not arr:
        return
    k %= len(arr)
    arr[:] = arr[k:] + arr[:k]

def rotate_right(arr, k):
    if not arr:
        return
    k %= len(arr)
    if k:
        arr[:] = arr[-k:] + arr[:-k]

def main():
    arr = list(map(int, input("Enter array elements separated by spaces (blank for empty): ").split()))
    while True:
        print("\nArray:", arr)
        print("1.Insert  2.Delete  3.Linear search  4.Rotate left  5.Rotate right  6.Exit")
        choice = input("Choice: ").strip()
        try:
            if choice == "1":
                index = int(input("Index (0 to len): "))
                value = int(input("Value: "))
                insert_value(arr, index, value)
                print("Updated array:", arr)
            elif choice == "2":
                index = int(input("Index to delete: "))
                removed = delete_value(arr, index)
                print(f"Removed {removed}. Array:", arr)
            elif choice == "3":
                target = int(input("Value to search: "))
                index = linear_search(arr, target)
                print(f"Found at index {index}." if index != -1 else "Value not found.")
            elif choice in ("4", "5"):
                k = int(input("Rotate by k positions: "))
                if k < 0:
                    print("k must be non-negative.")
                    continue
                (rotate_left if choice == "4" else rotate_right)(arr, k)
                print("Updated array:", arr)
            elif choice == "6":
                print("Exiting.")
                break
            else:
                print("Invalid choice.")
        except (ValueError, IndexError) as error:
            print("Error:", error)

if __name__ == "__main__":
    main()
