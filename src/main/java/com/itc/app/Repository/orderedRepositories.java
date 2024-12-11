package com.itc.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itc.app.productEntity.orderedEntity;

public interface orderedRepositories extends JpaRepository<orderedEntity, Long> {
	List<orderedEntity> findAllByUserId(long userId);
	List<orderedEntity> findAllByOrderedTime(String orderedTime); // Match exactly with the entity field name
	void deleteByOrderedTime(String orderedTime); // Match exactly with the entity field name
}
