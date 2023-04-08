package com.crud.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RentalDto {

    private Long id;
    private LocalDate rentalDate;
    private LocalDate returnDate;

}
