package com.example.hotel.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.entitys.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
			UserEntity findByUsername(String username);
}
