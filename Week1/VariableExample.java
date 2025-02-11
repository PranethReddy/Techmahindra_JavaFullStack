public class VariableExample {
    public static void main(String[] args) {
        int count = 5;
        int[] numbers = {1, 2, 3};

        alterVariables(count, numbers);

        System.out.println("Integer after method: " + count); // Should print 5
        System.out.print("Array after method: ");
        for (int num : numbers) {
            System.out.print(num + " "); // Should print modified array
        }
    }

    public static void alterVariables(int val, int[] nums) {
        val += 10; // This won't affect the original integer
        nums[0] += 10; // This will affect the original array
    }
}
