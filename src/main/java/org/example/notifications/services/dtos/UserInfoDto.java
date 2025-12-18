package org.example.notifications.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {

	private String userId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailId;
	private String street;
	private String city;
	private String state;
	private String country;
	private String countryCode;
}





