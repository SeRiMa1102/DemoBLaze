package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Customer {
    String firstName;
    String lastName;
    String country;
    String city;
    String card;
    String month;
    String year;
}
