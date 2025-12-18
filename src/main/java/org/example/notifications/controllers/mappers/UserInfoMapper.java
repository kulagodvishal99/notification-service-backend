package org.example.notifications.controllers.mappers;

import org.example.notifications.controllers.dtos.UserInfo;
import org.example.notifications.services.dtos.UserInfoDto;
import org.example.notifications.repositories.entities.UserInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserInfoMapper {

	@Mapping(target = "userId", source = "user_id")
	@Mapping(target = "phoneNumber", source = "phone_number")
	@Mapping(target = "emailId", source = "email_id")
	@Mapping(target = "street", source = "address.street")
	@Mapping(target = "city", source = "address.city")
	@Mapping(target = "state", source = "address.state")
	@Mapping(target = "country", source = "address.country")
	UserInfoDto toDto(UserInfo resource);

	UserInfoEntity toEntity(UserInfoDto dto);

	UserInfoDto toDto(UserInfoEntity entity);

}
