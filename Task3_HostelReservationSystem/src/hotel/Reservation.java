package hotel;

public class Reservation {

    private String customerName;
    private String bookingDate;
    private Room room;
    private int numberOfDays;
    private double totalAmount;

    public Reservation(String customerName, Room room, String bookingDate, int numberOfDays) {
        this.customerName = customerName;
        this.bookingDate = bookingDate;
        this.room = room;
        this.numberOfDays = numberOfDays;
        this.totalAmount = room.getPrice() * numberOfDays;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public Room getRoom() {
        return room;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}