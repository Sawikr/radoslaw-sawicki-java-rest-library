package com.crud.library.controller;

import com.crud.library.domain.Book;
import com.crud.library.domain.Reader;
import com.crud.library.domain.Rental;
import com.crud.library.dto.RentalDto;
import com.crud.library.mapper.RentalMapper;
import com.crud.library.service.BookService;
import com.crud.library.service.ReaderService;
import com.crud.library.service.RentalService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@Setter
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/libraries/v2/")
public class PutLibraryController {

    private final ReaderService readerService;
    private final BookService bookService;
    private final RentalService rentalService;
    private final RentalMapper rentalMapper;

    @PutMapping(value = "/changes",
            params = {"status", "idBook", "idReader"})
    public ResponseEntity<RentalDto> updateTaskRental(
            @RequestBody RentalDto taskDto,
            @RequestParam("status") String status,
            @RequestParam("idBook") Long idBook,
            @RequestParam("idReader") Long idReader) throws LibraryNotFoundException {
        Rental task = getRental(taskDto, status, idBook, idReader);
        Rental savedTask = rentalService.saveTask(task);
        return ResponseEntity.ok(rentalMapper.mapToRentalDto(savedTask));
    }

    protected Rental getRental(RentalDto taskDto, String status, Long idBook, Long idReader) throws LibraryNotFoundException {
        Rental task = rentalMapper.mapToRental(taskDto);
        task.setId(task.getId());
        Book book = bookService.getTask(idBook);
        book.setStatus(status);
        task.setBook(book);
        Reader reader = readerService.getTask(idReader);
        task.setReader(reader);
        return task;
    }
}
