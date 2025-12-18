package org.example.notifications.controllers;

import org.example.notifications.controllers.dtos.UserInfo;
import org.example.notifications.services.dtos.UserInfoDto;
import org.example.notifications.controllers.mappers.UserInfoMapper;
import org.example.notifications.services.UserInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notifications/user-info")
public class UserInfoController {

	private final UserInfoService userInfoService;
	private final UserInfoMapper userInfoMapper;

	public UserInfoController(UserInfoService userInfoService, UserInfoMapper userInfoMapper) {
		this.userInfoService = userInfoService;
		this.userInfoMapper = userInfoMapper;
	}

	@GetMapping
	public List<UserInfoDto> list() {
		return userInfoService.listAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserInfoDto> get(@PathVariable("id") String id) {
		Optional<UserInfoDto> dto = userInfoService.getById(id);
		return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<UserInfoDto> create(@RequestBody UserInfo resource) {
		UserInfoDto dto = userInfoMapper.toDto(resource);
		UserInfoDto saved = userInfoService.create(dto);
		return ResponseEntity.created(URI.create("/notifications/user-info/" + saved.getUserId())).body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserInfoDto> update(@PathVariable("id") String id, @RequestBody UserInfo resource) {
		UserInfoDto dto = userInfoMapper.toDto(resource);
		Optional<UserInfoDto> updated = userInfoService.update(id, dto);
		return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id) {
		userInfoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
