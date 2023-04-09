package com.crud.library.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor - must be disable!
@NoArgsConstructor
@Entity(name = "books")
public class Book {

    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_title_list_id")
    private BookTitle bookTitleList;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "status")
    private String status;

    public Book(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /*
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_title_id")
    private BookTitle bookTitle;
    */
}