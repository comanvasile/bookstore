package service;

import model.Book;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public interface BookService {
    Book save(Book book);

    Book findById(Long id);

    void delete(Long id);

    List<Book> findAll();



    }
