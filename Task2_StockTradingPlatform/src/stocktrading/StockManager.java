package stocktrading;

import java.io.*;
import java.util.ArrayList;

public class StockManager {

    private ArrayList<Stock> market = new ArrayList<>();
    private ArrayList<Portfolio> portfolio = new ArrayList<>();

    private final String fileName = "portfolio.txt";

    public StockManager() {

        market.add(new Stock("AAPL", "Apple", 180));
        market.add(new Stock("GOOG", "Google", 140));
        market.add(new Stock("MSFT", "Microsoft", 330));
        market.add(new Stock("TSLA", "Tesla", 250));

        loadPortfolio();
    }

    public void showMarket() {

        System.out.println("\n===== Market Data =====");

        for (Stock stock : market) {
            stock.displayStock();
        }
    }

    public Stock searchStock(String symbol) {

        for (Stock stock : market) {

            if (stock.getSymbol().equalsIgnoreCase(symbol)) {
                return stock;
            }
        }

        return null;
    }

    public void buyStock(String symbol, int qty) {

        Stock stock = searchStock(symbol);

        if (stock == null) {

            System.out.println("Stock not found.");
            return;
        }

        for (Portfolio p : portfolio) {

            if (p.getStock().getSymbol().equalsIgnoreCase(symbol)) {

                p.buy(qty);
                savePortfolio();
                System.out.println("Stock Purchased.");
                return;
            }
        }

        portfolio.add(new Portfolio(stock, qty));

        savePortfolio();

        System.out.println("Stock Purchased.");
    }

    public void sellStock(String symbol, int qty) {

        for (Portfolio p : portfolio) {

            if (p.getStock().getSymbol().equalsIgnoreCase(symbol)) {

                if (p.sell(qty)) {

                    savePortfolio();
                    System.out.println("Stock Sold.");

                } else {

                    System.out.println("Not enough shares.");
                }

                return;
            }
        }

        System.out.println("Stock not found in portfolio.");
    }

    public void showPortfolio() {

        if (portfolio.isEmpty()) {

            System.out.println("Portfolio is empty.");
            return;
        }

        double total = 0;

        System.out.println("\n===== Portfolio =====");

        for (Portfolio p : portfolio) {

            p.displayPortfolio();
            total += p.getValue();
        }

        System.out.println("----------------------");
        System.out.println("Total Value: $" + total);
    }

    private void savePortfolio() {

        try {

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(fileName));

            for (Portfolio p : portfolio) {

                writer.write(
                        p.getStock().getSymbol() + ","
                                + p.getQuantity()
                );

                writer.newLine();
            }

            writer.close();

        } catch (Exception e) {

            System.out.println("File Save Error");
        }
    }

    private void loadPortfolio() {

        File file = new File(fileName);

        if (!file.exists())
            return;

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Stock stock = searchStock(data[0]);

                if (stock != null) {

                    portfolio.add(
                            new Portfolio(
                                    stock,
                                    Integer.parseInt(data[1])
                            )
                    );
                }
            }

            reader.close();

        } catch (Exception e) {

            System.out.println("File Load Error");
        }
    }
}