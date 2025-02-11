import java.util.Scanner;

enum DaysOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public boolean isHoliday() {
        return this == SATURDAY || this == SUNDAY;
    }
}

public class EnumDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a day of the week: ");
        String inputDay = scanner.next().toUpperCase();

        try {
            DaysOfWeek day = DaysOfWeek.valueOf(inputDay);

            if (day.isHoliday()) {
                System.out.println("Holiday");
            } else {
                System.out.println("Not Holiday");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid day entered.");
        }

        scanner.close();
    }
}
