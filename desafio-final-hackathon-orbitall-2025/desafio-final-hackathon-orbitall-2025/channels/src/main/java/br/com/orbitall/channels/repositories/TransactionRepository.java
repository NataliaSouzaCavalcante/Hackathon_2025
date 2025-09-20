package br.com.orbitall.channels.repositories;

import br.com.orbitall.channels.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
