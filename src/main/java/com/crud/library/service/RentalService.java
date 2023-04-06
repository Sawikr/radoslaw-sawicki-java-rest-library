package com.crud.library.service;

import com.crud.library.controller.LibraryNotFoundException;
import com.crud.library.domain.Rental;
import com.crud.library.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;

    public List<Rental> getAllTasks() {
        return rentalRepository.findAll();
    }

    public Rental getTask(final Long taskId) throws LibraryNotFoundException {
        return rentalRepository.findById(taskId).orElseThrow(LibraryNotFoundException::new);
    }

    public Rental saveTask(final Rental task) {
        return rentalRepository.save(task);
    }

    public void deleteTask(final Long id) {
        rentalRepository.deleteById(id);
    }
}
