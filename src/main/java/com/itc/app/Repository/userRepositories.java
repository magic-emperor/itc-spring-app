package com.itc.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itc.app.productEntity.userEntity;

public interface userRepositories extends JpaRepository<userEntity, Long>{
    Optional<userEntity> findByUserPhone(String userPhone);
}
