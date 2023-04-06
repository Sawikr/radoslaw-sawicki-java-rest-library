package com.crud.library.service;

import com.crud.library.controller.LibraryNotFoundException;
import com.crud.library.domain.Book;
import com.crud.library.domain.BookTitle;
import com.crud.library.repository.BookTitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookTitleService {

    private final BookTitleRepository bookTitleRepository;

    public List<BookTitle> getAllTasks() {
        return bookTitleRepository.findAll();
    }

    public BookTitle getTask(final Long taskId) throws LibraryNotFoundException {
        return bookTitleRepository.findById(taskId).orElseThrow(LibraryNotFoundException::new);
    }

    public BookTitle saveTask(final BookTitle task) {
        return bookTitleRepository.save(task);
    }

    public void deleteTask(final Long id) {
        bookTitleRepository.deleteById(id);
    }

    public List<BookTitle> getBookTitles(final String bookTitle) {
        return bookTitleRepository.findByBookTitle(bookTitle);
    }

}
