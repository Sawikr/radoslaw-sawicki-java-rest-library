package com.crud.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Date;

@Getter
@AllArgsConstructor
public class BookTitleDto {

    private Long id;
    private String bookTitle;
    private String author;
    private Date publicationDate;
}
