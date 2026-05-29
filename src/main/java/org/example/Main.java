package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    static void main(String[] args) {
        PFArray pfArray = new PFArray();

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1 - Create random array");
            System.out.println("2 - Create manual array");
            System.out.println("3 - Print all arrays");
            System.out.println("4 - Select array");
            System.out.println("5 - Exit");
            System.out.print("Choice: ");

            int choice = readInt(scanner);

            switch (choice) {
                case 1 -> pfArray.createRandomArray();
                case 2 -> {
                    System.out.print("Enter numbers separated by comma: ");
                    pfArray.createManualArray(scanner.nextLine());
                }
                case 3 -> pfArray.printAllArrays();
                case 4 -> workWithArray(pfArray);
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }

    }

    /**
     * work with specific array
     * @param pfArray PFArray
     */
    private static void workWithArray(PFArray pfArray) {
        if (pfArray.size() == 0) {
            System.out.println("No arrays created yet.");
            return;
        }
        System.out.print("Enter array index: ");
        int index = readInt(scanner);

        if (index < 0 || index > pfArray.size()) {
            System.out.println("Invalid index");
            return;
        }
        while (true) {
            System.out.println("\n=== ARRAY MENU ===");
            System.out.println("1 - Print array");
            System.out.println("2 - Add number");
            System.out.println("3 - Find max");
            System.out.println("4 - Find min");
            System.out.println("5 - Sum");
            System.out.println("6 - Remove number");
            System.out.println("7 - Regenerate numbers");
            System.out.println("8 - Delete array");
            System.out.println("9 - Back");
            System.out.print("Choice: ");

            int choice = readInt(scanner);

            switch (choice) {
                case 1 -> pfArray.printArray(index);
                case 2 -> {
                    System.out.print("Enter number: ");
                    pfArray.addNumber(index, readInt(scanner));
                }
                case 3 -> {
                    if (pfArray.getArray(index).length == 0) {
                        System.out.println("Can not find max, array is empty");
                    } else {
                        System.out.println("Max = " + pfArray.findMax(index));
                    }
                }
                case 4 -> {
                    if (pfArray.getArray(index).length == 0) {
                        System.out.println("Can not find min, array is empty");
                    } else {
                        System.out.println("Min = " + pfArray.findMin(index));
                    }
                }
                case 5 -> {
                    if (pfArray.getArray(index).length == 0) {
                        System.out.println("Can sum, array is empty");
                    } else {
                        System.out.println("Sum = " + pfArray.sum(index));
                    }
                }
                case 6 -> {
                    System.out.print("Enter number to remove: ");
                    int num = readInt(scanner);
                    pfArray.removeNumber(index, num);
                }
                case 7 -> pfArray.regenerate(index);
                case 8 -> {
                    pfArray.deleteArray(index);
                    return;
                }
                case 9 -> { return; }
                default -> System.out.println("Invalid choice.");

            }
        }

    }

    /**
     * read only integer from user input
     * @param scanner scanner
     * @return choice
     */
    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}
