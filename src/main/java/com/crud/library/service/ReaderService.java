package com.crud.library.service;

import com.crud.library.controller.LibraryNotFoundException;
import com.crud.library.domain.Reader;
import com.crud.library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    public List<Reader> getAllTasks() {
        return readerRepository.findAll();
    }

    public Reader getTask(final Long taskId) throws LibraryNotFoundException {
        return readerRepository.findById(taskId).orElseThrow(LibraryNotFoundException::new);
    }

    public Reader saveTask(final Reader task) {
        return readerRepository.save(task);
    }

    public void deleteTask(final Long id) {
        readerRepository.deleteById(id);
    }
}
