package repository;

import model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();

    Book findById(Long id);

    Book create(Book book);

    Book update(Book book);

    boolean deleteById(Long id);


}
