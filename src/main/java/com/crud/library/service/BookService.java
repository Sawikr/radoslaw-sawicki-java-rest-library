package com.crud.library.service;

import com.crud.library.controller.LibraryNotFoundException;
import com.crud.library.domain.Book;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.BookTitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookTitleRepository bookTitleRepository;

    public List<Book> getAllTasks() {
        return bookRepository.findAll();
    }

    public Book getTask(final Long taskId) throws LibraryNotFoundException {
        return bookRepository.findById(taskId).orElseThrow(LibraryNotFoundException::new);
    }

    public Book saveTask(final Book task) {
        return bookRepository.save(task);
    }

    public void deleteTask(final Long id) {
        bookRepository.deleteById(id);
    }

    public Book saveNewStatus(final Long id, final String status) {
        Book task = bookRepository.findBookById(id);
        task.setStatus(status);
        return bookRepository.save(task);
    }
}
