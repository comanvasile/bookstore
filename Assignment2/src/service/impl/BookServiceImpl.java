package service.impl;

import model.Book;
import repository.BookRepository;
import service.BookService;

import java.util.ArrayList;
import java.util.List;



public class BookServiceImpl  implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    @Override
    public Book save(Book book) {
        if(book.getId()!=null){
            return bookRepository.update(book);
        }
        else{
            return bookRepository.create(book);
        }
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }




}
