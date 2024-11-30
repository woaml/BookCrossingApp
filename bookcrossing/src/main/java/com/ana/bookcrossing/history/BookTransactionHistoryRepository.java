package com.ana.bookcrossing.history;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookTransactionHistoryRepository extends JpaRepository<BookTransactionHistory, Long> {
    @Query("""
           select history from BookTransactionHistory history
           where history.user.id = :userId
           """)
    Page<BookTransactionHistory> findAllBorrowedBooks(Pageable pageable, Long userId);

    @Query("""
           select history from BookTransactionHistory history
           where history.book.owner.id = :userId
           """)
    Page<BookTransactionHistory> findAllReturnedBooks(Pageable pageable, Long userId);

    @Query("""
           select
           (count(*) > 0) as isBorrowed
           from BookTransactionHistory history
           where history.user.id = :userId
           and history.book.id = :bookId
           and history.returnApproved = false
           """)
    boolean isAlreadyBorrowedByUser(Long bookId, Long userId);

    @Query("""
           select history from BookTransactionHistory history
           where history.user.id = :userId
           and history.book.id = :bookId
           and history.returned = false
           and history.returnApproved = false
           """)
    Optional<BookTransactionHistory> findByBookIdAndUserId(Long bookId, Long userId);

    @Query("""
          select history from BookTransactionHistory history
          where history.book.owner.id = :userId
          and history.book.id = :bookId
          and history.returned = true
          and history.returnApproved = false
          """)
    Optional<BookTransactionHistory> findByBookIdAndOwnerId(Long bookId, Long userId);
}