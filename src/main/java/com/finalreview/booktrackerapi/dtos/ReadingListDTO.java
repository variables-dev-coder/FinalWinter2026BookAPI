package com.finalreview.booktrackerapi.dtos;

import com.finalreview.booktrackerapi.book.Book;

import java.util.List;

public record ReadingListDTO(
         String userName,
         List<Book> books
) {}
