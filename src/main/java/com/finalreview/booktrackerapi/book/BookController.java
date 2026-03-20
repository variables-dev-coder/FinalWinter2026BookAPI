package com.finalreview.booktrackerapi.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/createBook")
    public ResponseEntity<Book> saveNewBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.saveBook(book));
    }
    @GetMapping("/getAllBooks")
    public ResponseEntity<Iterable<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @GetMapping("/getBookById/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }
    @GetMapping("/searchByTitle/{title}")
    public ResponseEntity<Iterable<Book>> searchBooksByTitle(@PathVariable String title) {
        return ResponseEntity.ok(bookService.searchBooksByTitle(title));
    }
    @DeleteMapping("/deleteBook/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
    }


}
