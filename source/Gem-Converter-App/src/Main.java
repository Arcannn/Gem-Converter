//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user and read the number of sapphires
        System.out.print("How many sapphires do you have? ");
        int sapphires = scanner.nextInt();
        processGem(scanner, "sapphires", sapphires);

        // Prompt the user and read the number of emeralds
        System.out.print("How many emeralds do you have? ");
        int emeralds = scanner.nextInt();
        processGem(scanner, "emeralds", emeralds);

        // Prompt the user and read the number of diamonds
        System.out.print("How many diamonds do you have? ");
        int diamonds = scanner.nextInt();
        processGem(scanner, "diamonds", diamonds);

        // Prompt the user and read the number of dragonstones
        System.out.print("How many dragonstones do you have? ");
        int dragonstones = scanner.nextInt();
        processGem(scanner, "dragonstones", dragonstones);

        // Close the scanner
        scanner.close();
    }

    // Method to process each type of gem
    public static void processGem(Scanner scanner, String gemName, int gemCount) {
        if (gemCount > 0) {
            // Ask if the gems are cut or uncut
            System.out.print("Are your " + gemName + " cut or uncut? (cut/uncut): ");
            String gemType = scanner.next();

            // If the gems are cut, ask what type of jewelry they want to make
            if (gemType.equalsIgnoreCase("cut")) {
                System.out.print("What type of jewelry do you want to make with the " + gemName + "? ");
                String jewelryType = scanner.next();
                System.out.println("You want to make " + jewelryType + " with your " + gemCount + " cut " + gemName + ".");
            } else {
                System.out.println("You have " + gemCount + " uncut " + gemName + ".");
            }
        } else {
            System.out.println("You have no " + gemName + ".");
        }
    }
}
// uncut sap 50xp
