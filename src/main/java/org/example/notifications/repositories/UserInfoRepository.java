package org.example.notifications.repositories;

import org.example.notifications.repositories.entities.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, String> {
}


