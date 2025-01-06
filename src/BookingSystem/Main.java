package BookingSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Room> rooms = new ArrayList<Room>();
        rooms.add(new Room("Room A", 5));
        rooms.add(new Room("Room B", 5));
        rooms.add(new Room("Room C", 10));

        BookingSystem bookingSystem = new BookingSystem(rooms);
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        boolean running = true;
        while(running) {
            System.out.println("\n=== Booking System Menu ===");
            System.out.println("1. Book Room");
            System.out.println("2. View Available Rooms");
            System.out.println("3. View Bookings");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    try {
                        System.out.println("Enter your name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter your email: ");
                        String email = scanner.nextLine();
                        User user = new User(name, email);

                        System.out.println("Enter start time (yyyy-MM-dd HH:mm): ");
                        String startTimeStr = scanner.nextLine();
                        System.out.println("Enter end time (yyyy-MM-dd HH:mm): ");
                        String endTimeStr = scanner.nextLine();

                        LocalDateTime startTime = LocalDateTime.parse(startTimeStr, formatter);
                        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, formatter);

                        System.out.println("Enter required capacity: ");
                        int capacity = scanner.nextInt();
                        scanner.nextLine();

                        List<Room> availableRooms = bookingSystem.findAvailable(capacity, startTime, endTime);

                        if (availableRooms.isEmpty()) {
                            System.out.println("No rooms available for the specified criteria.");
                            break;
                        }

                        System.out.println("Available rooms:");
                        for (int i = 0; i < availableRooms.size(); i++) {
                            System.out.println((i+1) + ". " + availableRooms.get(i).getRoomName() +
                                    " (Capacity: " + availableRooms.get(i).getCapacity() + ")");
                        }

                        System.out.println("Select room number: ");
                        int roomChoice = scanner.nextInt();
                        if (roomChoice < 1 || roomChoice > availableRooms.size()) {
                            System.out.println("Invalid room selection");
                            break;
                        }

                        Room selectedRoom = availableRooms.get(roomChoice - 1);
                        Booking booking = bookingSystem.book(selectedRoom, startTime, endTime, user);

                        if (booking != null) {
                            System.out.println("Booking confirmed:\n" + booking);
                        } else {
                            System.out.println("Booking failed");
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date/time format");
                    }
                    break;

                case 2:
                    System.out.println("Enter capacity required: ");
                    int reqCapacity = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        System.out.println("Enter start time (yyyy-MM-dd HH:mm): ");
                        LocalDateTime start = LocalDateTime.parse(scanner.nextLine(), formatter);
                        System.out.println("Enter end time (yyyy-MM-dd HH:mm): ");
                        LocalDateTime end = LocalDateTime.parse(scanner.nextLine(), formatter);

                        List<Room> available = bookingSystem.findAvailable(reqCapacity, start, end);
                        if (available.isEmpty()) {
                            System.out.println("No rooms available");
                        } else {
                            System.out.println("Available rooms:");
                            for (Room room : available) {
                                System.out.println(room.getRoomName() + " (Capacity: " + room.getCapacity() + ")");
                            }
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date/time format");
                    }
                    break;

                case 3:
                    System.out.println("Current bookings:");
                    List<Booking> bookings = bookingSystem.getBookings();

                    if (bookings.isEmpty()) {
                        System.out.println("No available bookings");
                    }else{
                    for (Booking b : bookings) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Enter your email: ");
                    String cancelEmail = scanner.nextLine();
                    List<Booking> userBookings = bookingSystem.getUserBookings(cancelEmail);

                    if (userBookings.isEmpty()) {
                        System.out.println("No bookings found for this email");
                        break;
                    }

                    for (int i = 0; i < userBookings.size(); i++) {
                        System.out.println((i + 1) + ". " + userBookings.get(i));
                    }

                    System.out.println("Enter booking number to cancel (0 to go back): ");
                    int bookingChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (bookingChoice == 0) break;

                    if (bookingChoice >= 1 && bookingChoice <= userBookings.size()) {
                        bookingSystem.cancel(userBookings.get(bookingChoice - 1));
                        System.out.println("Booking cancelled successfully");
                    } else {
                        System.out.println("Invalid booking number");
                    }
                    break;
                case 5:
                    System.out.println("Exiting system: ");
                    running = false;
                    break;
                    default:
                        System.out.println("Invalid choice");
                        break;
            }
        }
    }
}
