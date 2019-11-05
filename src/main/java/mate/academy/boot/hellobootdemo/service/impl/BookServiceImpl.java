package mate.academy.boot.hellobootdemo.service.impl;

import java.util.List;
import java.util.Optional;
import mate.academy.boot.hellobootdemo.dto.BookDto;
import mate.academy.boot.hellobootdemo.dto.BookDtoUtil;
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
    public Optional<Book> update(Long bookId, BookDto bookDto) {
        if (bookRepository.existsById(bookId)) {
            Book book = BookDtoUtil.createBookFromDto(bookDto);
            book.setId(bookId);
            bookRepository.save(book);
            return Optional.of(book);
        }
        return Optional.empty();
    }
}
