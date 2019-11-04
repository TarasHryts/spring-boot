package mate.academy.boot.hellobootdemo.service.impl;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.hellobootdemo.entity.Book;
import mate.academy.boot.hellobootdemo.repository.BookRepository;
import mate.academy.boot.hellobootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book update(Long bookId, Book book) {
        Book bookToChange = bookRepository.findById(bookId).get();
        bookToChange = book;
        return bookRepository.save(bookToChange);
    }
}
