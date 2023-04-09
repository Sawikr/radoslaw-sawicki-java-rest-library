package com.crud.library.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

/**
 * @apiNote It's working only code with field (@OneToMany)
 */

@Getter
@Setter
//@AllArgsConstructor - must be disable
@NoArgsConstructor
@Entity
@Table(name = "titles")
public class BookTitle {

    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "bookTitleList",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Book> book = new ArrayList<>();

    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true)
    private Long id;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "author")
    private String author;

    @Column(name = "publication_date")
    private Date publicationDate;

    public BookTitle(String bookTitle, String author, Date publicationDate) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publicationDate = publicationDate;
    }
}