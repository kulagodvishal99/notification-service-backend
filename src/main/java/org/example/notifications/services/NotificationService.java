package org.example.notifications.services;

import org.example.notifications.services.dtos.NotificationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final List<NotificationChannel> channels;

    public NotificationService(List<NotificationChannel> channels) {
        this.channels = channels;
    }

    public ResponseEntity<String> send(NotificationDto request) {
        return channels.stream()
                .filter(channel -> channel.supports(request))
                .findFirst()
                .map(channel -> channel.send(request))
                .orElse(ResponseEntity.badRequest()
                        .body("No notification channel found for type: " + request.getType()));
    }
}
