package com.nutridiet.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nutridiet.project.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
    @Query("select a from Admin a where a.email=?1 and a.password=?2")
    public Admin checkadminlogin(String email, String pwd);
}
