package com.esun.application.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "voting_record")
public class VotingRecordDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "voting_item_id")
    private Long votingItemId;
}
