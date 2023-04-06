package com.crud.library.mapper;

import com.crud.library.domain.BookTitle;
import com.crud.library.dto.BookTitleDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookTitleMapper {

    public BookTitle mapToBookTitle(final BookTitleDto bookTitleDto) {
        return new BookTitle(
                bookTitleDto.getId(),
                bookTitleDto.getBookTitle(),
                bookTitleDto.getAuthor(),
                bookTitleDto.getPublicationDate()
        );
    }

    public BookTitleDto mapToBookTitleDto(final BookTitle bookTitle) {
        return new BookTitleDto(
                bookTitle.getId(),
                bookTitle.getBookTitle(),
                bookTitle.getAuthor(),
                bookTitle.getPublicationDate()
        );
    }

    public List<BookTitleDto> mapToBookTitleDtoList(final List<BookTitle> bookTitleList) {
        return bookTitleList.stream()
                .map(this::mapToBookTitleDto)
                .toList();
    }
}
