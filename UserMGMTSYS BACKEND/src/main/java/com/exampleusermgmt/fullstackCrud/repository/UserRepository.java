package com.exampleusermgmt.fullstackCrud.repository;

import com.exampleusermgmt.fullstackCrud.model.appUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<appUser, Long> {




}
