package com.crud.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BookTitleDto {

    private Long id;
    private String bookTitle;
    private String author;
    private LocalDate publicationDate;
}
