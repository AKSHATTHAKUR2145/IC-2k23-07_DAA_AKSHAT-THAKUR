
public class ArrayOperations {

    private int[] arr = new int[100];
    private int size = 0;

    // Insert element at a specified position
    public void insert(int pos, int val) {

        if (pos < 0 || pos > size || size >= arr.length) {
            System.out.println("Invalid insertion position!");
            return;
        }

        for (int i = size; i > pos; i--) {
            arr[i] = arr[i - 1];
        }

        arr[pos] = val;
        size++;

        System.out.println("Element inserted successfully.");
    }

    // Delete element from specified position
    public void removeAt(int pos) {

        if (pos < 0 || pos >= size) {
            System.out.println("Invalid deletion position!");
            return;
        }

        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        size--;

        System.out.println("Element deleted successfully.");
    }

    // Search for an element
    public int search(int key) {

        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                return i;
            }
        }

        return -1;
    }

    // Update element at specified position
    public void update(int pos, int val) {

        if (pos >= 0 && pos < size) {
            arr[pos] = val;
            System.out.println("Element updated successfully.");
        } else {
            System.out.println("Invalid update position!");
        }
    }

    // Display array
    public void display() {

        System.out.print("Array: ");

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ArrayOperations a = new ArrayOperations();

        a.insert(0, 10);
        a.insert(1, 20);
        a.insert(2, 30);
        a.insert(1, 15);

        a.display();

        a.removeAt(2);
        a.display();

        System.out.println(
                "Element 30 found at index: " + a.search(30)
        );

        a.update(1, 25);
        a.display();
    }
}
