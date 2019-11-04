package mate.academy.boot.hellobootdemo.dto;

import mate.academy.boot.hellobootdemo.entity.Book;

public class BookDtoUtil {
    public static Book createBookFromDto(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setPrice(bookDto.getPrice());
        book.setYear(bookDto.getYear());
        return book;
    }
}
