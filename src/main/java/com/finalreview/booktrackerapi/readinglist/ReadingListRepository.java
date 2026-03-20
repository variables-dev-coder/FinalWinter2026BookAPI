package com.finalreview.booktrackerapi.readinglist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingListRepository extends JpaRepository<ReadingList, Long> {

    Iterable<ReadingList> getReadingListsByUser_Username(String userUsername);
}
