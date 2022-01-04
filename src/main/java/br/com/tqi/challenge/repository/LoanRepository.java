package br.com.tqi.challenge.repository;

import br.com.tqi.challenge.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findLoadsByClientId (Long ClientId);
}
