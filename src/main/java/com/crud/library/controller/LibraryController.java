package com.crud.library.controller;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookTitle;
import com.crud.library.domain.Reader;
import com.crud.library.domain.Rental;
import com.crud.library.dto.BookDto;
import com.crud.library.dto.BookTitleDto;
import com.crud.library.dto.ReaderDto;
import com.crud.library.dto.RentalDto;
import com.crud.library.mapper.BookMapper;
import com.crud.library.mapper.BookTitleMapper;
import com.crud.library.mapper.ReaderMapper;
import com.crud.library.mapper.RentalMapper;
import com.crud.library.service.BookService;
import com.crud.library.service.BookTitleService;
import com.crud.library.service.ReaderService;
import com.crud.library.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/libraries")
public class LibraryController {

    private final ReaderService readerService;
    private final BookService bookService;
    private final BookTitleService bookTitleService;
    private final RentalService rentalService;

    private final ReaderMapper readerMapper;
    private final BookMapper bookMapper;
    private final BookTitleMapper bookTitleMapper;
    private final RentalMapper rentalMapper;

    private BookTitle bookTitle;

    //Get
    @GetMapping("/readers")
    public ResponseEntity<List<ReaderDto>> getTasksReader() {
        List<Reader> tasks = readerService.getAllTasks();
        return ResponseEntity.ok(readerMapper.mapToReaderDtoList(tasks));
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getTasksBook() {
        List<Book> tasks = bookService.getAllTasks();
        return ResponseEntity.ok(bookMapper.mapToBookDtoList(tasks));
    }

    @GetMapping("/titles")
    public ResponseEntity<List<BookTitleDto>> getTasksBookTitle() {
        List<BookTitle> tasks = bookTitleService.getAllTasks();
        return ResponseEntity.ok(bookTitleMapper.mapToBookTitleDtoList(tasks));
    }

    @GetMapping(value = "{taskId}")
    public ResponseEntity<BookDto> getTask(@PathVariable Long taskId) throws LibraryNotFoundException {
        return ResponseEntity.ok(bookMapper.mapToBookDto(bookService.getTask(taskId)));
    }

    @RequestMapping(
            value = "/titles",
            params = {"bookTitle"},
            method = GET)
    @ResponseBody
    public List<BookTitleDto> getBookTitles(@RequestParam("bookTitle") String bookTitle) {
        return bookTitleMapper.mapToBookTitleDtoList(bookTitleService.getBookTitles(bookTitle));
    }

    //Post
    @PostMapping(value = "/readers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTaskReader(@RequestBody ReaderDto taskDtoReader) {
        Reader task = readerMapper.mapToReader(taskDtoReader);
        readerService.saveTask(task);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/titles", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTaskBookTitle(@RequestBody BookTitleDto taskDtoBookTitle) {
        BookTitle task = bookTitleMapper.mapToBookTitle(taskDtoBookTitle);
        bookTitleService.saveTask(task);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/books", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTaskBook(@RequestBody BookDto taskDtoBook) {
        Book task = bookMapper.mapToBook(taskDtoBook);
        bookService.saveTask(task);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/rentals", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTaskBookRental(@RequestBody RentalDto taskDtoBook) {
        Rental task = rentalMapper.mapToRental(taskDtoBook);
        rentalService.saveTask(task);
        return ResponseEntity.ok().build();
    }

    //Put
    @PutMapping(value = "/books")
    public ResponseEntity<BookDto> updateTask(@RequestBody BookDto taskDto) {
        Book task = bookMapper.mapToBook(taskDto);
        Book savedTask = bookService.saveTask(task);
        return ResponseEntity.ok(bookMapper.mapToBookDto(savedTask));
    }

    @PostMapping(value = "/changesOne",
            params = {"bookTitle", "author", "publicationDate"})
    public ResponseEntity<BookDto> updateTaskChange(@RequestBody BookDto taskDto,
            @RequestParam("bookTitle") String bookTitleName,
            @RequestParam("author") String author,
            @RequestParam("publicationDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date publicationDate) {
        Book task = bookMapper.mapToBook(taskDto);
        BookTitle bookTitleNew = new BookTitle(bookTitleName, author, publicationDate);
        task.setBookTitle(bookTitleNew);
        Book savedTask = bookService.saveTask(task);
        return ResponseEntity.ok(bookMapper.mapToBookDto(savedTask));
    }

    @RequestMapping(value = "/changesTwo",
            params = {"bookTitle", "author", "publicationDate"},
            method = PUT)
    @ResponseBody
    public BookDto updateTaskChangeRequestMapping(
            @RequestBody BookDto taskDto,
            @RequestParam("bookTitle") String bookTitleName,
            @RequestParam("author") String author,
            @RequestParam("publicationDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date publicationDate) {
        Book task = bookMapper.mapToBook(taskDto);
        BookTitle bookTitleNew = new BookTitle(bookTitleName, author, publicationDate);
        task.setBookTitle(bookTitleNew);
        Book savedTask = bookService.saveTask(task);
        return bookMapper.mapToBookDto(savedTask);
    }

    @RequestMapping(
            value = "/books",
            params = {"id", "status"},
            method = PUT)
    @ResponseBody
    public BookDto updateBookStatus(@RequestParam("id") long id, @RequestParam("status") String status) {
        return bookMapper.mapToBookDto(bookService.saveNewStatus(id, status));
    }
}