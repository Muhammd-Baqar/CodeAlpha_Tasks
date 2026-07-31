package hotel;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void saveBooking(Reservation reservation) {

        try {
            FileWriter writer = new FileWriter("bookings.txt", true);

            writer.write("Customer: " + reservation.getCustomerName() + "\n");
            writer.write("Room Number: " + reservation.getRoom().getRoomNumber() + "\n");
            writer.write("Room Type: " + reservation.getRoom().getRoomType() + "\n");
            writer.write("Days: " + reservation.getNumberOfDays() + "\n");
            writer.write("Total Bill: Rs. " + reservation.getTotalAmount() + "\n");
            writer.write("-----------------------------------\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving booking!");
        }
    }
}