package com.crud.library.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rentals")
public class Rental {

    @OneToOne
    @JoinColumn(name = "book_title_id")
    private Book book;

    @OneToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "rental_date")
    private LocalDate rentalDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    public Rental(Long id, LocalDate rentalDate, LocalDate returnDate) {
        this.id = id;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }
}