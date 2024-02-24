package com.ntust.application.dao.repository;


import com.ntust.application.dao.entity.MemberDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MemberDo, Long> {
}
