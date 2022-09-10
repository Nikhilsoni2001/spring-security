package com.nikhil.springsecurityclient.repository;

import com.nikhil.springsecurityclient.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
}
