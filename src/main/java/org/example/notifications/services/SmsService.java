package org.example.notifications.services;

import org.example.notifications.services.dtos.NotificationDto;
import org.example.notifications.services.dtos.SmsDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class SmsService implements NotificationChannel {

	private final RestTemplate restTemplate = new RestTemplate();

	@Value("${twilio.account-sid:}")
	private String accountSid;

	@Value("${twilio.auth-token:}")
	private String authToken;

	@Value("${twilio.from-number:}")
	private String fromNumber;

	@Value("${twilio.api-base:https://api.twilio.com/2010-04-01}")
	private String apiBase;

	@Override
	public ResponseEntity<String> send(NotificationDto request) {
		if (!(request instanceof SmsDto smsNotification)) {
			throw new IllegalArgumentException("Invalid request type for SMS channel");
		}

		if (accountSid == null || accountSid.isBlank() || authToken == null || authToken.isBlank() || fromNumber == null
				|| fromNumber.isBlank()) {
			return ResponseEntity.badRequest().body(
					"Twilio credentials not configured. Set twilio.accountSid, twilio.authToken, twilio.fromNumber.");
		}

		String url = apiBase + "/Accounts/" + accountSid + "/Messages.json";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		String basicAuth = Base64.getEncoder()
				.encodeToString((accountSid + ":" + authToken).getBytes(StandardCharsets.UTF_8));
		headers.set("Authorization", "Basic " + basicAuth);

		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("To", smsNotification.getPhoneNumber());
		body.add("From", fromNumber);
		body.add("Body", smsNotification.getMessage());

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		return restTemplate.postForEntity(url, entity, String.class);
	}

	@Override
	public boolean supports(NotificationDto request) {
		return request.getType() == NotificationType.SMS;
	}
}
