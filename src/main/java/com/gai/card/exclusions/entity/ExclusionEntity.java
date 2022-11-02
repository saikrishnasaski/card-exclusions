package com.gai.card.exclusions.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "TDC_RTF_EXCPT_CARD")
public class ExclusionEntity {

    @Id
    @Column(name = "I_CARD_EXCPT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer exclusionId ;

    @Column(name= "I_CARD_ID")
    private Integer cardId;

    @Column(name = "C_STA")
    private Character status ;

    @Column(name = "I_MRCHNT_CNTRY")
    private String merchantCountry ;

    @Column(name = "D_STRT")
    private LocalDate startDate ;

    @Column(name = "D_END")
    private LocalDate endDate ;

    @Column(name = "X_UPDT")
    private String UpdatedBy ;

    @Column(name = "Z_UPDT")
    private LocalDateTime updatedTime ;

    @Column(name = "I_PARNT_ID")
    private Integer parentId ;

    @Column(name = "C_STE")
    private String state ;

    @Column(name = "C_MRCHNT_CAT")
    private String merchantCategory ;

    @Column(name = "T_INFO")
    private String info ;

    @Column(name = "C_CNTRY_SUBDIV_3")
    private String subDivision;

    @Column(name = "T_NOTES")
    private String notes ;

    @Column(name = "X_VIP")
    private Character vip ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "I_CARD_ID", insertable = false, updatable = false)
    private CardEntity cardEntity;


}
