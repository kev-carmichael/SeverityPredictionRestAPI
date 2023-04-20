package com.kev.RestAPI.admin;

import com.kev.RestAPI.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByEmail(String email);


}
