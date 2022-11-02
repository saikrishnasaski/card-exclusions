package com.gai.card.exclusions.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TDC_RTF_RULE_CARD")
public class CardEntity {

    @Id
    @Column(name = "I_CARD_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;

    @Column(name = "N_ACRO")
    private String issuerId;

    @Column(name = "I_CARD")
    private String cardNumber;

    @Column(name = "X_UPDT")
    private String UpdatedBy;

    @Column(name = "Z_UPDT")
    private LocalDateTime updatedTime;

}
