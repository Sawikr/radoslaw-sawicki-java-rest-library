package com.crud.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class RentalDto {

    private Long id;
    private Long reader_id;
    private LocalDate rentalDate;
    private LocalDate returnDate;
}
