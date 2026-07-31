package hotel;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();
        int choice;

        do {

            System.out.println("\n===== Baqir Hotel Management System =====");
            System.out.println("1. Show Available Rooms");
            System.out.println("2. Booking Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booking");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {

                case 1:
                    hotel.showAvailableRooms();
                    break;

                case 2:
                    System.out.print("Enter Room Number: ");
                    int roomNumber = sc.nextInt();
                    sc.nextLine();


                    System.out.print("Enter Customer Name: ");
                    String customerName = sc.nextLine();

                    System.out.print("Enter Booking Date (DD/MM/YYYY): ");
                    String bookingDate = sc.nextLine();

                    System.out.print("Enter Number of Days: ");
                    int days = sc.nextInt();

                    hotel.bookRoom(roomNumber, customerName, bookingDate, days);
                    break;

                case 3:
                    System.out.print("Enter Room Number to Cancel: ");
                    int cancelRoom = sc.nextInt();

                    hotel.cancelReservation(cancelRoom);
                    break;

                case 4:
                    hotel.viewReservations();
                    break;

                case 5:
                    System.out.println("Thank You for Using Baqar Hotel System!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

    }
}