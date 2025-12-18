package org.example.notifications.services;

import org.example.notifications.services.dtos.NotificationDto;
import org.springframework.http.ResponseEntity;

public interface NotificationChannel {
    ResponseEntity<String> send(NotificationDto request);

    boolean supports(NotificationDto request);
}
