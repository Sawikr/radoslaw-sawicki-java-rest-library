package com.crud.library.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@AllArgsConstructor - must be disable
@NoArgsConstructor
@Entity
@Table(name = "titles")
public class BookTitle {

    private Long id;
    private List<Book> book = new ArrayList<>();

    public BookTitle(Long id, String bookTitle, String author, LocalDate publicationDate) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "bookTitle",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Book> getBook() {
        return book;
    }

    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "author")
    private String author;

    @Column(name = "publication_date")
    private LocalDate publicationDate;
}
