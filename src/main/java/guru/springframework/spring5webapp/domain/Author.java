package guru.springframework.spring5webapp.domain;

import java.util.Set;

@Entity
public class Author {

    @Id
    @GenerateValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author() {

    }

    public Author(String firstName, String lastName, Set<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    // TODO: Add getters and setter

    @Override
    public String toString() {
        return "Author(" + "id=" + id + ", firstName'" + firstName + '\'' + ", lastName'" + lastName + '\'' + ", books'" + books + '}'; 
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
    
        Author author = (Author) o;

        return id != null ? id.equals(author.id) : author.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    
}