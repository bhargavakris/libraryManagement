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
        Optional<Book> book = booksService.findBookById(id);
        if (book.isPresent()){
            return ResponseEntity.ok().body(book.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add-book")
    public void saveBook(@Validated @RequestBody Book book) {
        booksService.createBook(book);
    }

    @PutMapping("/update-book/{id}")
    public void updateBook(@PathVariable(value="id") Long id, @Validated @RequestBody Book book){
        Optional<Book> bookById = booksService.findBookById(id);
        booksService.updateBook(book);
    }
    @DeleteMapping("/remove-book/{id}")
    public void deleteBook(@PathVariable(value = "id") Long id){
        booksService.deleteBook(id);
    }

    @PutMapping("/return-book/{id}")
    public String returnBook(@PathVariable(value="id") Long id){
       return booksService.updateReturnedBookQuantity(id);
    }

    @PutMapping("/rented-book/{id}")
    public String rentedBook(@PathVariable(value="id") Long id){
        return booksService.updateRentedBookQuantity(id);
    }
}
