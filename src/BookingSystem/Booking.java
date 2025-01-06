package BookingSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Booking {
    private Room room;
    private User user;
    private LocalDateTime start;
    private LocalDateTime end;

    public Booking(Room room, User user, LocalDateTime start, LocalDateTime end) {
        this.room = room;
        this.user = user;
        this.start = start;
        this.end = end;
    }
    public Room getRoom() {
        return room;
    }
    public User getUser() {
        return user;
    }
    public LocalDateTime getStart() {
        return start;
    }
    public LocalDateTime getEnd() {
        return end;
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Booking: " + room.getRoomName() + " | User: " + user.getName() + " | Start: " + start.format(formatter) + " | End: " + end.format(formatter);
    }
}
