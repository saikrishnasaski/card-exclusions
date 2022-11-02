package com.gai.card.exclusions.repo;

import com.gai.card.exclusions.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardEntity, Integer> {

    CardEntity findByCardNumber(String cardNumber);
}
