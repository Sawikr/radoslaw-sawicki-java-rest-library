package com.crud.library.mapper;

import com.crud.library.domain.Rental;
import com.crud.library.dto.RentalDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RentalMapper {

    public Rental mapToRental(final RentalDto rentalDto) {
        return new Rental(
                rentalDto.getId(),
                rentalDto.getRentalDate(),
                rentalDto.getReturnDate()
        );
    }

    public RentalDto mapToRentalDto(final Rental rental) {
        return new RentalDto(
                rental.getId(),
                rental.getRentalDate(),
                rental.getReturnDate()
        );
    }

    public List<RentalDto> mapToRentalDtoList(final List<Rental> rentalList) {
        return rentalList.stream()
                .map(this::mapToRentalDto)
                .toList();
    }
}
