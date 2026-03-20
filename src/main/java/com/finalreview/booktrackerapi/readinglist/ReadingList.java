package com.finalreview.booktrackerapi.readinglist;

import com.finalreview.booktrackerapi.book.Book;
import com.finalreview.booktrackerapi.user.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class ReadingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long readingListId;


    private String readingListType;

    @ManyToMany
    private List<Book> books;
    @ManyToOne
    private User user;

    public ReadingList(Long readingListId, String readingListType) {
        this.readingListId = readingListId;
        this.readingListType = readingListType;
        this.books = new ArrayList<>();
        this.user = null;
    }

    public ReadingList(String readingListType) {
        this.readingListType = readingListType;
        this.books = new ArrayList<>();
        this.user = null;
    }

    public ReadingList() {
    }

    public Long getReadingListId() {
        return readingListId;
    }

    public void setReadingListId(Long readingListId) {
        this.readingListId = readingListId;
    }

    public String getReadingListType() {
        return readingListType;
    }

    public void setReadingListType(String readingListType) {
        this.readingListType = readingListType;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
