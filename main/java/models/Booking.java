package models;


import helper.DataGenerator;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter

public class Booking {
    public static Booking bookingInfo;

    private Object firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private String additionalneeds;
    private HashMap<String, String> bookingdates;

    private Booking(){
        this.firstname = DataGenerator.generateFirstName();
        this.lastname = DataGenerator.generateLastName();
        this.totalprice = DataGenerator.generateTotalPrice();
        this.depositpaid = DataGenerator.generateDepositPaid();
        this.bookingdates = new HashMap<>();
        bookingdates.put("checkin", DataGenerator.generateCheckIn());
        bookingdates.put("checkout", DataGenerator.generateCheckOut());
        this.additionalneeds = DataGenerator.generateAdditionalNeeds();
    }
    public static Booking getInstance(){
        return new Booking();
    }
}
