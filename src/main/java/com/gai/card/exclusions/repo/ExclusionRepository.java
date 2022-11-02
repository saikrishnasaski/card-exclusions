package com.gai.card.exclusions.repo;

import com.gai.card.exclusions.entity.ExclusionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExclusionRepository extends JpaRepository<ExclusionEntity, Integer> {

    List<ExclusionEntity> findByCardEntityCardNumber(String cardNumber);



    
}
