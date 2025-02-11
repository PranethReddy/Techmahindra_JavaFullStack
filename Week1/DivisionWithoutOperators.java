import java.util.Scanner;

public class DivisionWithoutOperators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter dividend: ");
        int dividend = scanner.nextInt();
        
        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();

        // Edge case for division by zero
        if (divisor == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return;
        }

        int quotient = 0;
        int remainder = dividend;

        while (remainder >= divisor) {
            remainder -= divisor;
            quotient++;
        }

        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);

        scanner.close();
    }
}
