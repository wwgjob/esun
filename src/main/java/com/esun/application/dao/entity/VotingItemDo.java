package com.esun.application.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "voting_item")
public class VotingItemDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "project")
    private String project;
}
