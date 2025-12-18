package org.example.notifications.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private String user_id;
    private String firstName;
    private String lastName;
    private String phone_number;
    private String email_id;
    private Address address;
    private String countryCode;
}
