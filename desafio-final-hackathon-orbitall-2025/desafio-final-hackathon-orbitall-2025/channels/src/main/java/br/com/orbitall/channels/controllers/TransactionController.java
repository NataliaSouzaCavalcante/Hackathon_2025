package br.com.orbitall.channels.controllers;

import br.com.orbitall.channels.repositories.CustomerRepository;
import br.com.orbitall.channels.repositories.TransactionRepository;
import br.com.orbitall.channels.models.Transaction;



import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    // CREATE
    @PostMapping
    public ResponseEntity<?> createTransaction(@Valid @RequestBody Transaction transaction) {

        if (!customerRepository.existsById(transaction.getCustomerId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente não encontrado com ID: " + transaction.getCustomerId());
        }

        transaction.setId(UUID.randomUUID());
        transaction.setCreatedAt(LocalDateTime.now());
        transaction.setActive(true);

        Transaction saved = repository.save(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // READ ALL
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable UUID id) {
        Optional<Transaction> transaction = repository.findById(id);
        return transaction.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable UUID id,
                                               @Valid @RequestBody Transaction updatedTransaction) {

        if (!customerRepository.existsById(updatedTransaction.getCustomerId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente não encontrado com ID: " + updatedTransaction.getCustomerId());
        }

        return repository.findById(id).map(existing -> {
            existing.setCustomerId(updatedTransaction.getCustomerId());
            existing.setAmount(updatedTransaction.getAmount());
            existing.setCardType(updatedTransaction.getCardType());
            existing.setActive(updatedTransaction.isActive());
            return ResponseEntity.ok(repository.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable UUID id) {
        return repository.findById(id).map(existing -> {
            repository.delete(existing);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
