package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.dto.BookDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookMapper {

    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle_id(),
                bookDto.getStatus()
        );
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle_id(),
                book.getStatus()
        );
    }

    public List<BookDto> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(this::mapToBookDto)
                .toList();
    }
}
