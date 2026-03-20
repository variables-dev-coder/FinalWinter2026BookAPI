package com.finalreview.booktrackerapi.readinglist;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/readingList")
public class ReadingListController {

    @Autowired
    private ReadingListService readingListService;

    public ReadingListController(ReadingListService readingListService) {
        this.readingListService = readingListService;
    }

    @GetMapping("/getReadingListForUserByUserName/{username}")
    public Iterable<ReadingList> getReadingListForUserByUserName(@PathVariable String username) {
        return readingListService.getReadingListForUserByUserName(username);
    }
    @PostMapping("/createReadingList")
    public ReadingList createReadingList(@RequestBody ReadingList readingList) {
        return readingListService.saveReadingList(readingList);
    }
    @PostMapping("/{listId}/addBook/{bookId}")
    public ReadingList addBookById(@PathVariable Long listId, @PathVariable Long bookId) {
        return readingListService.addBookById(listId, bookId);
    }
    @PostMapping("/{listId}/addBookByTitleAndAuthor")
    public ReadingList addBookByTitle(@PathVariable Long listId, @RequestParam String bookTitle, @RequestParam String authorName)  {
        return readingListService.addBookByTitle(listId, bookTitle,authorName);
    }

}
