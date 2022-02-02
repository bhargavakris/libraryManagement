package com.Bhargav.libraryManagement.controller;

import com.Bhargav.libraryManagement.model.Book;
import com.Bhargav.libraryManagement.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping
    public List<Book> findAllBooks(){
        return booksService.findAllBooks();
    }
    @GetMapping("book/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable(value = "id") long id) {
       return  booksService.findBookById(id);
    }

    @PostMapping("/add-book")
    public ResponseEntity<Book> saveBook(@Validated @RequestBody Book book) {
       return  booksService.createBook(book);
    }

    @PutMapping("/update-book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value="id") Long id, @Validated @RequestBody Book book){
        return booksService.updateBook(id,book);
    }
    @DeleteMapping("/remove-book/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "id") Long id){
        booksService.deleteBook(id);
        return ResponseEntity.ok("Delete the book with Id: "+id+ " successfully");
    }

}
