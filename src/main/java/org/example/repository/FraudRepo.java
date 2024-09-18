package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface
FraudRepo extends JpaRepository<FraudEntity, Integer> {
    FraudEntity findByNumber(Long number);
    int countAllByNumber(Long number);
}
