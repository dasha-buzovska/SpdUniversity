package pizzeria;

import pizzeria.print.PrintConsole;

import java.util.Scanner;

public class PizzaHouse {
    public static void main(String[] args) {
        PrintConsole printConsole = new PrintConsole();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            printConsole.printSalads();
            System.out.print("Type index: ");
            String input = scanner.nextLine();

            if ("q".equals(input)) {
                System.out.println("Exit!");
                break;
            }

            System.out.println("input : " + input);
            System.out.println("-----------\n");
        }

        scanner.close();
    }

    static void makeOrder() {
        PrintConsole printConsole = new PrintConsole();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            printConsole.printSalads();
            System.out.print("Type index: ");
            String input = scanner.nextLine();

            if ("q".equals(input)) {
                System.out.println("Exit!");
                break;
            }

            System.out.println("input : " + input);
            System.out.println("-----------\n");
        }

        scanner.close();
    }

    static void printBill() {

    }
}
