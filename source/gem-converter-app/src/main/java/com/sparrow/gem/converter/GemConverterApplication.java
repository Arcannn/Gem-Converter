package com.sparrow.gem.converter;

import java.util.Scanner;

public class GemConverterApplication {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user and read the number of sapphires
        System.out.println("Which type of gem do you want to process?");
        System.out.println("1. Sapphires");
        System.out.println("2. Emeralds");
        System.out.println("3. Diamonds");
        System.out.println("4. Rubies");
        System.out.println("5. Dragonstones");
        System.out.print("Enter the number corresponding to your choice: ");
        int gemChoice = scanner.nextInt();
        String gemName;

        switch (gemChoice) {
            case 1:
                gemName = "sapphires";
                break;
            case 2:
                gemName = "emeralds";
                break;
            case 3:
                gemName = "diamonds";
                break;
            case 4:
                gemName = "rubies";
                break;
            case 5:
                gemName = "dragonstones";
                break;
            default:
                System.out.println("Invalid choice. Please select a number between 1 and 5.");
                return;
        }

        // Prompt the user to enter the number of selected gems
        System.out.print("How many " + gemName + " do you have? ");
        int gemCount = scanner.nextInt();

        // Process the selected gem type
        processGem(scanner, gemName, gemCount);

        // Close the scanner
        scanner.close();
    }

    // Method to process each type of gem
    public static void processGem(Scanner scanner, String gemName, int gemCount) {
        if (gemCount > 0) {
            // Ask if the gems are cut or uncut
            System.out.print("Are your " + gemName + " cut or uncut? (cut/uncut): ");
            String gemType = scanner.next();

            if (gemType.equalsIgnoreCase("cut")) {
                // If the gems are cut, ask what type of jewelry they want to make
                System.out.println("What type of jewelry do you want to make with the " + gemName + "?");
                System.out.println("1. Necklaces");
                System.out.println("2. Rings");
                System.out.println("3. Bracelets");
                System.out.println("4. Amulets");
                System.out.print("Enter the number corresponding to your choice: ");
                int jewelryChoice = scanner.nextInt();
                String jewelryType;

                // jewelry calcs --
                int totalXP;

                // sapphires
                if (gemName.equalsIgnoreCase("sapphires")) {
                    switch (jewelryChoice) {
                        case 1:
                            jewelryType = "Necklaces";
                            totalXP = gemCount * 55;
                            break;
                        case 2:
                            jewelryType = "Rings";
                            totalXP = gemCount * 40;
                            break;
                        case 3:
                            jewelryType = "Bracelets";
                            totalXP = gemCount * 60;
                            break;
                        case 4:
                            jewelryType = "Amulets";
                            totalXP = gemCount * 65;
                            break;
                        default:
                            System.out.println("Invalid choice. Please select a number between 1 and 4.");
                            return;
                    }
                    System.out.println("You want to make " + jewelryType + " with your " + gemCount + " cut " + gemName + ". You also require " + gemCount + " gold bars.");
                    System.out.println("XP output for turning sapphires into sapphire " + jewelryType + ": " + totalXP + "xp");
                }
                // emeralds
                if (gemName.equalsIgnoreCase("emeralds")) {
                    switch (jewelryChoice) {
                        case 1:
                            jewelryType = "Necklaces";
                            totalXP = gemCount * 60;
                            break;
                        case 2:
                            jewelryType = "Rings";
                            totalXP = gemCount * 55;
                            break;
                        case 3:
                            jewelryType = "Bracelets";
                            totalXP = gemCount * 65;
                            break;
                        case 4:
                            jewelryType = "Amulets";
                            totalXP = gemCount * 70;
                            break;
                        default:
                            System.out.println("Invalid choice. Please select a number between 1 and 4.");
                            return;
                    }
                    System.out.println("You want to make " + jewelryType + " with your " + gemCount + " cut " + gemName + ". You also require " + gemCount + " gold bars.");
                    System.out.println("XP output for turning emeralds into emerald " + jewelryType + ": " + totalXP + "xp");
                }

                // diamonds
                    if (gemName.equalsIgnoreCase("diamonds")) {
                        switch (jewelryChoice) {
                            case 1:
                                jewelryType = "Necklaces";
                                totalXP = gemCount * 90;
                                break;
                            case 2:
                                jewelryType = "Rings";
                                totalXP = gemCount * 85;
                                break;
                            case 3:
                                jewelryType = "Bracelets";
                                totalXP = gemCount * 95;
                                break;
                            case 4:
                                jewelryType = "Amulets";
                                totalXP = gemCount * 100;
                                break;
                            default:
                                System.out.println("Invalid choice. Please select a number between 1 and 4.");
                                return;
                        }
                        System.out.println("You want to make " + jewelryType + " with your " + gemCount + " cut " + gemName + ". You also require " + gemCount + " gold bars.");
                        System.out.println("XP output for turning diamonds into diamond " + jewelryType + ": " + totalXP + "xp");
                    }
                    // rubies
                    if (gemName.equalsIgnoreCase("rubies")) {
                        switch (jewelryChoice) {
                            case 1:
                                jewelryType = "Necklaces";
                                totalXP = gemCount * 75;
                                break;
                            case 2:
                                jewelryType = "Rings";
                                totalXP = gemCount * 70;
                                break;
                            case 3:
                                jewelryType = "Bracelets";
                                totalXP = gemCount * 80;
                                break;
                            case 4:
                                jewelryType = "Amulets";
                                totalXP = gemCount * 85;
                                break;
                            default:
                                System.out.println("Invalid choice. Please select a number between 1 and 4.");
                                return;
                        }
                        System.out.println("You want to make " + jewelryType + " with your " + gemCount + " cut " + gemName + ". You also require " + gemCount + " gold bars.");
                        System.out.println("XP output for turning rubies into ruby " + jewelryType + ": " + totalXP + "xp");
                    }

                    // dragonstones
                    if (gemName.equalsIgnoreCase("dragonstones")) {
                        switch (jewelryChoice) {
                            case 1:
                                jewelryType = "Necklaces";
                                totalXP = gemCount * 55;
                                break;
                            case 2:
                                jewelryType = "Rings";
                                totalXP = gemCount * 40;
                                break;
                            case 3:
                                jewelryType = "Bracelets";
                                totalXP = gemCount * 60;
                                break;
                            case 4:
                                jewelryType = "Amulets";
                                totalXP = gemCount * 65;
                                break;
                            default:
                                System.out.println("Invalid choice. Please select a number between 1 and 4.");
                                return;
                        }
                        System.out.println("You want to make " + jewelryType + " with your " + gemCount + " cut " + gemName + ". You also require " + gemCount + " gold bars.");
                        System.out.println("XP output for turning dragonstones into dragonstone " + jewelryType + ": " + totalXP + "xp");
                    }

                    // if uncut
                } else if (gemType.equalsIgnoreCase("uncut")) {
                    // Perform calculations for uncut gems
                    int uncutValue = 0;
                    if (gemName.equalsIgnoreCase("sapphires")) {
                        uncutValue = gemCount * 50;
                    } else if (gemName.equalsIgnoreCase("emeralds")) {
                        uncutValue = (int) (gemCount * 67.5);
                    } else if (gemName.equalsIgnoreCase("diamonds")) {
                        uncutValue = (int) (gemCount * 107.5);
                    } else if (gemName.equalsIgnoreCase(("rubies"))) {
                        uncutValue = (gemCount * 85);
                    } else if (gemName.equalsIgnoreCase("dragonstones")) {
                        uncutValue = (int) (gemCount * 137.5);
                    }
                    System.out.println("You would gain " + uncutValue + " xp by cutting them");
                }
            }
        }
    }

