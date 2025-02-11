import java.util.Scanner;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        processInput();
    }

    public static void processInput() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter a number: ");
            try {
                double number = Double.parseDouble(scanner.nextLine());

                if (number == 0) {
                    throw new ArithmeticException("Cannot calculate reciprocal of zero.");
                }

                double reciprocal = 1 / number;
                System.out.println("Reciprocal: " + reciprocal);
                validInput = true;  // Exit loop after valid input and processing
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numerical value.");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
