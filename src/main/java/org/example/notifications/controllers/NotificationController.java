package org.example.notifications.controllers;

import org.example.notifications.controllers.dtos.SmsRequest;
import org.example.notifications.mappers.NotificationMapper;
import org.example.notifications.services.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;
    private final NotificationMapper notificationMapper;

    public NotificationController(NotificationService notificationService, NotificationMapper notificationMapper) {
        this.notificationService = notificationService;
        this.notificationMapper = notificationMapper;
    }

    @PostMapping("/sms/send")
    public ResponseEntity<String> sendSms(@RequestBody SmsRequest request) {
        var notificationModel = notificationMapper.toSmsNotification(request);
        return notificationService.send(notificationModel);
    }
}
