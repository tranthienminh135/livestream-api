package com.phuong.livestreamapi.repository;

import com.phuong.livestreamapi.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {

    @Query(value = " select au.* from app_user au where au.username = :username ", nativeQuery = true)
    AppUser getAppUserByUsername(@Param("username") String username);

}
