package dev.nr.onlinebookstore.bookservice.repository;

import dev.nr.onlinebookstore.bookservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
