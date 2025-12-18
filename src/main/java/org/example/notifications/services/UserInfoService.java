package org.example.notifications.services;

import org.example.notifications.services.dtos.UserInfoDto;
import org.example.notifications.repositories.entities.UserInfoEntity;
import org.example.notifications.repositories.mappers.UserInfoEntityMapper;
import org.example.notifications.repositories.UserInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService {

	private final UserInfoRepository userInfoRepository;
	private final UserInfoEntityMapper entityMapper;

	public UserInfoService(UserInfoRepository userInfoRepository, UserInfoEntityMapper entityMapper) {
		this.userInfoRepository = userInfoRepository;
		this.entityMapper = entityMapper;
	}

	public List<UserInfoDto> listAll() {
		return userInfoRepository.findAll().stream()
				.map(entityMapper::toDto)
				.toList();
	}

	public Optional<UserInfoDto> getById(String userId) {
		return userInfoRepository.findById(userId).map(entityMapper::toDto);
	}

	public UserInfoDto create(UserInfoDto dto) {
		UserInfoEntity entity = entityMapper.toEntity(dto);
		UserInfoEntity saved = userInfoRepository.save(entity);
		return entityMapper.toDto(saved);
	}

	public Optional<UserInfoDto> update(String userId, UserInfoDto dto) {
		return userInfoRepository.findById(userId)
				.map(existing -> {
					UserInfoEntity updated = entityMapper.toEntity(dto);
					updated.setUserId(userId);
					return userInfoRepository.save(updated);
				})
				.map(entityMapper::toDto);
	}

	public void delete(String userId) {
		userInfoRepository.deleteById(userId);
	}
}


