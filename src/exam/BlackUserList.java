package exam;

import java.time.LocalDateTime;

public class BlackUserList {
    private LocalDateTime booking;
    private String firstName;
    private String lastName;
    private String email;
    private long mobile;

    public BlackUserList(LocalDateTime booking, String firstName, String lastName, String email, long mobile) {
        this.booking = booking;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
    }

    public LocalDateTime getBooking() {
        return booking;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public long getMobile() {
        return mobile;
    }
}
