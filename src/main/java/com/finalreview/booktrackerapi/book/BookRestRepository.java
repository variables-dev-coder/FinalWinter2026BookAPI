package com.finalreview.booktrackerapi.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRestRepository extends JpaRepository<Book, Long> {
    List<Book> findBookByTitleAndAuthor(String title,String author);
}
