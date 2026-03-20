package com.finalreview.booktrackerapi.readinglist;

import com.finalreview.booktrackerapi.book.Book;
import com.finalreview.booktrackerapi.book.BookRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadingListService {

    @Autowired
    private ReadingListRepository readingListRepository;

    @Autowired
    private BookRestRepository bookRestRepository;

    public ReadingList saveReadingList(ReadingList readingList) {
        return readingListRepository.save(readingList);
    }

    public Iterable<ReadingList> getReadingListForUserByUserName(String username) {
        return readingListRepository.getReadingListsByUser_Username(username);
    }

    public ReadingList addBookById(Long listId, Long bookId) {
        ReadingList list = readingListRepository.findById(listId)
                .orElseThrow(() -> new RuntimeException("Reading List not found with id: " + listId));
        Book book = bookRestRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));
        
        list.getBooks().add(book);
        return readingListRepository.save(list);
    }

    public ReadingList addBookByTitle(Long listId, String bookTitle,String authorName) {

        ReadingList list = readingListRepository.findById(listId)
                .orElseThrow(() -> new RuntimeException("Reading List not found with id: " + listId));
        
        List<Book> books = bookRestRepository.findBookByTitleAndAuthor(bookTitle,authorName );
        if (books.isEmpty()) {
            throw new RuntimeException("No book found containing title: " + bookTitle);
        }
        
        // Add the first matching book
        list.getBooks().add(books.get(0));
        return readingListRepository.save(list);
    }
}
