package org.example.notifications.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_info", schema = "notification_system")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoEntity {

	@Id
	@Column(name = "user_id", length = 64, nullable = false)
	private String userId;

	@Column(name = "first_name", length = 100, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 100)
	private String lastName;

	@Column(name = "phone_number", length = 32)
	private String phoneNumber;

	@Column(name = "email_id", length = 255)
	private String emailId;

	@Column(name = "street", length = 255)
	private String street;

	@Column(name = "city", length = 100)
	private String city;

	@Column(name = "state", length = 100)
	private String state;

	@Column(name = "country", length = 100)
	private String country;

	@Column(name = "country_code", length = 8)
	private String countryCode;
}





