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

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title_id")
    private Long title_id;

    @Column(name = "status")
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_title_id", unique = true)
    private BookTitle bookTitle;

    public Book(Long id, Long title_id, String status) {
        this.id = id;
        this.title_id = title_id;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}