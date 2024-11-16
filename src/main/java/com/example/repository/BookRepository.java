package com.example.repository;

import com.example.model.Book;
import jakarta.persistence.LockModeType;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

/**
 * Repository interface for accessing and managing Book entities in the database.
 * This interface extends JpaRepository to provide basic CRUD operations.
 */
public interface BookRepository extends JpaRepository<Book, String> {

    @Lock(LockModeType.PESSIMISTIC_WRITE) //Prevents other transactions from reading or writing the locked data until the current transaction is complete.
    @NonNull // Added to suppress warning
    Optional<Book> findById(@NonNull String id);

}
