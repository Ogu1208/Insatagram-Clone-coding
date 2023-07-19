package com.ogu.instagram.user.repository;

import com.ogu.instagram.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
