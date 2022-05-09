package guru.springframework.spring5webapp.domain;

import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GeneratorType.AUTO)
    private Long id;

    private String title;
    private String isbn;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), 
        inverseJoinColumn = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    // TODO: Add getters and setter
    public Book() {}

    public Book(String title, String isbn, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.author = authors;
    }

    // TODO: Add toString
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
    
        Book book = (Book) o;

        return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}