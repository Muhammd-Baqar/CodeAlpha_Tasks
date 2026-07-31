package stocktrading;

import java.util.Scanner;

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StockManager manager = new StockManager();

        int choice;

        do {

            System.out.println("\n==============================");
            System.out.println("   STOCK TRADING PLATFORM");
            System.out.println("==============================");
            System.out.println("1. Display Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    manager.showMarket();
                    break;

                case 2:

                    sc.nextLine();

                    System.out.print("Enter Stock Symbol: ");
                    String buySymbol = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int buyQty = sc.nextInt();

                    manager.buyStock(buySymbol, buyQty);

                    break;

                case 3:

                    sc.nextLine();

                    System.out.print("Enter Stock Symbol: ");
                    String sellSymbol = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int sellQty = sc.nextInt();

                    manager.sellStock(sellSymbol, sellQty);

                    break;

                case 4:

                    manager.showPortfolio();
                    break;

                case 5:

                    System.out.println("Thank you for using Stock Trading Platform.");
                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}