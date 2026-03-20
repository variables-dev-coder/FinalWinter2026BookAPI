package com.finalreview.booktrackerapi.book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.validator.constraints.Length;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String title;
    private String author;
    private String bookDescription;
    @Length(max = 1000)
    private String imageUrl;
    private String genre;

    public Book(Long bookId, String title, String author, String bookDescription, String imageUrl, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.bookDescription = bookDescription;
        this.imageUrl = imageUrl;
        this.genre = genre;
    }

    public Book(String title, String author, String bookDescription, String imageUrl, String genre) {
        this.title = title;
        this.author = author;
        this.bookDescription = bookDescription;
        this.imageUrl = imageUrl;
        this.genre = genre;
    }

    public Book() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
