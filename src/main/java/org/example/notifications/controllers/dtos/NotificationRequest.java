package org.example.notifications.controllers.dtos;

import org.example.notifications.services.NotificationType;

public interface NotificationRequest {
    NotificationType getType();
}
