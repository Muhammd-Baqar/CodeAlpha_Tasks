package hotel;

import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    public Hotel() {

        rooms = new ArrayList<>();
        reservations = new ArrayList<>();

        rooms.add(new Room(101, "Standard", 3000));
        rooms.add(new Room(102, "Standard", 3000));
        rooms.add(new Room(201, "Deluxe", 5000));
        rooms.add(new Room(202, "Deluxe", 5000));
        rooms.add(new Room(301, "Suite", 8000));

    }
    public void showAvailableRooms() {

        System.out.println("\n===== Available Rooms =====");

        for (Room room : rooms) {

            if (room.isAvailable()) {

                System.out.println("Room Number: " + room.getRoomNumber());
                System.out.println("Room Type  : " + room.getRoomType());
                System.out.println("Price Per Day     : Rs. " + room.getPrice());
                System.out.println("---------------------------");

            }

        }

    }
    public void bookRoom(int roomNumber, String customerName, String bookingDate, int days){

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {

                room.setAvailable(false);

                Reservation reservation = new Reservation(customerName, room, bookingDate, days);
                reservations.add(reservation);
                FileManager.saveBooking(reservation);

                Payment payment = new Payment(reservation.getTotalAmount());
                payment.makePayment();

                System.out.println("\nRoom Booked Successfully!");
                System.out.println("Customer Name : " + customerName);
                System.out.println("Room Number   : " + room.getRoomNumber());
                System.out.println("Room Type     : " + room.getRoomType());
                System.out.println("Booking Date  : " + bookingDate);
                System.out.println("Days          : " + days);
                System.out.println("Total Bill    : Rs. " + reservation.getTotalAmount()+"\n Paid Cash no aviable online");

                return;
            }
        }

        System.out.println("Sorry! Room is not available.");
    }
    public void cancelReservation(int roomNumber) {

        for (Reservation reservation : reservations) {

            if (reservation.getRoom().getRoomNumber() == roomNumber) {

                reservation.getRoom().setAvailable(true);

                reservations.remove(reservation);

                System.out.println("Booking Cancelled Successfully!");

                return;
            }
        }

        System.out.println("Booking Not Found!");
    }
    public void viewReservations() {

        System.out.println("\n===== Booking Details =====");

        if (reservations.isEmpty()) {
            System.out.println("No Bookings Found.");
            return;
        }

        for (Reservation reservation : reservations) {

            System.out.println("Customer Name : " + reservation.getCustomerName());
            System.out.println("Room Number   : " + reservation.getRoom().getRoomNumber());
            System.out.println("Room Type     : " + reservation.getRoom().getRoomType());
            System.out.println("Booking Date  : " + reservation.getBookingDate());
            System.out.println("Days          : " + reservation.getNumberOfDays());
            System.out.println("Total Bill    : Rs. " + reservation.getTotalAmount());
            System.out.println("----------------------------");
            }
    }
}