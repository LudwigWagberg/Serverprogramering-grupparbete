package se.yrgo.library.data;

import se.yrgo.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    public Book findByTitle(String title);
}
