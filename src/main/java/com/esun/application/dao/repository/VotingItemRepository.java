package com.esun.application.dao.repository;


import com.esun.application.dao.entity.VotingItemDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotingItemRepository extends JpaRepository<VotingItemDo, Long> {
}
