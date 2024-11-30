package com.ana.bookcrossing.book;

import com.ana.bookcrossing.file.FileUtils;
import com.ana.bookcrossing.history.BookTransactionHistory;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {
    public Book toBook(BookRequest request){
         return Book.builder()
                 .id(request.id())
                 .title(request.title())
                 .authorName(request.authorName())
                 .synopsis(request.synopsis())
                 .archived(request.archived())
                 .shareable(request.shareable())
                 .build();
    }

    public BookResponse toBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorName(book.getAuthorName())
                .synopsis(book.getSynopsis())
                .isbn(book.getIsbn())
                .shareable(book.isShareable())
                .rate(book.getRate())
                .archived(book.isArchived())
                .owner(book.getOwner().fullName())
                .cover(FileUtils.readFileFromLocation(book.getBookCover()))
                .build();
    }

    public BorrowerBookResponse toBorrowedBookResponse(BookTransactionHistory history) {
        return BorrowerBookResponse.builder()
                .id(history.getBook().getId())
                .title(history.getBook().getTitle())
                .authorName(history.getBook().getAuthorName())
                .isbn(history.getBook().getIsbn())
                .rate(history.getBook().getRate())
                .returned(history.isReturned())
                .returnApproved(history.isReturnApproved())
                .build();
    }
}
