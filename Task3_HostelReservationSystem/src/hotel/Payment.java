package hotel;

public class Payment {

    private double amount;
    private boolean paymentStatus;

    public Payment(double amount) {
        this.amount = amount;
        this.paymentStatus = false;
    }

    public void makePayment() {
        paymentStatus = true;
        System.out.println("Payment Successful!");
        System.out.println("Amount Paid: Rs. " + amount);
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public double getAmount() {
        return amount;
    }
}