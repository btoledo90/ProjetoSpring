package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.entities.Sentimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentimentoRepository extends JpaRepository<Sentimento, Long> {

}
