package br.com.tqi.challenge.repository;

import br.com.tqi.challenge.entities.Client;
import br.com.tqi.challenge.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


}
