package com.gai.card.exclusions.service;

import com.gai.card.exclusions.entity.CardEntity;
import com.gai.card.exclusions.entity.ExclusionEntity;
import com.gai.card.exclusions.model.CreateExclusion;
import com.gai.card.exclusions.repo.CardRepository;
import com.gai.card.exclusions.repo.ExclusionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExclusionService {

    private final ExclusionRepository exclusionRepository;
    private final CardRepository cardRepository;

    @Transactional
    public Integer saveExclusion(CreateExclusion request) {
        ExclusionEntity exclusionEntity = populateExclusionEntity(request);
        CardEntity cardEntity = populateCardEntity(request);
        exclusionEntity.setCardEntity(cardEntity);
        cardEntity = cardRepository.saveAndFlush(cardEntity);
        exclusionEntity.setCardId(cardEntity.getCardId());
        exclusionEntity = exclusionRepository.saveAndFlush(exclusionEntity);
        return exclusionEntity.getExclusionId();
    }

    private CardEntity populateCardEntity(CreateExclusion request) {
        CardEntity cardEntity = new CardEntity();
        cardEntity.setCardNumber(request.getCardNumber());
        cardEntity.setIssuerId(request.getIssuerId());
        cardEntity.setUpdatedBy(request.getUserId());
        cardEntity.setUpdatedTime(LocalDateTime.now());
        return cardEntity;
    }

    private ExclusionEntity populateExclusionEntity(CreateExclusion request) {
        ExclusionEntity exclusionEntity = new ExclusionEntity();
        exclusionEntity.setStartDate(request.getExclusion().getStartDate());
        exclusionEntity.setEndDate(request.getExclusion().getEndDate());
        exclusionEntity.setMerchantCategory(request.getExclusion().getMerchantCategoryCode().toString());
        exclusionEntity.setMerchantCountry(request.getExclusion().getCountry().toString());
        exclusionEntity.setState(request.getExclusion().getState());
        exclusionEntity.setInfo(request.getExclusion().getInfo());
        return exclusionEntity;
    }


    public List<ExclusionEntity> getExlusions(String cardNumber) {

        List<ExclusionEntity> exclusions = exclusionRepository.findByCardEntityCardNumber(cardNumber);

        exclusions.forEach((exlusion) -> {
            System.out.println(exlusion.getExclusionId());
        });
        return null;
    }

}
