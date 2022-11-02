package com.gai.card.exclusions.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateExclusion {

    private String issuerId;
    private String cardNumber;
    private String userId;
    private Exclusion exclusion;

    @Getter
    @Setter
    public static class Exclusion {

        private LocalDate startDate;
        private LocalDate endDate;
        private Integer country;
        private  String state;
        private Integer merchantCategoryCode;
        private String subDivision;
        private String notes;
        private String info ;

    }

}