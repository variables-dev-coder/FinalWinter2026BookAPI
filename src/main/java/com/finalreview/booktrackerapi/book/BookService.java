package com.finalreview.booktrackerapi.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRestRepository bookRestRepository;

    public Iterable<Book> getAllBooks() {
        return bookRestRepository.findAll();
    }

    public Book getBookById(Long bookId) {
        return bookRestRepository.findById(bookId).orElse(null);
    }
    public Book saveBook(Book book) {
        if(book.getTitle().isEmpty() || book.getAuthor().isEmpty() || book.getBookDescription().isEmpty() || book.getImageUrl().isEmpty() || book.getGenre().isEmpty()) {
            throw new IllegalArgumentException("All fields must be filled out");
        }
        return bookRestRepository.save(book);
    }
    public Iterable<Book> searchBooksByTitle(String title) {
        // Keeping it simple for the search endpoint, or you can add author too.
        return bookRestRepository.findBookByTitleAndAuthor(title, ""); 
    }
    public void deleteBook(Long bookId) {
        bookRestRepository.deleteById(bookId);
    }

}
