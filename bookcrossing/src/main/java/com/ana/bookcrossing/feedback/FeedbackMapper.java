package com.ana.bookcrossing.feedback;

import com.ana.bookcrossing.book.Book;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FeedbackMapper {
    public Feedback toFeedback(FeedbackRequest request) {
        return Feedback.builder()
                .score(request.score())
                .comment(request.comment())
                .book(Book.builder()
                        .id(request.bookId())
                        .archived(false)
                        .shareable(false)
                        .build()
                )
                .build();
    }

    public FeedbackResponse toFeedbackResponse(Feedback f, Long id) {
        return FeedbackResponse.builder()
                .score(f.getScore())
                .comment(f.getComment())
                .ownFeedback(Objects.equals(f.getCreatedBy(), id))
                .build();
    }
}
