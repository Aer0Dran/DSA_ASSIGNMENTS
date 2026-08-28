import java.util.Scanner;

public class MovieTheaterBooking {

    static Scanner sc = new Scanner(System.in);

    // seats[hall][row][seat]
    // true  = booked
    // false = available
    static boolean[][][] seats = new boolean[3][5][8];

    static final int TICKET_PRICE = 250;

    public static void main(String[] args) {

        int choice;

        while (true) {

            System.out.println("\n========== MOVIE THEATER BOOKING SYSTEM ==========");
            System.out.println("1. View Available Seats");
            System.out.println("2. Book Tickets");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Hall Summary");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            if (choice == 1) {
                viewAvailableSeats();

            } else if (choice == 2) {
                bookTickets();

            } else if (choice == 3) {
                cancelBooking();

            } else if (choice == 4) {
                hallSummary();

            } else if (choice == 5) {
                finalSummary();
                System.out.println("\nThank you for using the Movie Theater Booking System!");
                break;

            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
    }

    // -------------------------------------------------
    // 1. VIEW AVAILABLE SEATS
    // -------------------------------------------------

    static void viewAvailableSeats() {

        System.out.print("\nEnter hall number (1-3): ");
        int hall = sc.nextInt();

        if (hall < 1 || hall > 3) {
            System.out.println("Invalid hall number!");
            return;
        }

        int h = hall - 1;

        System.out.println("\nHall " + hall + " Seating Layout");
        System.out.println("    1 2 3 4 5 6 7 8");
        System.out.println("   -----------------");

        // Nested loops
        for (int row = 0; row < 5; row++) {

            char rowName = (char) ('A' + row);

            System.out.print(rowName + " | ");

            for (int seat = 0; seat < 8; seat++) {

                if (seats[h][row][seat]) {
                    System.out.print("B ");
                } else {
                    System.out.print("A ");
                }
            }

            System.out.println();
        }

        System.out.println("\nA = Available");
        System.out.println("B = Booked");
    }

    // -------------------------------------------------
    // 2. BOOK TICKETS
    // -------------------------------------------------

    static void bookTickets() {

        System.out.print("\nEnter hall number (1-3): ");
        int hall = sc.nextInt();

        if (hall < 1 || hall > 3) {
            System.out.println("Invalid hall number!");
            return;
        }

        int h = hall - 1;

        while (true) {

            System.out.print("\nEnter row (A-E) or DONE to stop booking: ");
            String rowInput = sc.next();

            // Stop booking
            if (rowInput.equalsIgnoreCase("DONE")) {
                System.out.println("Booking session ended.");
                break;
            }

            // Check valid row
            if (rowInput.length() != 1) {
                System.out.println("Invalid row! Enter A, B, C, D or E.");
                continue;
            }

            char rowChar = Character.toUpperCase(rowInput.charAt(0));

            if (rowChar < 'A' || rowChar > 'E') {
                System.out.println("Invalid row! Enter A, B, C, D or E.");
                continue;
            }

            int row = rowChar - 'A';

            System.out.print("Enter seat number (1-8): ");
            int seat = sc.nextInt();

            if (seat < 1 || seat > 8) {
                System.out.println("Invalid seat number!");
                continue;
            }

            int seatIndex = seat - 1;

            // Check whether seat is already booked
            if (seats[h][row][seatIndex]) {

                System.out.println("Seat already booked!");
                continue;

            } else {

                seats[h][row][seatIndex] = true;

                System.out.println("Seat " + rowChar + seat +
                                   " booked successfully!");
                System.out.println("Ticket Price: Rs." + TICKET_PRICE);
            }
        }
    }

    // -------------------------------------------------
    // 3. CANCEL BOOKING
    // -------------------------------------------------

    static void cancelBooking() {

        System.out.print("\nEnter hall number (1-3): ");
        int hall = sc.nextInt();

        if (hall < 1 || hall > 3) {
            System.out.println("Invalid hall number!");
            return;
        }

        System.out.print("Enter row (A-E): ");
        String rowInput = sc.next();

        if (rowInput.length() != 1) {
            System.out.println("Invalid row!");
            return;
        }

        char rowChar = Character.toUpperCase(rowInput.charAt(0));

        if (rowChar < 'A' || rowChar > 'E') {
            System.out.println("Invalid row!");
            return;
        }

        int row = rowChar - 'A';

        System.out.print("Enter seat number (1-8): ");
        int seat = sc.nextInt();

        if (seat < 1 || seat > 8) {
            System.out.println("Invalid seat number!");
            return;
        }

        int h = hall - 1;
        int seatIndex = seat - 1;

        if (seats[h][row][seatIndex]) {

            seats[h][row][seatIndex] = false;

            System.out.println("Booking cancelled successfully.");
            System.out.println("Seat " + rowChar + seat +
                               " is now available.");

        } else {

            System.out.println("Seat was not booked.");
        }
    }

    // -------------------------------------------------
    // 4. HALL SUMMARY
    // -------------------------------------------------

    static void hallSummary() {

        System.out.print("\nEnter hall number (1-3): ");
        int hall = sc.nextInt();

        if (hall < 1 || hall > 3) {
            System.out.println("Invalid hall number!");
            return;
        }

        int h = hall - 1;

        int totalSeats = 0;
        int bookedSeats = 0;

        // Nested loops to count booked seats
        for (int row = 0; row < 5; row++) {

            for (int seat = 0; seat < 8; seat++) {

                totalSeats++;

                if (seats[h][row][seat]) {
                    bookedSeats++;
                }
            }
        }

        int availableSeats = totalSeats - bookedSeats;

        double bookingPercentage =
                ((double) bookedSeats / totalSeats) * 100;

        System.out.println("\n========== HALL " + hall + " SUMMARY ==========");
        System.out.println("Total Seats      : " + totalSeats);
        System.out.println("Booked Seats     : " + bookedSeats);
        System.out.println("Available Seats  : " + availableSeats);
        System.out.printf("Booking Percentage: %.2f%%\n",
                          bookingPercentage);
    }

    // -------------------------------------------------
    // 5. FINAL SUMMARY
    // -------------------------------------------------

    static void finalSummary() {

        int totalBooked = 0;

        System.out.println("\n========== FINAL SUMMARY ==========");

        for (int h = 0; h < 3; h++) {

            int bookedSeats = 0;

            // Count booked seats in each hall
            for (int row = 0; row < 5; row++) {

                for (int seat = 0; seat < 8; seat++) {

                    if (seats[h][row][seat]) {
                        bookedSeats++;
                    }
                }
            }

            int totalSeats = 5 * 8;
            int availableSeats = totalSeats - bookedSeats;

            double percentage =
                    ((double) bookedSeats / totalSeats) * 100;

            totalBooked += bookedSeats;

            System.out.println("\nHall " + (h + 1));
            System.out.println("Total Seats     : " + totalSeats);
            System.out.println("Booked Seats    : " + bookedSeats);
            System.out.println("Available Seats : " + availableSeats);
            System.out.printf("Booking %%       : %.2f%%\n",
                              percentage);
        }

        int totalRevenue = totalBooked * TICKET_PRICE;

        System.out.println("\n-----------------------------------");
        System.out.println("Total Tickets Sold : " + totalBooked);
        System.out.println("Ticket Price       : Rs." + TICKET_PRICE);
        System.out.println("Total Revenue      : Rs." + totalRevenue);
        System.out.println("-----------------------------------");
    }
}