package com.ntust.application.dao.repository;


import com.ntust.application.dao.entity.MemberDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<MemberDo, Long> {
    List<MemberDo> findAllByUserNameContainingOrUserEmailContaining(String name, String email);
}
