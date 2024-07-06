package me.dio.santander_dev_week_2024.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.santander_dev_week_2024.domain.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    
    boolean existsByAccountNumber(String number);

    boolean existsByCardNumber(String number);
}
