package BookingSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<Room> rooms = new ArrayList<Room>();
    private List<Booking> bookings = new ArrayList<Booking>();

    public BookingSystem(List<Room> rooms) {
        this.rooms = rooms;
    }

    public boolean isAvailable(Room room, LocalDateTime start, LocalDateTime end) {
        for (Booking booking : bookings) {
            if (booking.getRoom().equals(room)) {
                if (start.isBefore(booking.getEnd()) && end.isAfter(booking.getStart())) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Room> findAvailable(int capacity, LocalDateTime start, LocalDateTime end) {
        List<Room> availableRooms = new ArrayList<Room>();
        for (Room room : rooms) {
            if(room.getCapacity() >= capacity && isAvailable(room, start, end)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
    public Booking book(Room room, LocalDateTime start, LocalDateTime end, User user) {
        if (isAvailable(room, start, end)) {
            Booking booking = new Booking(room, user, start, end);
            bookings.add(booking);
            return booking;
        }
        return null;
    }

    public void cancel(Booking booking) {
        bookings.remove(booking);
    }

    public List<Booking> getBookings() {
        return bookings;
    }
    public List<Booking> getUserBookings(String email) {
        List<Booking> userBookings = new ArrayList<>();

        for (Booking booking : bookings) {
            if (booking.getUser().getEmail().equals(email)) {
                userBookings.add(booking);
            }
        }
        return userBookings;
    }
}
