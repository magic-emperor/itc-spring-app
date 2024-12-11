package com.itc.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itc.app.productEntity.productEntity;

public interface productRepositories extends JpaRepository<productEntity, Long>{

}
