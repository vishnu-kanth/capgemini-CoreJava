package PracticeQuestionsMentor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

class HotelBooking {

    public static void validateUserDetails(String name,int age, String email, String creditCard) throws Exception {
    	if (!name.matches("[A-Za-z ]+"))
    	    throw new Exception("Invalid name");

        if (age < 18 || age > 100)
            throw new Exception("Invalid age");

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            throw new Exception("Invalid email");

        if (!creditCard.matches("\\d{16}"))
            throw new Exception("Invalid credit card number");
    }

    public static void validateBookingDetails(String hotelName, String roomType,
                                              LocalDate checkInDate, LocalDate checkOutDate)
            throws Exception {

        List<String> hotels = Arrays.asList("Hilton", "Hyatt", "Marriott");

        if (!hotels.contains(hotelName))
            throw new Exception("Invalid hotel name");

        if (!(roomType.equals("Standard") || roomType.equals("Deluxe") || roomType.equals("Suite")))
            throw new Exception("Invalid room type");

        if (!checkInDate.isAfter(LocalDate.now()))
            throw new Exception("Invalid check-in date");

        if (!checkOutDate.isAfter(checkInDate))
            throw new Exception("Invalid check-out date");
    }

    public static double calculateBookingCost(String roomType, int nights) {

        double rate = 0;

        if (roomType.equals("Standard"))
            rate = 1000;
        else if (roomType.equals("Deluxe"))
            rate = 2000;
        else if (roomType.equals("Suite"))
            rate = 3000;

        return rate * nights;
    }
}

public class HotelApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter Name");
            String name = sc.nextLine().trim();

            System.out.println("Enter Age");
            int age = Integer.parseInt(sc.nextLine().trim());

            System.out.println("Enter Email");
            String email = sc.nextLine().trim();

            System.out.println("Enter Credit Card Number");
            String creditCard = sc.nextLine().trim();

            HotelBooking.validateUserDetails(name,age, email, creditCard);

            System.out.println("Enter Hotel Name");
            String hotelName = sc.nextLine().trim();

            System.out.println("Select Room Type");
            String roomType = sc.nextLine().trim();

            System.out.println("Enter Check-in Date (yyyy-MM-dd)");
            String inDate = sc.nextLine().trim();

            System.out.println("Enter Check-out Date (yyyy-MM-dd)");
            String outDate = sc.nextLine().trim();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            LocalDate checkInDate;
            LocalDate checkOutDate;

            try {
                checkInDate = LocalDate.parse(inDate, formatter);
                checkOutDate = LocalDate.parse(outDate, formatter);
            } catch (DateTimeParseException e) {
                throw new Exception("Invalid date format");
            }

            HotelBooking.validateBookingDetails(hotelName, roomType, checkInDate, checkOutDate);

            int nights = (int) (checkOutDate.toEpochDay() - checkInDate.toEpochDay());

            double totalCost = HotelBooking.calculateBookingCost(roomType, nights);

            System.out.printf("Total Booking Cost: $%.2f", totalCost);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
