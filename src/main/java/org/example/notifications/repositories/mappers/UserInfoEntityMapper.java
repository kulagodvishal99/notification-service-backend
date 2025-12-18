package org.example.notifications.repositories.mappers;

import org.example.notifications.repositories.entities.UserInfoEntity;
import org.example.notifications.services.dtos.UserInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserInfoEntityMapper {

	UserInfoEntity toEntity(UserInfoDto dto);

	UserInfoDto toDto(UserInfoEntity entity);
}





