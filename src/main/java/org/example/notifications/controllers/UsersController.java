package org.example.notifications.controllers;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {

	private final JdbcTemplate jdbcTemplate;

	public UsersController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@GetMapping
	public List<Map<String, Object>> listUsers() {
		return jdbcTemplate.queryForList("SELECT * FROM users ORDER BY 1 LIMIT 100");
	}
}





