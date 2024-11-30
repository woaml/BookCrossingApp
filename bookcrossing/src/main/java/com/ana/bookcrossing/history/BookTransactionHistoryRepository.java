package com.ana.bookcrossing.history;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
}
