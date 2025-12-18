package org.example.notifications.mappers;

import org.example.notifications.controllers.dtos.SmsRequest;
import org.example.notifications.services.dtos.SmsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    SmsDto toSmsNotification(SmsRequest request);
}
