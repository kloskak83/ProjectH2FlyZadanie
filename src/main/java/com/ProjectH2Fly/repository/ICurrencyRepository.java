package com.ProjectH2Fly.repository;


import com.ProjectH2Fly.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICurrencyRepository extends JpaRepository<Currency,Integer> {
}
