package mate.academy.boot.hellobootdemo.controller;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import mate.academy.boot.hellobootdemo.dto.BookDto;
import mate.academy.boot.hellobootdemo.dto.BookDtoUtil;
import mate.academy.boot.hellobootdemo.entity.Book;
import mate.academy.boot.hellobootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> allBooks() {
        return bookService.findAll();
    }

    @PostMapping
    public void add(@RequestBody BookDto bookDto) {
        Book book = BookDtoUtil.createBookFromDto(bookDto);
        bookService.save(book);
    }

    @GetMapping("/{bookId}")
    public Book getById(@PathVariable("bookId") Long id) {
        return bookService.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Could not find book with id=" + id));

    }

    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable("bookId") Long id) {
        bookService.delete(id);
    }

    @PutMapping("/{bookId}")
    public Book update(@PathVariable("bookId") Long bookId, BookDto bookDto) {
        Book book = BookDtoUtil.createBookFromDto(bookDto);
        return bookService.update(bookId, bookDto).get();
    }
}
