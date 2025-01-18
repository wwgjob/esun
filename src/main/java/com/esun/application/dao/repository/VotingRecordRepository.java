package com.esun.application.dao.repository;


import com.esun.application.dao.entity.VotingRecordDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotingRecordRepository extends JpaRepository<VotingRecordDo, Long> {
}
