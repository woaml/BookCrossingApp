package com.ana.bookcrossing.feedback;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    @Query("""
           select f from Feedback f
           where f.book.id = :bookId
           """)
    Page<Feedback> findAllByBookId(Long bookId, Pageable pageable);
}