package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class OrderModel {
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String rentPeriod;
    private final String scooterColour;
    private final String commentToCourier;
}
