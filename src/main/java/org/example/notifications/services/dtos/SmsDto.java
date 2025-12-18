package org.example.notifications.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.notifications.services.NotificationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmsDto implements NotificationDto {

    private String phoneNumber;
    private String message;

    @Override
    public NotificationType getType() {
        return NotificationType.SMS;
    }
}
