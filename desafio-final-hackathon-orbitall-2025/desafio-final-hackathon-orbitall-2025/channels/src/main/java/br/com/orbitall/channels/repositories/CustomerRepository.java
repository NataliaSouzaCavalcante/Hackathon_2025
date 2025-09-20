package br.com.orbitall.channels.repositories;

import br.com.orbitall.channels.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
