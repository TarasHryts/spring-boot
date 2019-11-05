package mate.academy.boot.hellobootdemo.controller;

import javax.annotation.PostConstruct;
import mate.academy.boot.hellobootdemo.entity.Book;
import mate.academy.boot.hellobootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    @Autowired
    private BookService bookService;

    @PostConstruct
    public void initializeData() {
        saveBooks();
    }

    private void saveBooks() {
        Book kobzar = new Book("Kobzar", 250.0, 2018);
        bookService.save(kobzar);
        Book lisovaPisnya = new Book("Lisova Pisnya", 200.0, 2001);
        bookService.save(lisovaPisnya);
        Book bukvar = new Book("Bukvar", 500.0, 2011);
        bookService.save(bukvar);
        Book fightClub = new Book("Fight Club", 270.0, 1996);
        bookService.save(fightClub);
    }
}
