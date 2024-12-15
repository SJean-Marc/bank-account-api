package fr.kata.bankaccountapi.infrastructure.repository;

import fr.kata.bankaccountapi.infrastructure.entity.AccountStatementEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountStatementRepository extends
    ListCrudRepository<AccountStatementEntity, Long> {

    @Query("SELECT SUM(transactionAmount) FROM AccountStatementEntity")
    double sumTransactionAmount();
}
