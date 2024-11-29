package com.ana.bookcrossing.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowerBookResponse {
    private Long id;
    private String title;
    private String authorName;
    private String isbn;
    private double rate;
    private boolean returned;
    private boolean returnApproved;
}