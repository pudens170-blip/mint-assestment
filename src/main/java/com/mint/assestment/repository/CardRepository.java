package com.mint.assestment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mint.assestment.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{

}
