package stocktrading;

public class Portfolio {

    private Stock stock;
    private int quantity;

    public Portfolio(Stock stock, int quantity) {
        this.stock = stock;
        this.quantity = quantity;
    }

    public Stock getStock() {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void buy(int qty) {
        quantity += qty;
    }

    public boolean sell(int qty) {

        if (qty > quantity)
            return false;

        quantity -= qty;
        return true;
    }

    public double getValue() {
        return stock.getPrice() * quantity;
    }

    public void displayPortfolio() {

        System.out.println(
                stock.getSymbol()
                        + " | Shares: "
                        + quantity
                        + " | Value: $"
                        + getValue()
        );
    }
}