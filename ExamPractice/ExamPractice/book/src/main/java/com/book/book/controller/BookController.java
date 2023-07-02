package com.book.book.controller;

import com.book.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getbook")
    public ResponseEntity<List<Book>> getAllBook() {
        String url = "http://localhost:8081/api/library/getbook";
        List<Book> output = restTemplate.getForObject(url, List.class);
        return ResponseEntity.ok(output);
    }
    @PostMapping("/addbook")
    public ResponseEntity<Book> addBook(@RequestBody Book book)
    {
        String url = "http://localhost:8081/api/library/createbook";
        Book response = restTemplate.postForEntity(url, book, Book.class).getBody();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/get/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
        String url = "http://localhost:8081/api/library/getbook/{bookId}";
        Book b = restTemplate.getForObject(url, Book.class, bookId);
        return ResponseEntity.ok(b);
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody Book updatedBook) {
        String url = "http://localhost:8081/api/library/updatebook/{bookId}";
        restTemplate.put(url, updatedBook, bookId,Book.class);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
        String url = "http://localhost:8081/api/library/deletebook/{bookId}";
        restTemplate.delete(url, bookId,Book.class);
        return ResponseEntity.ok("Book deleted successfully");
    }



}
